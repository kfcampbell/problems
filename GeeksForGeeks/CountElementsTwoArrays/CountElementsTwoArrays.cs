using System;
using System.Collections.Generic;

namespace CountElementsTwoArrays
{
    // Given two unsorted arrays arr1[] and arr2[] (they may contain duplicates):
    // for each element in arr1[] count elements less than or equal to it in array arr2[].
    class CountElementsTwoArrays
    {
        static void Main(string[] args)
        {
            int[] arr1 = new int[] { 4, 8, 7, 5, 1 };
            int[] arr2 = new int[] { 4, 48, 3, 0, 1, 1, 5 };
            int[] arr3 = new int[] { 1, 2, 3, 4, 7, 9 };
            int[] arr4 = new int[] { 0, 1, 2, 1, 1, 4 };
            GetElementsLessThanEqualTo(arr1, arr2);
            GetElementsLessThanEqualTo(arr3, arr4);
        }
        
        static void GetElementsLessThanEqualTo(int[] subjectArray, int[] targetArray)
        {
             Dictionary<int, int> occurrenceCount = new Dictionary<int, int>();

             // i really don't like that this is O(m*n)
             for(int i = 0; i < subjectArray.Length; i++)
             {
                for(int j = 0; j < targetArray.Length; j++)
                {
                    if(targetArray[j] <= subjectArray[i])
                    {
                        if(occurrenceCount.ContainsKey(subjectArray[i]))
                        {
                            int currentCount = occurrenceCount[subjectArray[i]];
                            currentCount++;
                            occurrenceCount.Remove(subjectArray[i]);
                            occurrenceCount.Add(subjectArray[i], currentCount);
                        }
                        else
                        {
                            occurrenceCount.Add(subjectArray[i], 1);
                        }
                    }
                }
             }

             foreach(KeyValuePair<int, int> entry in occurrenceCount)
             {
                Console.WriteLine($"{entry.Key}:{entry.Value} times");
             }
        }
    }
}
