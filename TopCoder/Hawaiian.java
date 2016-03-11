import java.util.*;

public class Hawaiian
{
  public static String[] getWords(String sentence)
  {
    // iterate through the sentence one word at a time
    StringBuilder sb = new StringBuilder();
    List<String> validWords = new ArrayList<String>();

    for(int i = 0; i < sentence.length(); i++)
    {
      char curr = sentence.charAt(i); // create a char variable to hold the current char

      if(curr != ' ') // if there's a letter we need to add to the current word
      {
        sb.append(curr);
      }
      if(curr == ' ' || (i == sentence.length() - 1)) // if it's a space, start the StringBuilder over
      {
        if(isHawaiian(sb.toString()))
        {
          validWords.add(sb.toString());
        }
        sb = new StringBuilder();
      }

    }

    // now return the list of valid words
    String[] words = new String[validWords.size()];
    validWords.toArray(words);
    return words;
  }

  public static Boolean isHawaiian(String word)
  {
    Boolean isWord = true;

    for(int i = 0; i < word.length(); i++)
    {
      char c = word.charAt(i);

      // check for lower-case vowels
      if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
      {
        isWord = true;
      }
      // now check for upper-case vowels
      else if(c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U')
      {
        isWord = true;
      }
      // now check for lower-case consonants
      else if(c == 'h' || c == 'k' || c == 'l' || c == 'm' || c == 'n' || c == 'p' || c == 'w')
      {
        isWord = true;
      }
      // now check for upper-case consonants
      else if(c == 'H' || c == 'K' || c == 'L' || c == 'M' || c == 'N' || c == 'P' || c == 'W')
      {
        isWord = true;
      }
      else // if the letter isn't a valid Hawaiian letter
      {
        isWord = false;
        break;
      }
    }

    return isWord;
  }

  // main function for testing purposes
  public static void main(String[] args)
	{
    String[] test1 = getWords("Hawaii is an island");
    System.out.println("Results: " + Arrays.toString(test1));

    String[] test2 = getWords("Mauna Kea and Mauna Koa are two mountains");
    System.out.println("Results: " + Arrays.toString(test2));

    String[] test3 = getWords("Pineapple grows in Hawaii");
    System.out.println("Results: " + Arrays.toString(test3));

	}
}
