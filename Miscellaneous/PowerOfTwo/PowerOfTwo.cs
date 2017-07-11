using System;

namespace PowerOfTwo
{
    // check if a given integer is a power of two.
    class PowerOfTwo
    {
        static void Main(string[] args)
        {
            Console.WriteLine($"64 is power of two: {IsPowerOfTwo(64)}");
            Console.WriteLine($"82 is power of two: {IsPowerOfTwo(82)}");
        }

        static bool IsPowerOfTwo(int n)
        {
            if (n == 1 || n == 2) return true;

            double current = 4;
            while (current <= n)
            {
                if (current == n) return true;
                else current = current * 2;
            }
            return false;
        }
    }
}
