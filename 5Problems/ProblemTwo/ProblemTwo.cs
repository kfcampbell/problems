using System;
using System.Collections.Generic;

namespace ProblemTwo
{
    public class ProblemTwo
    {
        // Write a function that combines two lists by alternatingly taking elements.
        // For example: given the two lists [a, b, c] and [1, 2, 3], the function should return [a, 1, b, 2, c, 3].
        public static void Main(string[] args)
        {
            List<int> firstList = new List<int> { 1, 3, 5, 7, 9, 11 };
            List<int> secondList = new List<int> { 2, 4, 6, 8, 10 };

            List<int> combination = CombineLists(firstList, secondList);

            combination.ForEach(Console.WriteLine);
        }

        private static List<int> CombineLists(List<int> firstList, List<int> secondList)
        {
            List<int> combination = new List<int>();

            int smallestListSize = 0;
            bool firstListIsSmaller = false;
            if (firstList.Count < secondList.Count)
            {
                smallestListSize = firstList.Count;
                firstListIsSmaller = true;
            }
            else
            {
                smallestListSize = secondList.Count;
            }

            int index = 0;
            while (index < smallestListSize)
            {
                combination.Add(firstList[index]);
                combination.Add(secondList[index]);
                index++;
            }

            if (firstListIsSmaller)
            {
                for (; index < secondList.Count; index++)
                {
                    combination.Add(secondList[index]);
                }
            }
            else
            {
                for (; index < firstList.Count; index++)
                {
                    combination.Add(firstList[index]);
                }
            }

            return combination;
        }
    }
}
