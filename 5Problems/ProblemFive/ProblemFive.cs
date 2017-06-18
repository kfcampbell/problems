using System;
using System.Collections.Generic;
using System.Linq;

namespace ProblemFive
{
    // Write a program that outputs all possibilities to put + or - or nothing between the numbers 1, 2, ..., 9 (in this order) 
    // such that the result is always 100. For example: 1 + 2 + 34 – 5 + 67 – 8 + 9 = 100.
    class ProblemFive
    {
        private static int TARGET = 100;
        private static List<int> numbers = new List<int> { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

        static void Main(string[] args)
        {
            Console.WriteLine("Hello World!");
        }
    }
}
