/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution
{ // this is problem #206.
  public ListNode reverseList(ListNode head)
  {
    // iterative solution. 0ms on LeetCode
    ListNode current = head; // give me something to work with here.
    ListNode reversed = null; // reversed will hold the in-progress reversed linked list.
    // ListNode next = null; // could declare this here and save the initialization in the while loop,
                             // but i judged it not worthy for a solution that's already 0ms.

    while(current != null) // iterate through list
    {
      ListNode next = current.next; // grab the next node and put it in next.
      current.next = reversed; // add the in-progress reversed list to the next value
      reversed = current; // add the current value to the in-progress reversed list
      current = next; // advance the current node being looked at.
    }

    return reversed; // return the reversed version of the linked list.
  }
}
