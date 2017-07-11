using System;
using System.Linq;

namespace Anagrams
{
    // given two strings of only lowercase letters, determine if they're anagrams.
    class Anagrams
    {
        static void Main(string[] args)
        {
            Console.WriteLine($"face and cafe are anagrams: {AreAnagrams("face", "cafe")}");
            Console.WriteLine($"test and txst are anagrams: {AreAnagrams("test", "txst")}");

            Console.WriteLine($"face and cafe are anagrams: {AreAnagramsConstantSpace("face", "cafe")}");
            Console.WriteLine($"test and txst are anagrams: {AreAnagramsConstantSpace("test", "txst")}");
        }

        static bool AreAnagrams(string first, string second)
        {
            if (first.Length != second.Length) return false;
            int[] firstCount = new int[26];
            int[] secondCount = new int[26];

            foreach (char letter in first)
            {
                firstCount[ConvertCharToIntIndex(letter)]++;
            }

            foreach (char letter in second)
            {
                secondCount[ConvertCharToIntIndex(letter)]++;
            }

            return firstCount.SequenceEqual(secondCount);
        }

        static bool AreAnagramsConstantSpace(string first, string second)
        {
            if (first.Length != second.Length) return false;
            int[] count = new int[26];

            foreach (char letter in first)
            {
                count[ConvertCharToIntIndex(letter)]++;
            }

            foreach (char letter in second)
            {
                count[ConvertCharToIntIndex(letter)]--;
            }

            foreach(int num in count)
            {
                if(num != 0) return false;
            }
            return true;
        }

        static int ConvertCharToIntIndex(char letter)
        {
            return (int)letter - 97;
        }
    }
}
