using System;
using System.Collections.Generic;

namespace FindAllDuplicatesInArray
{
    class Program
    {
        static void Main(string[] args)
        {
            List<int> testInput = new List<int> { 4, 3, 2, 7, 8, 2, 3, 1 };
            Console.WriteLine($"Duplicates: {String.Join(",", SpaceIntensiveFindAllDuplicatesInArray(testInput))}");
        }

        // O(n) time, O(n) space
        static List<int> SpaceIntensiveFindAllDuplicatesInArray(List<int> input)
        {
            HashSet<int> set = new HashSet<int>();
            for (int i = input.Count - 1; i >= 0; i--)
            {
                if (!set.Contains(input[i]))
                {
                    set.Add(input[i]);
                    input.Remove(input[i]);
                }
            }
            return input;
        }
    }
}
