using System;

namespace IntegerSwap
{
    class IntegerSwap
    {
        static void Main(string[] args)
        {
            int a = 150;
            int b = 250;
            Swap(a, b);

            a = 72;
            b = 26;
            Swap(a, b);

            a = 8;
            b = 8;
            Swap(a, b);

            a = -86;
            b = 26;
            Swap(a, b);

            a = -100;
            b = -86;
            Swap(a, b);
        }

        private static void Swap(int a, int b)
        {
            Console.WriteLine($"Before swap: a == {a}, b == {b}");

            a = a + b;
            b = a - b;
            a = a - b;

            Console.WriteLine($"After swap: a == {a}, b == {b}");
        }
    }
}
