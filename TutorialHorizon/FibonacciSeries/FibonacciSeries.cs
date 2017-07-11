using System;

namespace FibonacciSeries
{
    class FibonacciSeries
    {
        static void Main(string[] args)
        {
            Console.WriteLine($"20th fibonacci number: {RecursiveFibonacci(20)}");
            Console.WriteLine($"20th fibonacci number: {DPFibonacci(20)}");
        }

        static int RecursiveFibonacci(int n)
        {
            if(n == 0) return 0;
            if(n == 1) return 1;

            return RecursiveFibonacci(n-1) + RecursiveFibonacci(n-2);
        }

        static int DPFibonacci(int n)
        {
            int[] sequence = new int[n+1];
            sequence[0] = 0;
            sequence[1] = 1;

            for(int i = 2; i < n+1; i++)
            {
                sequence[i] = sequence[i-1] + sequence[i-2];
            }
            return sequence[n];
        }
    }
}
