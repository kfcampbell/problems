using System;
using System.Collections.Generic;
using System.Linq;

namespace LongestSubstringWithoutRepeatingCharacters
{
    class Program
    {
        static void Main(string[] args)
        {
            //string testInput = "abcabcbb";
            string testInput = "pwwkew";
            Console.WriteLine($"Longest substring of {testInput}: {GetLongestSubstringWithoutRepeats(testInput)}");
        }

        // O(n^2) time, O(n^2) space
        static string GetLongestSubstringWithoutRepeats(string initial)
        {
            List<string> substrings = new List<string>();
            for(int i = 0; i < initial.Length; i++)
            {
                string substring = initial[i].ToString();
                for(int j = i + 1; j < initial.Length; j++)
                {
                    if(initial[i] != initial[j])
                    {
                        substring += initial[j];
                    }
                    else
                    {
                        substrings.Add(substring);
                        break;
                    }
                }
            }

            // this could potentially be done in a LINQ statement
            string max = substrings[0];
            for(int i = 1; i < substrings.Count; i++)
            {
                if(substrings[i].Length > max.Length)
                {
                    max = substrings[i];
                }
            }
            return max;
        }
    }
}
