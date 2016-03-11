import java.util.*;

public class PowerOfThree
{ // this is problem #326.
    public static boolean isPowerOfThree(int n)
    {
      // I wrote a couple of solutions for this to see which performed best.
      // They're organized from quickest -> slowest according to LeetCode's submission times.

      
      // ATTEMPT A SLIGHTLY MORE EFFICIENT SOLUTION
      // using the fact that if log10(n)/log10(3) is an integer, n is a power of 3.
      return (Math.log10((double)n) / Math.log10(3)) % 1 == 0; // % 1 is a check to make sure the number is an int.

      // MAYBE REPEATED DIVISION IS FASTER THAN REPEATED MULTIPLICATION?
      /*
      while (n % 3 == 0) // check for divisibility by 3
      {
        n /= 3; // if it is divisible, then divide it
      }
      return n == 1; // eventually, we're going to get down to n == 3. then we divide by 3 one more time to get one.
      */

      // BORING, NOT MOST EFFICIENT SOLUTION USING REPEATED MULTIPLICATION
      /*int x = 3;
      while(x <= n) // if the number we made is bigger than n, then it's time to call it quits.
      {
        if(x == n) // if we made our 3 into n then n is a power of 3.
        {
          return true;
        }
        x *= 3; // otherwise do another multiply and try again.
      }
      return false;*/
    }

    public static void main(String[] args)
    {
      System.out.println("Test of 27: " + isPowerOfThree(27));
      System.out.println("Test of 28: " + isPowerOfThree(28));
    }
}
