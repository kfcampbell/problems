using System;
using System.Collections.Generic;

namespace ProblemThree
{
    /* Write a function that computes the list of the first 100 Fibonacci numbers. By definition, the first two numbers in the Fibonacci 
    sequence are 0 and 1, and each subsequent number is the sum of the previous two. As an example, here are the first 10 Fibonacci numbers:
    0, 1, 1, 2, 3, 5, 8, 13, 21, and 34.

     Note that this is currently only accurate to F(93) due to limitations in primitive C# data types.
    */
    class ProblemThree
    {
        private const ulong FIRST_FIBONACCI_NUMBER = 0;
        private const ulong SECOND_FIBONACCI_NUMBER = 1;
        private const int NUMBERS_TO_GENERATE = 100;
        
        static void Main(string[] args)
        {
            List<ulong> sequence = GenerateFibonacciSequence();
            sequence.ForEach(Console.WriteLine);
        }

        static List<ulong> GenerateFibonacciSequence()
        {
            List<ulong> sequence = new List<ulong> { FIRST_FIBONACCI_NUMBER, SECOND_FIBONACCI_NUMBER };
            int index = sequence.Count;
            while(index <= NUMBERS_TO_GENERATE)
            {
                sequence.Add(sequence[index - 1] + sequence[index - 2]);
                index++;
            }
            return sequence;
        }
    }
}
