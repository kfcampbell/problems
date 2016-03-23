import java.util.*;

public class LongestValidParentheses
{ // this is problem #32. its runtime is 14ms on LeetCode.
  public static int longestValidParentheses(String s)
  {
    Stack<Integer> st = new Stack<Integer>();
    int max = 0;

    if(s.length() < 2) // maybe we can get out of here right away
    {
      return max;
    }

    for(int i = 0; i < s.length(); i++) // otherwise let's iterate through the string.
    {
      // if the stack isn't empty, and we're looking at a closing character that matches,
      if(!st.isEmpty() && s.charAt(i) == ')' && s.charAt(st.peek()) == '(')
      {
        st.pop(); // first get rid of the top value of the stack. this is so the (i - st.peek()) calculation below works as desired.
        if(!st.isEmpty()) // then if it's not empty,
        {
          max = Math.max(max, (i - st.peek())); // we want the max of the current max and the correct chain we have now.
        }
        else // if it is empty,
        {
          max = Math.max(max, i + 1); // then we only want the max of the current max and one extra set of parentheses
        }
      }
      else // if we're looking at an opening character, push the new index to the stack.
      {
        // we want to store indices in the stack rather than parens (as in ValidParentheses.java)
        // because here we're counting items rather than returning a boolean.
        // adding each index allows tracking of how many valid parentheses we have so far.
        st.push(i);
      }
    }

    return max;
  }

  public static void main(String[] args)
  {
    // some test cases
    String s = "()()()))))";
    System.out.println(s + " is " + longestValidParentheses(s));

    s = "((()))";
    System.out.println(s + " is " + longestValidParentheses(s));

    s = "(((((()))((()";
    System.out.println(s + " is " + longestValidParentheses(s));
  }
}
