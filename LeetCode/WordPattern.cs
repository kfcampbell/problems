using System;
using System.Collections.Generic;

public class Solution
{
    public static bool WordPattern(string pattern, string str)
    {
        string[] words = str.Split(null); // splits on all whitespace. should be cool if only spaces here.
        char[] pattern_letters = str.ToCharArray();

        for(int i = 0; i < words.Length; i++)
        {
            System.Console.WriteLine(words[i] + ", ");
            System.Console.WriteLine(pattern_letters[i] + ", ");
        }

        Dictionary<char, string> dict = new Dictionary<char, string>();
        
        for(int i = 0; i < words.Length; i++)
        {
            try
            {
                dict.Add(pattern_letters[i], words[i]);
            }
            catch(ArgumentException)
            {
                System.Console.WriteLine("Error in adding. False.");
                return false;
            }
        }
        System.Console.WriteLine("True!");
        return true;
    }

    public static void Main(string[] args)
    {
        bool tester = WordPattern("abba", "dog cat cat dog");
        tester = WordPattern("abba", "dog cat fish dog");
    }
}