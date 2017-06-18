using System;
using System.Collections.Generic;

// Write three functions that compute the sum of the numbers in a given list using a for-loop, a while-loop, and recursion.

public class ProblemOne 
{
    public static void Main(string[] args)
    {
        List<int> numbers = new List<int> { 8, 15, 24, 11, 2, 16, 76 };
        System.Console.WriteLine("Sum by for loop: " + SumByForLoop(numbers));
        System.Console.WriteLine("Sum by while loop: " + SumByWhileLoop(numbers));
        System.Console.WriteLine("Sum by recursion: " + SumByRecursion(numbers));
    }

    private static int SumByForLoop(List<int> numbersToSum)
    {
        int sum = 0;
        for(int i = 0; i < numbersToSum.Count; i++)
        {
            sum += numbersToSum[i];
        }
        return sum;
    }

    private static int SumByWhileLoop(List<int> numbersToSum)
    {
        int sum = 0;
        int i = 0;
        while(i < numbersToSum.Count)
        {
            sum += numbersToSum[i];
            i++;
        }
        return sum;
    }

    private static int SumByRecursion(List<int> numbersToSum)
    {
        return SumByRecursion(0, numbersToSum);
    }

    private static int SumByRecursion(int index, List<int> numbersToSum)
    {
        if(index >= numbersToSum.Count)
        {
            return 0;
        }

        return numbersToSum[index] + SumByRecursion(index + 1, numbersToSum);
    }
}