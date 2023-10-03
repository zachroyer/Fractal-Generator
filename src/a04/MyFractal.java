package a04;

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
	private static void drawTriangle(double x[], double y[], double size) {
		StdDraw.setPenColor(StdDraw.YELLOW);
		StdDraw.filledPolygon(null, null);
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
	public static void draw(int n, double x, double y, double size) {

		if (n == 0)
			return;
		int initial = n;
		
		while (n )

		drawTriangle(x, y, size);

		// compute x- and y-coordinates of the 4 half-size H-trees
		double x0 = x - size / 2;
		double x1 = x + size / 2;
		double y0 = y - size / 2;
		double y1 = y + size / 2;

		// recursively draw 4 half-size H-trees of order n-1
		draw(n - 1, x0, y0, size / 2); // lower left H-tree
		draw(n - 1, x0, y1, size / 2); // upper left H-tree
		draw(n - 1, x1, y0, size / 2); // lower right H-tree

	}

	/*
	 * Reads an integer command-line argument n and plots an order n Serpinski Triangle 
	 * If n == 2, The Legend of Zelda Triforce will be displayed
	 *
	 */
	public static void main(String[] args) {
		int n = 8;
		double x = 0.5, y = 0.5; // center of H-tree
		double size = 0.5; // side length of H-tree
		for (int i = 1; i <= n; i++) {
			draw(i, x, y, size);
			StdDraw.pause(2000);
		}
	}

}
