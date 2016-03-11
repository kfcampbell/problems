public class MinRotArray
{ // Problem #153: Find Minimum in Rotated Sorted Array
    public static int findMin(int[] nums)
    {
      // goal: implement binary search (O(n log n) expected efficiency)
      int leftIndex = 0; // hold the left index
      int rightIndex = nums.length - 1; // hold the right index
      while(leftIndex < rightIndex)
      {
        // find the midpoint. + leftIndex so we can split the array
        int midPoint = (rightIndex - leftIndex)/2 + leftIndex;

        // printouts for debugging purposes
        System.out.println("leftIndex: " + leftIndex + ", rightIndex: " + rightIndex + ", midPoint: " + midPoint);

        if(nums[midPoint] > nums[rightIndex]) // if we detect an inversion on the right side of the array
        {
          leftIndex = midPoint + 1; // then we search the right side of the array for the minimum element.
        }
        else // otherwise if we detect an inversion on the left side of the array
        {
          rightIndex = midPoint; // then we search the left side of the array for the minimum element.
        }
      }

      return nums[leftIndex];

      // BORING SOLUTION. It's O(n) efficiency worst case and O(n/2) efficiency on average.
      // however, this is much faster than my binary search solution above according to LeetCode. go figure.
      // things to take away: don't over-optimize a solution, and sometimes the simplest solution is the best.
      /*int min = nums[0];
      for(int i = 1; i < nums.length; i++)
      {
        if(nums[i] < min)
        {
          min = nums[i];
        }
      }
      return min;*/
    }

    public static void main(String[] args)
    {
      // basic test case.
      int[] test1 = {2,3,1};
      System.out.println("Test1: " + findMin(test1));
    }
}
