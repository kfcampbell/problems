using System;
using System.Collections.Generic;

namespace PythagoreanTriplet
{
    // Given an array of integers, write a function that returns true if there is a triplet (a, b, c) that satisfies a^2 + b^2 = c2.
    class PythagoreanTriplet
    {
        static void Main(string[] args)
        {
            List<int> one = new List<int> { 3, 1, 4, 6, 5 };
            List<int> oneTriplet = FindPythagoreanTriplet(one);
            Console.WriteLine(oneTriplet.Count > 0 ? string.Join(",", oneTriplet.ToArray()) : "No triplet found.");

            List<int> two = new List<int> { 10, 4, 6, 12, 5 };
            List<int> twoTriplet = FindPythagoreanTriplet(two);
            Console.WriteLine(twoTriplet.Count > 0 ? string.Join(",", twoTriplet.ToArray()) : "No triplet found.");
        }

        public static List<int> FindPythagoreanTriplet(List<int> list)
        {
            list.Sort();
            List<int> squares = new List<int>();
            for (int i = 0; i < list.Count; i++)
            {
                squares.Add(list[i] * list[i]);
            }
            squares.Sort();

            int aIndex = squares.Count - 1;
            while (aIndex >= 0)
            {
                int bIndex = 0;
                int cIndex = squares.Count - 1;

                while (bIndex < cIndex)
                {
                    if (aIndex != bIndex && bIndex != cIndex)
                    {
                        if (squares[aIndex] + squares[bIndex] == squares[cIndex])
                        {
                            return new List<int> { list[aIndex], list[bIndex], list[cIndex] };
                        }
                    }
                    bIndex++;
                    cIndex--;
                }
                aIndex--;
            }
            return new List<int>();
        }
    }
}
