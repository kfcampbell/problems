using System;
using System.Collections.Generic;
using System.Linq;

namespace PairsWithGivenSum
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] array = new int[] {5, 2, 3, 8, 9, 15, 29, 7, 10};
            PrintPairsWithGivenSum(array, 17);
        }

        static void PrintPairsWithGivenSum(int[] array, int sum)
        {
            List<int> nums = array.ToList();
            nums.Sort();

            int leftPointer = 0;
            int rightPointer = nums.Count - 1;

            while(leftPointer < rightPointer)
            {
                if(nums[leftPointer] + nums[rightPointer] == sum)
                {
                    Console.WriteLine($"Pair found: {nums[leftPointer]} + {nums[rightPointer]}");
                    leftPointer++; // arbitrary?
                }
                else if(nums[leftPointer] + nums[rightPointer] < sum)
                {
                    leftPointer++;
                }
                else
                {
                    rightPointer--;
                }
            }
        }
    }
}
