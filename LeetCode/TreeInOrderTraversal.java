// given by LeetCode:
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

import java.util.*;

public class TreeInOrderTraversal
{ // this is problem #94.
  public List<Integer> inorderTraversal(TreeNode root)
  {
    List<Integer> numList = new ArrayList<Integer>(); // an ArrayList to hold the solution

    // inOrder Traversal -> curr.left, curr.val, curr.right.

    //inOrderRecursive(root, numList); // call the recursive solution
    numList = inOrderIterative(root); // call the iterative solution. it returns the ArrayList rather than passing it in.
    return numList;
  }

  // trivial recursive solution. 1ms solution time on LeetCode
  private void inOrderRecursive(TreeNode root, List<Integer> inProgress)
  {
    if(root == null) // if the node is null, we don't need to make any changes
    {
        return;
    }
    else // otherwise, let's do some work.
    { // process all of the nodes according to in-order traversing
      inOrderRecursive(root.left, inProgress);
      inProgress.add(root.val); // add the actual value of the node we're looking at.
      inOrderRecursive(root.right, inProgress);

      return; // now that all the work is done and the ArrayList is put together, we're done.
    }
  }

  // iterative solution here. 2ms solution time on LeetCode. Uses a stack in its implementation.
  private List<Integer> inOrderIterative(TreeNode root)
  {
    List<Integer> numList = new ArrayList<Integer>(); // ArrayList to hold the solution.
    Stack<TreeNode> stack = new Stack<TreeNode>(); // stack to hold nodes because we're not doing this recursively.

    TreeNode curr = root; // because i mess with curr a lot.

    while(curr != null) // find the left-most node
    {
      stack.push(curr); // push the node to the stack
      curr = curr.left; // work our way left
    }

    while(!stack.isEmpty()) // if the stack is empty, we're done and it's time to return.
    {
      curr = stack.pop(); // grab the first node on the stack to look at.
      numList.add(curr.val); // add its value to the ArrayList

      if(curr.right != null) // see if our current node has any right children
      {
        curr = curr.right; // if it does, let's investigate those really quick

        while(curr != null) // traverse to the left again, just like above but
        {                   // start from the current node rather than the root
          stack.push(curr); // push the node to the stack
          curr = curr.left; // work our way left
        }
      }
    }

    return numList; // time to return the final answer
  }

}
