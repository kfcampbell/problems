import java.util.*;

public class TVTower
{
	// takes in two arrays with x- and y-coordinates and returns the minimum broadcasting radius required to reach all towns.
	public static double minRadius(int[] x, int[] y)
	{
		// variable declarations
		double townX;
		double townY;
		double tempTotalX = 0;
		double tempTotalY = 0;
		double farthestDistance = 0;

		// if x.length == y.length == 1, then can just return zero because you can locate the tower right in the town.
		if(x.length == 1)
		{
			System.out.println("Only one town, so radius = 0.");
			return 0.0;
		}

		// the Thomas George strategy: find the two points that are farthest apart and situate the TVTower between them.
		// this method doesn't require calculating the exact position of the TVTower, which is neat.

		// initialize an array to hold the two points
		int[] points = {0, 0, 0, 0};
		double dist = 0.0;
		for(int i = 0; i < x.length; i++)
		{
			for(int j = 0; j < y.length; j++)
			{
				if(distance(x[i], y[i], x[j], y[j]) > dist)
				{
					points = new int[] {x[i], y[i], x[j], y[j]};
					dist = distance(x[i], y[i], x[j], y[j]);
				}
			}
		}

		System.out.println("Farthest points: (" + points[0] + "," + points[1] + ") - (" + points[2] + "," + points[3] + ").");
		System.out.println("Minimum Radius: " + dist/2);
		return dist/2;
	}

	// helper function that takes 4 points and returns the distance between them
	public static double distance(double avgX, double avgY, double ix, double iy)
	{
		// variable to hold the distance between the points
		double pointDist = 0;

		// find the difference in x and y
		double dx = Math.abs((ix - avgX)*(ix - avgX));
		double dy = Math.abs((iy - avgY)*(iy - avgY));

		// get the square root
		pointDist = Math.sqrt(dx + dy);

		//System.out.println("Distance:" + pointDist + ". (" + avgX + "," + avgY + ") - (" + ix + "," + iy + ").");
		return pointDist;
	}

	// main function for testing
	public static void main(String[] args)
	{
		//int[] x = {1, 0, -1, 0};
		//int[] y = {0, 1, 0, -1};
		//int[] x = {3};
		//int[] y = {299};
		int[] x = {5, 3, -4, 2};
		int[] y = {0, 4, 3, 2};

		minRadius(x, y);
	}
}