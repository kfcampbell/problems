using System;
using System.Collections.Generic;

namespace LinkedListSortedAlternatingly
{
    class Node
    {
        public int value;
        public Node next;

        public Node(int value)
        {
            this.value = value;
        }
    }

    class LinkedListSortedAlternatingly
    {
        static void Main(string[] args)
        {
            Node one = new Node(1);
            Node nine = new Node(9);
            Node two = new Node(2);
            Node eight = new Node(8);
            Node three = new Node(3);
            Node seven = new Node(7);

            one.next = nine;
            nine.next = two;
            two.next = eight;
            eight.next = three;
            three.next = seven;

            Node resortedList = Sort(one);
        }

        static Node Sort(Node head)
        {
            bool higherEnd = true;
            Queue<Node> lower = new Queue<Node>();
            Stack<Node> higher = new Stack<Node>();
            Node currentNode = head.next;

            while(currentNode != null)
            {
                if(higherEnd)
                {
                    higher.Push(currentNode);
                }
                else
                {
                    lower.Enqueue(currentNode);
                }
                higherEnd = !higherEnd;
                currentNode = currentNode.next;
            }

            currentNode = head;
            while(lower.Count > 0)
            {
                currentNode.next = lower.Dequeue();
                currentNode = currentNode.next;
            }
            while(higher.Count > 0)
            {
                currentNode.next = higher.Pop();
                currentNode = currentNode.next;
            }
            currentNode.next = null;

            return head;
        }
    }
}
