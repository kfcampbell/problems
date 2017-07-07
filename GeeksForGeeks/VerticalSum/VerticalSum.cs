using System;
using System.Collections.Generic;
using System.Linq;

namespace VerticalSum
{
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

    class VerticalSum
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

            PrintSumOfVerticalPaths(head);
        }

        static void PrintSumOfVerticalPaths(Node head)
        {
            if(head == null) return;

            PrintSumOfVerticalPaths(head.leftChild, new List<int> {head.value});
            PrintSumOfVerticalPaths(head.rightChild, new List<int> {head.value});
        }

        static void PrintSumOfVerticalPaths(Node head, List<int> values)
        {
            if(head == null) return;
            values.Add(head.value);

            if(head.leftChild == null && head.rightChild == null)
            {
                Console.WriteLine(string.Join("-->", values.ToArray()) + ". Sum: " + values.Sum());
            }
            else if(head.leftChild != null && head.rightChild == null)
            {
                PrintSumOfVerticalPaths(head.leftChild, values);
            }
            else if(head.leftChild == null && head.rightChild != null)
            {
                PrintSumOfVerticalPaths(head.rightChild, values);
            }
            else // if neither are null
            {
                PrintSumOfVerticalPaths(head.leftChild, values);
                values.RemoveAt(values.Count - 1);
                PrintSumOfVerticalPaths(head.rightChild, values);
            }
        }
    }
}
