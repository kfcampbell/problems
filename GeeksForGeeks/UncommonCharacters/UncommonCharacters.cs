using System;
using System.Collections.Generic;
using System.Linq;

namespace UncommonCharacters
{
    //Find and print the uncommon characters of the two given strings. Here uncommon character means 
    //that either the character is present in one string or it is present in other string but not in both. 
    //The strings contain only lowercase characters and can contain duplicates.

    class UncommonCharacters
    {
        static void Main(string[] args)
        {
            string first = "characters";
            string second = "alphabets";

            Console.WriteLine($"Uncommon characters between {first} and {second}: {GetUncommonCharacters(first, second)}");
        }

        private static string GetUncommonCharacters(string first, string second)
        {
            string uncommonChars = string.Empty;

            foreach(char curr in first)
            {
                if(!second.Contains(curr.ToString()) && !uncommonChars.Contains(curr.ToString()))
                {
                    uncommonChars += curr;
                }
            }

            foreach(char curr in second)
            {
                if(!first.Contains(curr.ToString()) && !uncommonChars.Contains(curr.ToString()))
                {
                    uncommonChars += curr;
                }
            }

            return String.Concat(uncommonChars.OrderBy(c => c));
        }
    }
}
