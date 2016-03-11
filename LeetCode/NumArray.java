public class NumArray
{ // Problem #303.
  private final int[] sums;

  public NumArray(int[] nums)
  {
    if(nums == null) // if nums is null, we can just get out of here
    {
      sums = null; // only because of a compiler error if this isn't included
      return;
    }
    else // otherwise, we're good to start adding up
    {
      if(nums.length == 0) // if it's an instantiated array of length 0, we don't need to add anything
      {
        sums = null;
      }
      else
      {
        sums = new int[nums.length]; // otherwise make sums the same length as nums
        sums[0] = nums[0]; // so that we can start the for loop at i = 1 and use [i-1] without causing an error

        for(int i = 1; i < nums.length; i++)
        {
          sums[i] = sums[i-1] + nums[i]; // current sum is the sum of all previous numbers plus the current number
        }
      }
    }
  }

  public int sumRange(int i, int j)
  {
    if(sums == null || sums.length == 0) // if we have no sums, then there's nothing to return
    {
      return 0;
    }
    else if(i == 0) // if i == 0, we return the sum of the whole array up to that point
    {
      return sums[j];
    }
    else // if i != 0 we don't risk an index out of bounds error
    {
      return sums[j] - sums[i-1]; // now we just subtract the sums to end up with the ranged sum
    }                             // i-1 above because of the inclusive nature of the problem

  }

  // contains a couple manual test cases
  public static void main(String[] args)
  {
    int[] nums = {-2, 0, 3, -5, 2, -1};
    NumArray numArray = new NumArray(nums);
    int test1 = numArray.sumRange(0, 2);
    int test2 = numArray.sumRange(2, 5);
    nums = null;
    numArray = new NumArray(nums);
    int test3 = numArray.sumRange(0, 5);

    System.out.println("test1 (0,2): " + test1);
    System.out.println("test2 (2,5): " + test2);
    System.out.println("test3 (0,5): " + test3);
  }
}
