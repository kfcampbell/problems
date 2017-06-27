using System;

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
            var leftSum = CalculatePathsHelper(desiredSum, head.value, head.leftChild);
            var rightSum = CalculatePathsHelper(desiredSum, head.value, head.rightChild);
            return leftSum + rightSum;
        }

        private static int CalculatePathsHelper(int desiredSum, int previousSum, Tree head)
        {
            if (head == null) return 0;
            var currentSum = previousSum + head.value;

            int numberOfPaths = 0;
            if (desiredSum == currentSum) numberOfPaths++;


            if (head.leftChild != null && head.rightChild != null)
            {
                return numberOfPaths + CalculatePathsHelper(desiredSum, currentSum, head.leftChild)
                 + CalculatePathsHelper(desiredSum, currentSum, head.rightChild);
            }
            else if (head.leftChild != null)
            {
                return numberOfPaths + CalculatePathsHelper(desiredSum, currentSum, head.leftChild);
            }
            else if (head.rightChild != null)
            {
                return numberOfPaths + CalculatePathsHelper(desiredSum, currentSum, head.rightChild);
            }

            // if both children are null
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
            Tree rightGreatGrandChild = new Tree(4);
            Tree rightGreatGreatGrandChild = new Tree(-4);

            head.leftChild = leftChild;
            head.rightChild = rightChild;
            head.leftChild.rightChild = leftCenterGrandChild;
            head.leftChild.leftChild = leftLeftGrandChild;
            head.rightChild.rightChild = rightGrandChild;
            head.rightChild.rightChild.rightChild = rightGreatGrandChild;
            head.rightChild.rightChild.rightChild.rightChild = rightGreatGreatGrandChild;

            Console.WriteLine($"number of paths found: {CalculateKSumPaths(8, head)}");
            Console.WriteLine($"number of paths found: {CalculateKSumPaths(76, head)}");
        }
    }
}
