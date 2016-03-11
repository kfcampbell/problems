import java.util.*;

public class StringPermutation
{ // problem given on page 90
  public static boolean isPermutation(String one, String two)
  {
    // uses standard libraries and i'm not sure of the time complexity.
    // however, it's clean and readable and performs as required.
    char[] oneChar = one.toCharArray();
    char[] twoChar = two.toCharArray();
    Arrays.sort(oneChar);
    Arrays.sort(twoChar);

    // let's use the conditional operator to keep this to one line
    return (Arrays.equals(oneChar, twoChar) ? true : false);
  }

  // not part of the original problem, but I'm interested in it anyway.
  // running time here is O(one.length()) plus whatever the overhead is for creating,
  // reversing, and comparing two charLists.
  public static boolean isPalindrome(String one, String two)
  {
    if(one.length() != two.length())
    {
      return false;
    }

    List<Character> oneChars = new ArrayList<Character>(); // not super necessary because we only need to reverse one. however,
    List<Character> twoChars = new ArrayList<Character>(); // it helps with comparison and building future operations off this.

    for(int i = 0; i < one.length(); i++)
    {
      oneChars.add(one.charAt(i));
      twoChars.add(two.charAt(i));
    }

    Collections.reverse(twoChars);

    return (oneChars.equals(twoChars) ? true : false);
  }

  public static void main(String[] args)
  {
    // some basic test cases
    String one = "tacocat";
    String two = "toastdog";
    String three = "cattaco";
    String four = "godtsaot";

    System.out.println(one + " and " + two + " are permutations: " + isPermutation(one, two));
    System.out.println(one + " and " + three + " are permutations: " + isPermutation(one, three));

    System.out.println(two + " and " + four + " are palidromes: " + isPalindrome(two, four));
    System.out.println(one + " and " + three + " are palindromes: " + isPalindrome(one, three));
  }
}
