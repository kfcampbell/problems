using System;
using System.Collections.Generic;

namespace TwiceCount
{
    // Given an array of strings, count which are repeated twice.
    class TwiceCount
    {
        static void Main(string[] args)
        {
            string[] words = new string[] { "Robinson", "Canó", "Nelson", "Cruz", "Robinson", "Canó", "Edwin", "Díaz", "Robinson", "Canó", "Edwin", "Díaz" };
            var count = CountWords(words);
            PrintWordCounts(count);
        }

        public static Dictionary<string, int> CountWords(string[] words)
        {
            Dictionary<string, int> count = new Dictionary<string, int>();

            foreach(var word in words)
            {
                if(count.ContainsKey(word))
                {
                    int wordCount = 0;
                    count.TryGetValue(word, out wordCount);
                    count[word] = ++wordCount;
                }
                else
                {
                    count.Add(word, 1);
                }
            }
            return count;
        }

        public static void PrintWordCounts(Dictionary<string, int> count)
        {
            foreach(KeyValuePair<string, int> pair in count)
            {
                Console.WriteLine($"{pair.Key}: {pair.Value}");
            }
        }
    }
}
