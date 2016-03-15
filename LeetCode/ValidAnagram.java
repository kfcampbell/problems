import java.util.*;

public class ValidAnagram
{ // this is problem #242. it has a 72ms runtime on LeetCode.
  public static boolean isAnagram(String s, String t)
  {
    // check for conditions where we can just return right away
    if(s.length() != t.length())
    {
      return false;
    }
    if(s == t)
    {
      return true;
    }
    // idea other than a HashMap solution: turn the strings into character arrays and sort them.
    // HashMap solution below:

    // could improve this by abstracting the following two for loops into a function
    // idea: create a HashMap between a character in the string and the number of times
    // that it occurs. then check if the two hashmaps are equal

    // maps letter -> # of occurences
    HashMap<Character, Integer> mapS = new HashMap<Character, Integer>();

    for(int i = 0; i < s.length(); i++)
    {
      char c = s.charAt(i);

      if(mapS.containsKey(c)) // if it's already in the map, increment the counter.
      {
        // there's gotta be a better way to do this than repeat this code
        int num = mapS.get(c);
        num++;
        mapS.remove(c);
        mapS.put(c, num);
      }
      else // if it's not already in the map
      {
        mapS.put(c, 1);
      }
    }

    HashMap<Character, Integer> mapT = new HashMap<Character, Integer>();

    for(int i = 0; i < t.length(); i++)
    {
      char c = t.charAt(i);

      if(mapT.containsKey(c)) // if it's already in the map, increment the counter.
      {
        int num = mapT.get(c);
        num++;
        mapT.remove(c);
        mapT.put(c, num);
      }
      else // if it's not already in the map
      {
        mapT.put(c, 1);
      }
    }

    return mapS.equals(mapT);
  }

  public static void main(String[] args)
  {
    String s = "wolfram";
    String t = "molfraw";
    System.out.println("Anagram test1: " + isAnagram(s, t));
  }
}
