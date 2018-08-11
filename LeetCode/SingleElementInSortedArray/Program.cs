using System;
using System.Collections.Generic;

namespace SingleElementInSortedArray
{
    class Program
    {
        static void Main(string[] args)
        {
            //int[] testInput = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 8, 9, 10 };
            //int[] testInput = new int[] { 1, 2, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
            int[] testInput = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10 };
            Console.WriteLine($"duplicated element: {BinarySearchFindElementThatAppearsOnce(testInput)}");
        }

        // O(n log n) time and O(1) space
        static int BinarySearchFindElementThatAppearsOnce(int[] array)
        {
            // base case
            if(array == null || array.Length == 0)
            {
                throw new Exception("Array is null or empty!");
            }
            else if(array.Length == 1)
            {
                return array[0];
            }
            else
            {
                return BinarySearchFindElementThatAppearsOnce(array, 0, array.Length - 1, array.Length / 2);
            }
        }

        static int BinarySearchFindElementThatAppearsOnce(int[] array, int begin, int end, int midIndex)
        {
            if(midIndex == begin || midIndex == end || midIndex <= 0 || midIndex >= array.Length - 1)
            {
                return -1;
            }
            if(array[midIndex] == array[midIndex + 1])
            {
                return array[midIndex];
            }
            if(array[midIndex] == array[midIndex - 1])
            {
                return array[midIndex];
            }
            if(BinarySearchFindElementThatAppearsOnce(array, begin, midIndex, midIndex / 2) == -1)
            {
                return BinarySearchFindElementThatAppearsOnce(array, midIndex, end, (midIndex + midIndex / 2));
            }
            else
            {
                return BinarySearchFindElementThatAppearsOnce(array, begin, midIndex, midIndex / 2);
            }
            
        }

        // O(n) running time and O(n) space
        static int IterativeFindElementThatAppearsOnce(int[] array)
        {
            HashSet<int> set = new HashSet<int>();
            foreach (int item in array)
            {
                if (set.Contains(item))
                {
                    return item;
                }
                else
                {
                    set.Add(item);
                }
            }
            return -1;
        }
    }
}
