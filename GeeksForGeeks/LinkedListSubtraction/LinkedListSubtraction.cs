using System;
using System.Collections.Generic;

// Given a singly linked list containing n nodes. Modify the value of first half nodes such that 
// 1st node’s new value is equal to the last node’s value minus first node’s current value, 2nd node’s 
// new value is equal to the second last node’s value minus 2nd node’s current value, likewise for first half nodes. 
// If n is odd then the value of the middle node remains unchanged.
namespace LinkedListSubtraction
{
    class Node
    {
        public int value;
        public Node next;

        public Node(int value)
        {
            this.value = value;
        }

        public void PrintAllNodes()
        {
            Console.Write($"{this.value} ");
            if (next != null)
            {
                next.PrintAllNodes();
            }
        }
    }

    class LinkedListSubtraction
    {
        public static void ModifyLinkedList(Node head)
        {
            Node currentNode = head;
            int count = 1;

            Stack<Node> stack = new Stack<Node>();
            stack.Push(currentNode);
            while (currentNode.next != null)
            {
                stack.Push(currentNode.next);
                currentNode = currentNode.next;
                count++;
            }

            currentNode = head;
            for(int i = 0; i < count/2; i++)
            {
                Node mirrorNode = stack.Pop();
                currentNode.value = mirrorNode.value - currentNode.value;
                currentNode = currentNode.next;
            }

            if(count % 2 == 1)
            {
                currentNode = currentNode.next;
                stack.Pop();
            }

            for(int i = (count/2)+1; i < count; i++)
            {
                Node mirrorNode = stack.Pop();
                currentNode.value = mirrorNode.value - currentNode.value;
                currentNode = currentNode.next;
            }

        }
        static void Main(string[] args)
        {
            // create testing linked list
            Node first = new Node(10);
            Node second = new Node(4);
            Node third = new Node(5);
            Node fourth = new Node(3);
            Node fifth = new Node(6);

            first.next = second;
            second.next = third;
            third.next = fourth;
            fourth.next = fifth;

            first.PrintAllNodes();
            Console.WriteLine();
            ModifyLinkedList(first);
            first.PrintAllNodes();

            first = new Node(2);
            second = new Node(9);
            third = new Node(8);
            fourth = new Node(12);
            fifth = new Node(7);
            Node sixth = new Node(10);

            first.next = second;
            second.next = third;
            third.next = fourth;
            fourth.next = fifth;
            fifth.next = sixth;

            Console.WriteLine();
            first.PrintAllNodes();
            Console.WriteLine();
            ModifyLinkedList(first);
            first.PrintAllNodes();
        }
    }
}
