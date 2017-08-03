using System;
using System.Collections.Generic;
using System.Linq;

namespace CountTripletsLessThanSum
{
    class CountTripletsLessThanSum
    {
        static void Main(string[] args)
        {
            int[] testCaseOne = new int[] { -2, 0, 1, 3};
            Console.WriteLine($"triplets count: {GetTripletsLessThanSum(2, testCaseOne).Count}");
            int[] testCaseTwo = new int[] { 5, 1, 4, 3, 7};
            Console.WriteLine($"triplets count: {GetTripletsLessThanSum(12, testCaseTwo).Count}");
        }

        static List<Tuple<int, int, int>> GetTripletsLessThanSum(int sum, int[] numbers)
        {
            List<Tuple<int, int, int>> triplets = new List<Tuple<int, int, int>>();

            int index = 0;
            bool turn = false;
            while(index < numbers.Length)
            {
                int lhs = 0;
                int rhs = numbers.Length - 1;

                while(lhs < rhs)
                {
                    if((numbers[lhs] + numbers[rhs] + numbers[index] < sum) && (lhs != rhs && rhs != index && lhs != index))
                    {
                        List<int> sortedNumbers = new List<int> { numbers[lhs], numbers[rhs], numbers[index] };
                        sortedNumbers.Sort();
                        var triplet = new Tuple<int, int, int>(sortedNumbers[0], sortedNumbers[1], sortedNumbers[2]);
                        if(!triplets.Contains(triplet)) triplets.Add(triplet);
                    }
                    if(turn)
                    {
                        lhs++;
                    }
                    else
                    {
                        rhs--;
                    }
                    turn = !turn;
                }
                index++;
            }
            return triplets;
        }
    }
}
