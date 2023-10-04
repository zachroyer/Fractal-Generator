package a04;

import java.awt.Color;

import edu.princeton.cs.algs4.StdDraw;

/*
 * A Serpinski Triangle modular generator
 * Inspired by The Legend of Zelda Triforce
 * 
 * @author Zach Royer
 * 
 */
public class MyFractal {

	/*
	 * Method to draw one shape of the larger fractal whole with positional
	 * parameters
	 * 
	 * @param x-coordinate array
	 * 
	 * @param y-coordinate array
	 * 
	 * @param size of triangle
	 */
	private static void drawTriangle(double x[], double y[], Color color) {

		StdDraw.setPenColor(color);
		StdDraw.filledPolygon(x, y);
	}

	/*
	 * Recursive method to draw fractal shape with 'n' number of branches
	 * 
	 * @param n number of subfractals to draw
	 * 
	 * @param x-coordinate
	 * 
	 * @param y-coordinate
	 * 
	 * @param size of fractal
	 */

	public static void drawNextOrder(int n, double x, double y, double halfSize, int level) {
		// Bottom Left triangle
		drawRecursively(n - 1, x - halfSize / 2, y - halfSize / 2, halfSize, level);
		// Bottom right triangle
		drawRecursively(n - 1, x + halfSize / 2, y - halfSize / 2, halfSize, level + 1);
		// Top middle triangle
		drawRecursively(n - 1, x, y + halfSize / 2, halfSize, level + 1);
	}

	public static void setTriangleDimensions(double[] xarr, double[] yarr) {
		xarr[0] += ((xarr[1] - xarr[0]) / 2);
		xarr[2] -= ((xarr[2] - xarr[1]) / 2);

		double tempy = yarr[0];
		yarr[0] += ((yarr[1] - yarr[0]) / 2);
		yarr[1] = tempy;
		yarr[2] = yarr[0];
	}

	public static void drawRecursively(int n, double x, double y, double size, int level) {
		if (n <= 0)
			return;

		double halfSize = size / 2;
		double[] xarr = new double[] { x - halfSize, x, x + halfSize };
		double[] yarr = new double[] { y - halfSize, y + halfSize, y - halfSize };

		// If at the base level, draw the smaller yellow triangle inside
		if (level == 0) {
			// Draw the black triangle
			drawTriangle(xarr, yarr, StdDraw.BLACK);
			setTriangleDimensions(xarr, yarr);
			drawTriangle(xarr, yarr, StdDraw.YELLOW);
			level += 1;
			drawNextOrder(n, x, y, halfSize, level);
		} else {
			setTriangleDimensions(xarr, yarr);
			drawTriangle(xarr, yarr, StdDraw.YELLOW);
			level += 1;
			drawNextOrder(n, x, y, halfSize, level);
		}
	}

	/*
	 * Reads an integer command-line argument n and plots an order n Serpinski
	 * Triangle If n == 2, The Legend of Zelda Triforce will be displayed
	 *
	 */
	public static void main(String[] args) {
		int n = 6;
		double x = 0.5, y = 0.5; // center of H-tree
		double size = 1; // side length of H-tree
		for (int i = 1; i <= n; i++) {
			drawRecursively(i, x, y, size, 0);
			StdDraw.pause(2000);
		}

	}

}
