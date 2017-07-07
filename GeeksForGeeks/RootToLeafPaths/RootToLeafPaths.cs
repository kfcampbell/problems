using System;
using System.Collections.Generic;

namespace RootToLeafPaths
{
    // Given a Binary Tree of size N, your task is to complete the function printPaths() that 
    //prints all the possible paths from root node to the all the leaf node's of the binary tree.
    public class Node
    {
        public int value;
        public Node leftChild;
        public Node rightChild;

        public Node(int value)
        {
            this.value = value;
        }
    }

    class RootToLeafPaths
    {
        static void Main(string[] args)
        {
            Node head = new Node(5);
            Node leftChild = new Node(3);
            Node rightChild = new Node(7);
            Node leftCenterGrandChild = new Node(4);
            Node leftLeftGrandChild = new Node(1);
            Node rightGrandChild = new Node(8);
            Node rightMidGrandChild = new Node(6);

            head.leftChild = leftChild;
            head.rightChild = rightChild;
            head.leftChild.rightChild = leftCenterGrandChild;
            head.leftChild.leftChild = leftLeftGrandChild;
            head.rightChild.rightChild = rightGrandChild;
            head.rightChild.leftChild = rightMidGrandChild;

            PrintRootToLeafPaths(head);
        }

        static void PrintRootToLeafPaths(Node head)
        {
            if(head == null) return;

            PrintRootToLeafPaths(head.leftChild, new List<int> {head.value});
            PrintRootToLeafPaths(head.rightChild, new List<int> {head.value});
        }

        static void PrintRootToLeafPaths(Node head, List<int> values)
        {
            if(head == null) return;
            values.Add(head.value);

            if(head.leftChild == null && head.rightChild == null)
            {
                Console.WriteLine(string.Join("-->", values.ToArray()));
            }
            else if(head.leftChild != null && head.rightChild == null)
            {
                PrintRootToLeafPaths(head.leftChild, values);
            }
            else if(head.leftChild == null && head.rightChild != null)
            {
                PrintRootToLeafPaths(head.rightChild, values);
            }
            else // if neither are null
            {
                PrintRootToLeafPaths(head.leftChild, values);
                values.RemoveAt(values.Count - 1);
                PrintRootToLeafPaths(head.rightChild, values);
            }
        }
    }
}
