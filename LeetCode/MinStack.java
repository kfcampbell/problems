import java.util.*; // for use with ArrayLists

// this is problem #155. its runtime is 8ms on LeetCode
public class MinStack
{
  private ArrayList<Integer> stack; // act as the actual stack
  private ArrayList<Integer> minList; // hold the history of minimum values
  //private Integer min;
  /* note: i really really tried to implement this using an Integer min rather than another ArrayList.
   * however, it ended up being more expensive time-wise than the current implementation to re-find the minimum
   * value when removing the current minimum value as i had to search the ArrayList each time.
   * thus i switched to tracking the history of minimum values in an ArrayList instead.
   */

  // in the public constructor, instantiate the private members declared above.
  public MinStack()
  {
    stack = new ArrayList<Integer>();
    minList = new ArrayList<Integer>();
  }

  public void push(int x)
  {
    // if we need to update the minimum value.
    if(minList.isEmpty() || minList.get(minList.size() - 1) >= x) // note >= to protect multiple same minimum values
    {
      minList.add(x); // add the value to the list of minimums
    }
    stack.add(x); // add the value to the stack
  }

  public void pop()
  {
    // put in separate variables to condense the if statement below
    int st = stack.get(stack.size() - 1);
    int min = minList.get(minList.size() - 1);

    if(st == min) // if we're removing the current minimum,
    {
      stack.remove(stack.size() - 1); // make sure to remove the value from the stack
      minList.remove(minList.size() - 1); // and also remove the minimum from the list of mins
    }
    else // if we're not removing the current minimum,
    {
      stack.remove(stack.size() - 1); // then just remove the value from the stack
    }
  }

  // just grab the value most recently added.
  public int top()
  {
    return stack.get(stack.size() - 1);
  }

  // just grab the most recently added minimum value
  public int getMin()
  {
    return minList.get(minList.size() - 1);
  }

  // helper function i implemented to help me debug
  public void printStackContents()
  {
    for(int i : stack)
    {
      System.out.print("element = " + i + ", ");
    }
    System.out.println(" ");

    for(int i : minList)
    {
      System.out.print("minimum = " + i + ", ");
    }
    System.out.println(" ");
  }

  public static void main(String[] args)
  {
    // some test cases
    MinStack st = new MinStack();
    /*st.push(512);
    st.push(-1024);
    st.push(-1024);
    st.push(512);
    st.printStackContents();
    st.pop();
    st.printStackContents();
    st.pop();
    st.printStackContents();
    st.pop();
    st.printStackContents();*/

    st.push(0);
    st.push(1);
    st.push(0);
    st.getMin();
    System.out.println("st min is " + st.getMin());
    st.pop();
    st.printStackContents();
    st.getMin();
    System.out.println("st min is " + st.getMin());
  }
}
