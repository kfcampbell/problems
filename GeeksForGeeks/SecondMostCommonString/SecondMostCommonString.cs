using System;
using System.Collections.Generic;

namespace SecondMostCommonString
{
    class Program
    {
        static void Main(string[] args)
        {
            string[] firstCase = new string[] { "aaa", "bbb", "ccc", "bbb", "aaa", "aaa" };
            var firstCaseAnswer = FindSecondMostCommonString(firstCase);
            string[] secondCase = new string[] { "geeks", "for", "geeks", "for", "geeks" };
            var secondCaseAnswer = FindSecondMostCommonString(secondCase);

            Console.WriteLine($"2nd most common string in {string.Join(",", firstCase)}: {firstCaseAnswer.Key} with {firstCaseAnswer.Value} occurrences.");
            Console.WriteLine($"2nd most common string in {string.Join(",", secondCase)}: {secondCaseAnswer.Key} with {secondCaseAnswer.Value} occurrences.");
        }

        // non-optimal implementation. i don't like the time complexity and i don't like iterating over a dictionary.
        public static KeyValuePair<string, int> FindSecondMostCommonString(string[] words)
        {
            var counts = new Dictionary<string, int>();
            foreach(var word in words)
            {
                if(!counts.ContainsKey(word))
                {
                    counts.Add(word, 1);
                }
                else
                {
                    var currentCount = counts[word];
                    currentCount++;
                    counts[word] = currentCount;
                }
            }

            KeyValuePair<string, int> most = new KeyValuePair<string, int>("", 0);
            KeyValuePair<string, int> secondMost = new KeyValuePair<string, int>("", 0);
            foreach(KeyValuePair<string, int> pair in counts)
            {
                if(pair.Value > most.Value) most = pair;
                else if(pair.Value > secondMost.Value) secondMost = pair;
            }

            return secondMost;
        }
    }
}
