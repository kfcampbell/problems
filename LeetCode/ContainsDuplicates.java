import java.util.*;

public class ContainsDuplicates
{
  // this is problem #217.
  public static boolean containsDuplicate(int[] nums)
  {
    if(nums.length < 2)
    {
      return false;
    }

    // quicker solution. this takes 9ms on LeetCode.
    HashSet<Integer> hs = new HashSet<Integer>();
    boolean noDupes = true;
    for(int i = 0; i < nums.length; i++)
    {
      if(!hs.add(nums[i])) // add(element) returns true if element wasn't in the set already.
      {
        noDupes = false;
        break;
      }
    }
    return !noDupes;


    // slow solution (my rough draft)
    /*
    // Use properties of HashMap. This solution takes 27ms on LeetCode.
    HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();

    for(int i = 0; i < nums.length; i++)
    {
      hm.put(i, nums[i]);
    }

    HashSet<Integer> uniques = new HashSet<Integer>(hm.values());

    return((hm.size() == uniques.size()) ? false : true);
    */
  }

  public static void main(String[] args)
  {
    int[] nums = {1, 2, 3, 4, 5, 6};
    System.out.println("Test1 results: " + containsDuplicate(nums));

    int[] nums2 = {1, 2, 3, 3, 4, 5, 6};
    System.out.println("Test2 results: " + containsDuplicate(nums2));

    int[] nums3 = {3, 3};
    System.out.println("Test3 results: " + containsDuplicate(nums3));
  }
}
