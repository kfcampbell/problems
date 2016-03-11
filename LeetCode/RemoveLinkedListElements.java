// given by LeetCode
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class RemoveLinkedListElements
{ // this is problem #203.
  public ListNode removeElements(ListNode head, int val)
  {
    while(head != null && head.val == val) // if the wanted value belongs to the head,
    {
      head = head.next; // then just pull it out of the list and jump to the next node.
    }

    if(head == null) // if the head is null, we can get out of here.
    {
      return null;
    }

    if(head.next == null && head.val == val) // if the only thing in the list is something we're removing,
    {
      return null; // then we just return null
    }

    ListNode temp = head; // create a new node for temporary purposes

    while(temp.next != null) // iterate through the list as long as it exists
    {
      if(temp.next.val == val) // if the value we're removing is in temp.next
      {
        temp.next = temp.next.next; // then we just skip over it in the list
      }
      else
      {
        temp = temp.next; // otherwise, we advance through the list
      }
    }

    return head; // return the edited linked list

  }
}
