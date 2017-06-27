using System;
using System.Collections.Generic;

namespace KSumPaths
{
    // A binary tree and a number k are given. Print the count of every path in the tree with sum of the nodes in the path as k.
    public class Tree
    {
        public int value;
        public Tree leftChild;
        public Tree rightChild;

        public Tree(int value)
        {
            this.value = value;
        }
    }

    public class FindKSumPaths
    {
        public int numberOfPaths = 0;

        public void CalculateKSumPaths(int desiredSum, Tree head)
        {
            numberOfPaths = 0;
            if (head == null) return;

            numberOfPaths = head.value == desiredSum ? 1 : 0;
            Stack<Tree> stack = new Stack<Tree>();
            stack.Push(head);

            CalculatePathsHelper(desiredSum, head.value, head.leftChild);
            CalculatePathsHelper(desiredSum, head.value, head.rightChild);
        }

        // this works but it's sloppy. i'd like to make this recursive somehow without forfeiting successful results on negatives.
        private void CalculatePathsHelper(int desiredSum, int currentSum, Tree head)
        {
            if (head == null) return;
            if (desiredSum == head.value + currentSum) numberOfPaths++;
            else if (head.leftChild != null && head.rightChild != null)
            {
                CalculatePathsHelper(desiredSum, currentSum + head.value, head.leftChild);
                CalculatePathsHelper(desiredSum, currentSum + head.value, head.rightChild);
            }
            else if(head.leftChild != null)
            {
                CalculatePathsHelper(desiredSum, currentSum + head.value, head.leftChild);
            }
            else if(head.rightChild != null)
            {
                CalculatePathsHelper(desiredSum, currentSum + head.value, head.rightChild);
            }
        }

    }

    class KSumPaths
    {

        static void Main(string[] args)
        {
            Tree head = new Tree(5);
            Tree leftChild = new Tree(3);
            Tree rightChild = new Tree(7);
            Tree leftCenterGrandChild = new Tree(4);
            Tree leftLeftGrandChild = new Tree(1);
            Tree rightGrandChild = new Tree(-4);

            head.leftChild = leftChild;
            head.rightChild = rightChild;
            head.leftChild.rightChild = leftCenterGrandChild;
            head.leftChild.leftChild = leftLeftGrandChild;
            head.rightChild.rightChild = rightGrandChild;

            FindKSumPaths pathFinder = new FindKSumPaths();
            pathFinder.CalculateKSumPaths(8, head);

            Console.WriteLine($"number of paths found: {pathFinder.numberOfPaths}");
        }
    }
}
