import java.util.Scanner;

/*
 *Author: Sarah Grady
 *Date of initialization: February 16, 2022
 *Date of completion: March 4, 2022
 *Purpose: To become familiar using strings, arrays, and logic cohesiveness to create a board game. 
 */
public class CricketsAndGrasshoppers {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int max = 10;
		String prompt = "Please enter the number of pieces for each player (1-" + max + "): ";
		int piecesPerPlayer = promptNumberReadLine(s, prompt, max);
		max = 9;
		prompt = "Please enter the number of spaces in the middle (1-" + max + "): ";
		int spaces = promptNumberReadLine(s, prompt, max);
		int[] gameBoard = createBoard(piecesPerPlayer, spaces);
		int position = 1;
		int player = 1;
		while (canMove(gameBoard, player)) { // while moves are possible: 
			System.out.println(boardToString(gameBoard));
			if (player == 1) {
				position = promptNumberReadLine(s,
						"Crickets, please enter your move (1-" + gameBoard.length + "): ", gameBoard.length);
			} else {
				position = promptNumberReadLine(s,
						"Grasshoppers, please enter your move (1-" + gameBoard.length + "): ",
						gameBoard.length);
			}
			if (move(gameBoard, player, position)) { // switching player after possible move is made
				if (player == 1) {
					player = 2;
				} else {
					player = 1;
				}
			} else {
				System.out.println("That space does not contain a piece you can move! Please try again.");
			}
		}
		if (player == 1) { // completed game
			System.out.println("Grasshoppers win!");
		} else {
			System.out.println("Crickets win!");
		}
	}

	public static int promptNumberReadLine(Scanner s, String prompt, int max) { // method for game prompts
		int piecesNumber = 0;
		while (true) {
			System.out.println(prompt);
			if (s.hasNextInt()) { // ensures input for pieces number is a number not word
				piecesNumber = s.nextInt();
				if ((piecesNumber >= 1) && (piecesNumber <= max)) {
					return piecesNumber;
				} else {
					System.out.println("That was not a valid number! Please try again.");
					s.nextLine();
				}
			} else {
				System.out.println("That was not a valid number! Please try again.");
				s.nextLine();
			}
		}
	}

	public static int[] createBoard(int piecesPerPlayer, int spacesInMiddle) { // assigning useable values to players
																				// and spaces
		int[] gameBoard = new int[piecesPerPlayer * 2 + spacesInMiddle];
		for (int i = 0; i < piecesPerPlayer; i++) { // crickets
			gameBoard[i] = 1;
		}
		for (int i = piecesPerPlayer; i < spacesInMiddle + piecesPerPlayer; i++) { // empty spaces
			gameBoard[i] = 0;
		}
		for (int i = spacesInMiddle + piecesPerPlayer; i < gameBoard.length; i++) { // grasshoppers
			gameBoard[i] = 2;
		}
		return gameBoard;
	}

	public static String boardToString(int[] board) { // creating string for board to print out
		String boardString = "";
		for (int i = 0; i < board.length; i++) {
			if (board[i] == 1) {
				boardString = boardString + 'C'; // crickets
			}
			if (board[i] == 0) {
				boardString = boardString + '.'; // empty spaces
			}
			if (board[i] == 2) {
				boardString = boardString + 'G'; // grasshoppers
			}
		}
		return boardString;
	}

	public static boolean canMove(int[] board, int player) { // method returns true if move is possible
		if (player == 1) { // crickets
			for (int i = 0; i < board.length; i++) { // moving right across gameboard
				if (player == board[i]) {
					if ((i + 1 < board.length) && (board[i + 1] == 0)) { // can move if space one to right is open
						return true;
					}
					if (((i + 2 < board.length) && (i + 1 < board.length))
							&& ((board[i + 1] == 2) && (board[i + 2] == 0))) { // jumping
						return true;
					}
				}
			}
			return false;
		} else { // grasshoppers
			for (int i = board.length - 1; i >= 0; i--) { // moving left across gameboard
				if (player == board[i]) {
					if ((i - 1 >= 0) && (board[i - 1] == 0)) { // can move if space one to right is open
						return true;
					}
					if (((i - 2 >= 0) && (i - 1 >= 0)) && ((board[i - 2] == 0) && (board[i - 1] == 1))) { // jumping
						return true;
					}
				}
			}
			return false;
		}
	}

	public static boolean move(int[] board, int player, int position) { // method for changing player positions
		position = position - 1; // players mind is 1 based index but array is 0 based index
		if ((position >= board.length) || (position < 0)) { // staying within board bounds
			return false;
		}
		if (player != board[position]) { // ensuring player is in valid position
			return false;
		}
		if (player == 1) { // crickets moving right
			if ((position + 1 < board.length) && (board[position + 1] == 0)) { // moving to open space right
				board[position + 1] = 1;
				board[position] = 0;
				return true;
			}
			if (((position + 1 < board.length) && (position + 2 < board.length))
					&& ((board[position + 1] == 2) && (board[position + 2] == 0))) { // jumping
				board[position] = 0;
				board[position + 2] = 1;
				return true;
			}
		} else { // grasshoppers moving left
			if ((position - 1 >= 0) && (board[position - 1] == 0)) { // moving to open space left
				board[position - 1] = 2;
				board[position] = 0;
				return true;
			}
			if (((position - 1 >= 0) && (position - 2 >= 0))
					&& ((board[position - 1] == 1) && board[position - 2] == 0)) { // jumping
				board[position] = 0;
				board[position - 2] = 2;
				return true;
			}
		}
		return false;
	}

}
