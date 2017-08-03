using System;

namespace EvenOddArray
{
    class EvenOddArray
    {
        static void Main(string[] args)
        {
            int[] testCaseOne = new int[] { 1, 2, 3, 4, 5, 6 };
            Console.WriteLine($"before: {string.Join(",", testCaseOne)}. after: {string.Join(",", GetEvenOddArray(testCaseOne))}.");
            int[] testCaseTwo = new int[] { 3, 2, 4, 1 };
            Console.WriteLine($"before: {string.Join(",", testCaseTwo)}. after: {string.Join(",", GetEvenOddArray(testCaseTwo))}.");
            int[] testCaseThree = new int[] { 4, 5, 5, 5, 4, 4 };
            Console.WriteLine($"before: {string.Join(",", testCaseThree)}. after: {string.Join(",", GetEvenOddArray(testCaseThree))}.");
        }

        static int[] GetEvenOddArray(int[] numbers)
        {
            bool swapped = false;
            do 
            {
                swapped = false;
                for(int i = 0; i < numbers.Length - 1; i++)
                {
                    if(numbers[i] % 2 != i % 2)
                    {
                        for(int j = i + 1; j < numbers.Length; j++)
                        {
                            if(numbers[j] % 2 != numbers[i] % 2)
                            {
                                int temp = numbers[j];
                                numbers[j] = numbers[i];
                                numbers[i] = temp;
                                swapped = true;
                                break;
                            }
                        }    
                    }
                }
            } while(swapped);
            return numbers;
        }
    }
}
