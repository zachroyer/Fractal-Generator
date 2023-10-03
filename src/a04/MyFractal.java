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

	final int level = 0;

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

	public static void draw(int n, double x, double y, double size, int level) {

		if (n <= 0)
			return;

		// Initial triangle, base of the Serpinski triangle
		if (level == 0)
		{
			double[] xarr = new double[] { x - 0.38, x, x + 0.38 };
			double[] yarr = new double[] { y - 0.1, y + 0.45, y - 0.1 };
			drawTriangle(xarr, yarr, StdDraw.BLACK);

			xarr[0] += ((xarr[1] - xarr[0]) / 2);
			xarr[2] -= ((xarr[2] - xarr[1]) / 2);

			double tempy = yarr[0];
			yarr[0] += ((yarr[1] - yarr[0]) / 2);
			yarr[1] = tempy;
			yarr[2] = yarr[0];

			drawTriangle(xarr, yarr, StdDraw.YELLOW);
		} else {


		}

//		// compute x- and y-coordinates of the 3 half-size triangles
//		double x0 = x - size / 2;
//		double x1 = x + size / 2;
//		double y0 = y - size / 2;
//		double y1 = y + size / 2;

		// Size of each smaller triangle
		double newSize = size / 2;
		
		// Compute the coordinates of the three smaller triangles
		// and recursively draw them.

		// Bottom left triangle
		draw(n - 1, x - newSize / 2, y - newSize / 2, newSize, level - 1);

		// Bottom right triangle
		draw(n - 1, x + newSize / 2, y - newSize / 2, newSize, level - 1);

		// Top middle triangle
		draw(n - 1, x, y + newSize / 2, newSize, level - 1);
//		// recursively draw 3 half-size triangles of order n-1
//		draw(n - 1, x0, y0, size / 2, level + 1); // lower left H-tree
//		draw(n - 1, x0, y1, size / 2, level + 1); // upper left H-tree
//		draw(n - 1, x1, y0, size / 2, level + 1); // lower right H-tree

	}

	/*
	 * Reads an integer command-line argument n and plots an order n Serpinski
	 * Triangle If n == 2, The Legend of Zelda Triforce will be displayed
	 *
	 */
	public static void main(String[] args) {
		int n = 3;
		double x = 0.5, y = 0.5; // center of H-tree
		double size = 0.5; // side length of H-tree
		for (int i = 1; i <= n; i++) {
			draw(i, x, y, size, 0);
			StdDraw.pause(2000);
		}
	}

}
