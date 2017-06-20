using System;
using System.Collections.Generic;
using BinaryTree;

namespace BinaryTreeExercise
{
    class BinaryTreeTest
    {
        static void Main(string[] args)
        {
            Tree head = new Tree(5);
            Tree leftChild = new Tree(4);
            Tree rightChild = new Tree(6);

            head.Insert(leftChild);
            head.Insert(rightChild);

            Console.WriteLine("head value: " + head.GetValue());
            Console.WriteLine("left child value: " + head.GetLeftChild().GetValue());
            Console.WriteLine("right child value: " + head.GetRightChild().GetValue());
            //Console.WriteLine("right grandchild value: " + head.GetRightChild().GetRightChild().GetValue()); // fails with a NullReferenceException
        }
    }
}
