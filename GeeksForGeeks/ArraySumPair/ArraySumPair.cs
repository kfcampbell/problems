using System;

namespace ArraySumPair
{
    // write a program that, given an array A[] of n numbers and another number x, 
    // determines whether or not there exist two elements in A whose sum is exactly x

    class ArraySumPair
    {
        static void Main(string[] args)
        {
            int[] array = new int[] { 8, 6, 7, 5, 3, 0, 9 };
            array = BubbleSort(array);

            Console.WriteLine("Sum of 13 exists in array: " + SumExists(13, array));
            Console.WriteLine("Sum of 19 exists in array: " + SumExists(19, array));
            
        }

        private static int[] BubbleSort(int[] array)
        {
            bool sorted = false;
            while(!sorted)
            {
                bool swapped = false;
                for(int i = 0; i < array.Length - 1; i++)
                {
                    if(array[i] > array[i+1])
                    {
                        int temp = array[i];
                        array[i] = array[i+1];
                        array[i+1] = temp;
                        swapped = true;
                    }
                }
                if(!swapped) sorted = true;
            }

            return array;
        }

        private static bool SumExists(int goal, int[] array)
        {
            int leftIndex = 0;
            int rightIndex = array.Length - 1;

            while(leftIndex < rightIndex)
            {
                int sum = array[leftIndex] + array[rightIndex];
                if(sum == goal)
                {
                    return true;
                }
                else if(sum < goal)
                {
                    leftIndex++;
                }
                else
                {
                    rightIndex--;
                }
            }
            return false;
        }
    }
}
