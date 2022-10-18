/* Author: Sarah Grady
 * Date of initialization: February 7, 2022
 * Date of Completion: February 14, 2022
 * Purpose: To practice application of while loops and for loops and become more familiar with Java's graphics programs. 
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

public class StarsAndStripes {
	// draws an American flag with differing amounts of stripes and stars
	public static void drawFlag(int stars, int stripes, java.awt.Graphics g, int x, int y, int width, int height) {
		// sets up blank screen
		g.setColor(Color.WHITE);
		g.fillRect(x, y, width, height);
		// draws red stripes
		int yStripe = y;
		int sHeight = height / stripes;
		int redStripes = (int) Math.ceil((double) stripes / 2.0);
		for (int i = 0; i < redStripes; i++) {
			g.setColor(Color.RED);
			
			yStripe = yStripe + sHeight * 2;
		
		// ensures last stripe reaches bottom of flag
		
		if (redStripes % 2 != 0 && i == redStripes - 1) {
			int sHeightTemp = height - (sHeight * (stripes));
			g.fillRect(x, yStripe, width, sHeightTemp + sHeight);
		}
		else {
			g.fillRect(x, yStripe , width, sHeight);
		}
		}
		
		// draws star field 
		int starfieldHeight = sHeight * redStripes;
		int starfieldWidth = (starfieldHeight * width / height);
		g.setColor(Color.BLUE);
		g.fillRect(x, y, starfieldWidth, starfieldHeight);
		// determines the arrangement of stars
		int columns = 0;
		double rows = 0;
		int i = 1;
		while (columns == 0) {
			int remainder = stars % i;
			rows = (double) stars / (double) i;
			if (remainder == 0 && rows > i && rows < 2 * i) {
				columns = i;
			}
			i++;
		}
		// determines the size of each star
		int size = 0;
		int starHeight = starfieldHeight / columns;
		int starWidth = starfieldWidth / (int) rows;
		if (starHeight > starWidth) {
			size = starWidth;
		} else {
			size = starHeight;
		}
		// determines the offset of star grid to center it
		double blankSpace = (double) starfieldWidth - (double) size * rows;
		int offset = (int) blankSpace / 2;
		int yCoordinate = y;
		for (int c = 1; c <= columns; c++) { // controls the row that stars are being drawn
			int xCoordinate = x + offset;
			for (int r = 1; r <= rows; r++) { // controls the column that stars are being drawn
				drawStar(g, xCoordinate, yCoordinate, size);
				xCoordinate = xCoordinate + size;
			}
			yCoordinate = yCoordinate + size;
		}
	}

	// draws an individual star 
	public static void drawStar(java.awt.Graphics g, int x, int y, int size) {
		int point1X = x + size / 2;
		int point2X = x + size / 5;
		int point2Y = y + size;
		int point3X = x + size;
		int point3Y = y + 2 * size / 5;
		int point4Y = y + 2 * size / 5;
		int point5X = x + 4 * size / 5;
		int point5Y = y + size;
		g.setColor(Color.WHITE);
		g.drawLine(point1X, y, point2X, point2Y);
		g.drawLine(point2X, point2Y, point3X, point3Y);
		g.drawLine(point3X, point3Y, x, point4Y);
		g.drawLine(x, point4Y, point5X, point5Y);
		g.drawLine(point5X, point5Y, point1X, y);
	}

	// Only alter the "drawFlag" part of the paintComponent
	// code to call it in different ways. You can also test
	// drawing multiple flags at once!
	public static void main(String[] args) {
		JFrame window = new JFrame("Graphics window");
		window.setLocationByPlatform(true);
		final JLabel coords = new JLabel(" ");
		@SuppressWarnings("serial")
		final JPanel panel = new JPanel() {

			protected void paintComponent(Graphics gx) {
				coords.setText(" ");
				Graphics2D g = (Graphics2D) gx;
				int width = getWidth();
				int height = getHeight();
				g.setBackground(Color.GREEN); // To make sure you cover the base rectangle!
				g.clearRect(0, 0, width, height);
				g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				g.setColor(Color.BLACK);

				// You could alter this code to try different flags!
				drawFlag(15, 13, g, 0, 0, width/2, height/2);
				drawFlag(20, 14, g, width/2, 0, width/2, height/2);
				drawFlag(24, 15, g, 0, height/2, width/2, height/2);
				drawFlag(48, 16, g, width/2, height/2, width/2, height/2);

			}
		};
		panel.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseMoved(MouseEvent e) {
				coords.setText(e.getX() + ", " + e.getY());
			}

		});
		window.setLayout(new BorderLayout());
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		window.setSize(d.width / 2, d.height / 2);

		JPanel coordPanel = new JPanel();
		coordPanel.setLayout(new BorderLayout());
		coordPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));
		window.add(coordPanel, BorderLayout.SOUTH);
		coordPanel.add(coords, BorderLayout.WEST);

		window.setBackground(Color.WHITE); // To make sure you cover the base rectangle!
		panel.setBackground(Color.BLACK);
		window.add(panel, BorderLayout.CENTER);
		// window.setContentPane(panel);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
