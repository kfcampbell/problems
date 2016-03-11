public class MagicIndex
{
  // solution implementing binary search: O(log(n)) time
  public static int findMagicIndexBinary(int[] arr)
  {
    // initialize some variables
    int low = 0;
    int high = arr.length - 1;
    int mid;

    while(low <= high) // let's do this iteratively. could also be implemented recursively.
    {
      mid = (low + high)/2; // calculate the new middle value

      if(arr[mid] < mid) // if we need to look higher in the array
      {
        low = mid + 1;
      }
      else if(arr[mid] > mid) // if we need to look lower in the array
      {
        high = mid - 1;
      }
      else if(arr[mid] == mid) // if we found the magic index
      {
        return mid;
      }
    }

    return -1; // case where there's no magic index. this assumes all integers given are popular.
               // however, it would be trivial to change this to a different specified value if we want
               // to be able to calculate the solution given an array with negative integers as well.
  }

  // this is the boring solution: O(n) time
  public static int findMagicIndexCheckAll(int[] arr)
  {
    for(int i = 0; i < arr.length; i++)
    {
      if(arr[i] == i)
      {
        return i;
      }
    }
    return -1; // case where there's no magic index
  }

  public static void main(String[] args)
  {
    int[] test1 = {-2, 0, 1, 2, 4, 6, 8, 12, 15, 17, 19, 21};
    System.out.println("Test1 result: " + findMagicIndexCheckAll(test1));

    int[] test2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
    System.out.println("Test2 result: " + findMagicIndexCheckAll(test2));

    System.out.println("Test3 result: " + findMagicIndexBinary(test1));

    System.out.println("Test4 result: " + findMagicIndexBinary(test2));
  }
}
