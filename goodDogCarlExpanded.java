/* 
 * Author: Sarah Grady
 * Date of Initialization: January 20, 2021
 * Date of Completion: January 20, 2021
 * Purpose: To become familiar and gain experience with Boolean logic inside Java.
 */
public class goodDogCarlExpanded {

	public static void main(String[] args) {
		int walkAmount = 50;
		int playAmount = 20;
		double foodAmount = 2;
		boolean isHappy = isCarlHappy(walkAmount, playAmount, foodAmount);

		System.out.print("If Carl has been walked for " + walkAmount + " minutes, played with for " + playAmount
				+ " minutes, and fed " + foodAmount + " cups of food, then he is ");
		if (isHappy == true) {
			System.out.println("happy.");
		} else {
			System.out.println("not happy.");
			whenCarlIsNotHappy(walkAmount, playAmount, foodAmount);
		}
	}

	public static boolean isCarlHappy(int walkAmount, int playAmount, double foodAmount) {
		boolean isHappy = false;

		// When the food is between 1-3, walking is between 30-60, and play is between 15-30 the statement is true.
		if (((foodAmount <= 3) && (foodAmount >= 1))
				&& (((walkAmount <= 60) && (walkAmount >= 30)) || ((playAmount <= 30) && (playAmount >= 15)))) 
			isHappy = true;
		
		// When Carl's play/walk time is greater than 75, Carl will never be happy.
		if ((playAmount + walkAmount > 75))
			isHappy = false;

		// When the play/walk time is less than 50 Carl will only be happy if food count is between 2-3.
		if ((((playAmount + walkAmount) <= 50)) && ((foodAmount <= 2) || (foodAmount >= 3))) 
			isHappy = false;
		
		return isHappy;
	}

	// Solutions for when Carl is not happy.
	public static void whenCarlIsNotHappy(int walkAmount, int playAmount, double foodAmount) {
		if (foodAmount < 1) 
			System.out.println("Carl needs more food.");
		
		if (foodAmount > 3) 
			System.out.println("Carl needs less food.");
		
		if (walkAmount + playAmount > 75) 
			System.out.println("Carl needs less walk/play time.");
		
		if (((playAmount + walkAmount) <= 50) && (foodAmount < 2)) 
			System.out.println("Carl needs more food.");
		
		if (((playAmount + walkAmount) <= 50) && (foodAmount > 3)) 
			System.out.println("Carl needs less food.");
		

	}
}
