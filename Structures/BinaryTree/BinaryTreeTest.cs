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

            // BFS test
            head.Insert(new Tree(8));
            head.Insert(new Tree(13));
            head.Insert(new Tree(2));
            head.Insert(new Tree(4));

            Tree BFSresult = head.BFS(8);
            Tree BFSNullResult = head.BFS(1);

            // DFS test
            Tree DFSresult = head.DFS(8);
            Tree DFSNullResult = head.DFS(1);
        }
    }
}
