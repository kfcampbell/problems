import java.util.*;

public class RemoveDuplicates
{ // this is problem #26. it has a completion time of 2ms on LeetCode.
  public static int removeDuplicates(int[] nums)
  {
    switch(nums.length)
    {
      case 0:
        return 0;
      case 1:
        return 1;
      default:
        break;
    }

    // count is necessary for the removal of duplicates and it also counts the number of distinct elements.
    int count = 1;
    for(int i = 0; i < nums.length-1; i++)
    {
      if(nums[i] != nums[i+1])
      {
        // count holds the value ahead of the index of the last distinct element.
        // this swapping method leaves the last spots of the array filled with
        // all of the duplicates.
        nums[count] = nums[i+1];
        count++;
      }
      else // if nums[i] == nums[i+1]
      {
        // do nothing. i++ is enough.
      }
    }

    // learned about the continue keyword and wanted to try it out.
    /*int count = 1;
    for(int i = 0; i < nums.length-1; i++)
    {
      if(nums[i] == nums[i+1])
      {
        continue; // whoa! it works!
      }

      System.out.println("continue keyword did not fire.");

      if(nums[i] != nums[i+1])
      {
        nums[count] = nums[i+1];
        count++;
      }
    }*/

    return count;
  }

  public static void main(String[] args)
  {
    // some test cases
    int[] test = {1, 2, 2, 3, 4, 4, 5, 6, 7, 7, 8, 9};
    System.out.println(removeDuplicates(test));

    int[] test2 = {1};
    System.out.println(removeDuplicates(test2));

    int[] test3 = {2, 2};
    System.out.println(removeDuplicates(test3));

    int[] test4 = {1, 1, 1};
    System.out.println(removeDuplicates(test4));

    int[] test5 = {1, 2};
    System.out.println(removeDuplicates(test5));
  }
}
