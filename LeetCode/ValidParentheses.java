import java.util.*;

public class ValidParentheses
{ // this is problem #20. it has a 1ms runtime on LeetCode.
  public static boolean isValid(String s)
  {
    Stack<Character> st = new Stack<Character>();

    for(int i = 0; i < s.length(); i++)
    {
      char curr = s.charAt(i);

      if(curr == '(' || curr == '{' || curr == '[') // if it's an opening character
      {
        st.push(curr);
      }
      else if(!st.isEmpty()) // if it's a closing character and the stack isn't empty
      {
        char top = st.pop();
        switch(top)
        {
          case '(':
            if(curr == ')')
              break;
            else
              return false;
          case '[':
            if(curr == ']')
              break;
            else
              return false;
          case '{':
            if(curr == '}')
              break;
            else
              return false;
          }
        }
        else // if the last thing is a closing character and the stack is empty, it's invalid
        {
          return false;
        }
      }

      if(!st.isEmpty())
      {
        return false;
      }
      return true;
    }

  public static void main(String[] args)
  {
    // some test cases
    String s = "(){}[]";
    System.out.println(s + " is " + isValid(s));

    s = "({[]})";
    System.out.println(s + " is " + isValid(s));

    s = "[{]";
    System.out.println(s + " is " + isValid(s));
  }

}
