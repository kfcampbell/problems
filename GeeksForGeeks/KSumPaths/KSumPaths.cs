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

    class KSumPaths
    {
        public static int CalculateKSumPaths(int desiredSum, Tree head)
        {
            if (head == null) return 0;
            return CalculatePathsHelper(desiredSum, head.value, head.leftChild, 0) + CalculatePathsHelper(desiredSum, head.value, head.rightChild, 0);
        }

        private static int CalculatePathsHelper(int desiredSum, int currentSum, Tree head, int numberOfPaths)
        {
            if (head == null) return numberOfPaths;
            if (desiredSum == head.value + currentSum) numberOfPaths++;
            else if (head.leftChild != null && head.rightChild != null)
            {
                return CalculatePathsHelper(desiredSum, currentSum + head.value, head.leftChild, numberOfPaths)
                 + CalculatePathsHelper(desiredSum, currentSum + head.value, head.rightChild, numberOfPaths);
            }
            else if(head.leftChild != null)
            {
                return CalculatePathsHelper(desiredSum, currentSum + head.value, head.leftChild, numberOfPaths);
            }
            else if(head.rightChild != null)
            {
                return CalculatePathsHelper(desiredSum, currentSum + head.value, head.rightChild, numberOfPaths);
            }

            return numberOfPaths;
        }

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

            Console.WriteLine($"number of paths found: {CalculateKSumPaths(8, head)}");
            Console.WriteLine($"number of paths found: {CalculateKSumPaths(76, head)}");
        }
    }
}
