import java.util.*;

public class RepeatDNA
{ // Problem #187
  public static List<String> findRepeatedDnaSequences(String s)
  {
      List<String> sequences = new ArrayList<String>(); // eventually we're going to return this
      Set<String> finals = new HashSet<String>(); // hold the in-progress repeats list
      Set<String> seq = new HashSet<String>(); // hold the list of substrings.

      // if it's null or too small, we can get out of there right away.
      if(s == null || s.length() < 10)
      {
        return sequences;
      }

      // otherwise iterate through and start looking at substrings
      for(int i = 0; i <= (s.length()-10); i++) // <= because of the case of a string of length 11 of all one letter.
      {
        String substring = s.substring(i, i+10); // get the current substring

        // variables so I only have to look it up once per iteration
        boolean seqCont = seq.contains(substring);
        boolean finCont = finals.contains(substring);

        if(seqCont && !finCont) // check to see if we've seen this already
        {
          finals.add(substring); // if we have, that's a repeated substring to save.
        }
        else if(!seqCont && !finCont)// if we haven't seen it yet, add it to the list to check later.
        {
          seq.add(substring); // add it to the list to check later
        }
      }

      sequences.addAll(finals); // throw all the repeats into an ArrayList as specified
      return sequences;
  }

  public static void main(String[] args)
  {
    // basic test cases
    String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
    List<String> result = findRepeatedDnaSequences(s);

    String s2 = "AAAAAAAAAAA";
    List<String> result2 = findRepeatedDnaSequences(s2);
  }
}
