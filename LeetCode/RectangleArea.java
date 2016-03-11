import static java.lang.Math.*; // for max/min functions
import java.util.Arrays; // for array sorting

public class RectangleArea
{
    public static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H)
    {
      // first calculate the area of the first triangle
      // given by points LL: (A,B) and UR: (C,D)
      int firstX = C - A;
      int firstY = D - B;
      int firstA = firstX * firstY;

      // now calculate the area of the second triangle
      // given by points LL: (E,F) and UR: (G,H)
      int secondX = G - E;
      int secondY = H - F;
      int secondA = secondX * secondY;

      // variables for overlap calculation
      int thirdX = 0; // length of X overlap
      int thirdY = 0; // length of Y overlap
      int thirdA = 0; // area of overlap
      int LLX = 0; // lower left X of overlap
      int URX = 0; // upper right X of overlap
      int LLY = 0; // lower left Y of overlap
      int URY = 0; // upper right Y of overlap

      // now calculate the area of the overlap. to make strict overlap, remove the = signs.
      if(((A <= E && E <= C) || (E <= A && A <= G)) && ((B <= F && F <= D) || (F <= B && B <= H)))
      {
        int[] xs = {A, C, E, G}; // array of x values
        int[] ys = {B, D, F, H}; // array of y values
        Arrays.sort(xs); // sort them in ascending order
        Arrays.sort(ys); // sort them in ascending order

        // ignore extreme points when looking for overlap
        LLX = xs[1]; // 2nd highest x value
        URX = xs[2]; // 3rd highest x value
        LLY = ys[1]; // 2nd highest y value
        URY = ys[2]; // 3rd highest y value
      }

      thirdX = URX - LLX; // get the X length of overlap
      thirdY = URY - LLY; // get the Y length of overlap
      thirdA = thirdX * thirdY; // get the area of overlap

      int totalA = (firstA + secondA) - thirdA; // now calculate the total area

      // printouts for debugging purposes
      System.out.println("Calculated area of triangle 1: " + firstA);
      System.out.println("Calculated area of triangle 2: " + secondA);
      System.out.println("Calculated area of overlap: " + thirdA);
      System.out.println("Calculated total area: " + totalA);

      if(firstA == 0) // if only the second rectangle has any area
      {
        return secondA;
      }
      else if(secondA == 0) // if only the first rectangle has any area
      {
        return firstA;
      }
      else if(A == E && B == F && C == G && D == H) // one rectangle is exactly on top of the other
      {
        return firstA;
      }
      else // if there's two rectangles that aren't the same that overlap
      {
        return totalA;
      }

    }

    public static void main(String[] args)
    {
      // a couple of test cases for debugging purposes
      System.out.println("Case 1: " + computeArea(-2, -2, 2, 2, 3, 3, 4, 4));
      System.out.println("Case 2: " + computeArea(-2, -2, 2, 2, -2, -2, 2, 2));
    }
}
