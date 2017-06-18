using System;
using System.Collections.Generic;
using System.Linq;

namespace ProblemFour
{
    // Write a function that given a list of non negative integers, arranges them such that they form the largest possible number. 
    // For example, given [50, 2, 1, 9], the largest formed number is 95021.
    class ProblemFour
    {
        private static List<int> numbers = new List<int> { 50, 2, 1, 9 };
        static void Main(string[] args)
        {
            List<List<int>> permutations = GetPermutationsFromList(numbers);
            int maximumPossibleValue = GetMaxFromPermutations(permutations);
            Console.WriteLine("Maximum possible value: " + maximumPossibleValue);
        }

        private static List<List<int>> GetPermutationsFromList(List<int> numbers)
        {
            List<List<int>> permutations = new List<List<int>> { numbers };

            // missing logic to get the superset here.
            var permutes = GetPermutations<int>(numbers.ToArray());
            foreach(var item in permutes)
            {
                permutations.Add(item.ToList());
            }
            return permutations;
        }

        // credit to SO user Matt Cole: https://codereview.stackexchange.com/users/71242/matt-cole
        private static IEnumerable<T[]> GetPermutations<T>(T[] values)
        {
            if (values.Length == 1)
                return new[] { values };

            return values.SelectMany(v => GetPermutations(values.Except(new[] { v }).ToArray()),
                (v, p) => new[] { v }.Concat(p).ToArray());
        }

        private static int GetMaxFromPermutations(List<List<int>> permutations)
        {
            List<int> combinations = new List<int>();

            foreach (var currentPermutation in permutations)
            {
                int permutation = int.Parse(string.Join("", currentPermutation));
                combinations.Add(permutation);
            }

            return combinations.Max();
        }
    }
}
