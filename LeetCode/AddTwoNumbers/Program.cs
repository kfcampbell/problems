using System;
using System.Collections.Generic;

namespace AddTwoNumbers
{
    // You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of
    // their nodes contain a single digit. Add the two numbers and return it as a linked list.
    // You may assume the two numbers do not contain any leading zero, except the number 0 itself.
    // Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
    // Output: 7 -> 0 -> 8
    class Node
    {
        public int value;
        public Node next;
    }


    class Program
    {
        static Node AddTwoNumbers(Node first, Node second)
        {
            Node currNodeLeft = first;
            Node currNodeRight = second;
            Node solution = new Node();
            Node currNode = solution;
            int carry = 0;

            while (true)
            {
                if (currNodeLeft == null && currNodeRight == null)
                {
                    currNode = null;
                    break;
                }

                int leftValue = 0;
                if (currNodeLeft != null)
                {
                    leftValue = currNodeLeft.value;
                }
                int rightValue = 0;
                if (currNodeRight != null)
                {
                    rightValue = currNodeRight.value;
                }

                if (rightValue + leftValue + carry >= 10)
                {
                    currNode.value = ((leftValue + rightValue) % 10) + carry;
                    carry = (leftValue + rightValue) / 10;
                }
                else
                {
                    currNode.value = leftValue + rightValue + carry;
                    carry = 0;
                }
                currNode.next = new Node();
                currNode = currNode.next;
                if (currNodeLeft != null)
                {
                    currNodeLeft = currNodeLeft.next;
                }
                if (currNodeRight != null)
                {
                    currNodeRight = currNodeRight.next;
                }
            }
            return solution;
        }

        static void Main(string[] args)
        {
            Node endFirst = new Node
            {
                value = 3,
                next = null
            };
            Node midFirst = new Node
            {
                value = 4,
                next = endFirst
            };
            Node firstfirst = new Node
            {
                value = 2,
                next = midFirst
            };

            Node endSecond = new Node
            {
                value = 4,
                next = null
            };
            Node midSecond = new Node
            {
                value = 6,
                next = endSecond
            };
            Node firstSecond = new Node
            {
                value = 5,
                next = midSecond
            };
            Node final = AddTwoNumbers(firstfirst, firstSecond);
        }
    }
}
