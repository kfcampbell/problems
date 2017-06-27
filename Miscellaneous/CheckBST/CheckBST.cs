using System;

namespace CheckBST
{
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
    class CheckBST
    {
        static void Main(string[] args)
        {
            Tree head = new Tree(5);
            Tree leftChild = new Tree(3);
            Tree rightChild = new Tree(7);
            Tree leftGrandChild = new Tree(4);
            Tree rightGrandChild = new Tree(8);

            head.leftChild = leftChild;
            head.rightChild = rightChild;
            head.leftChild.rightChild = leftGrandChild;
            head.rightChild.rightChild = rightGrandChild;

            Console.WriteLine($"valid binary tree: {IsValidBST(head)}");

            head.rightChild.rightChild.value = 4;
            Console.WriteLine($"valid binary tree: {IsValidBST(head)}");
        }

        public static bool IsValidBST(Tree head)
        {
            if(head == null)
            {
                return true;
            }

            if(head.leftChild == null && head.rightChild == null)
            {
                return true;
            }

            if(head.leftChild != null && head.leftChild.value >= head.value)
            {
                return false;
            }

            if(head.rightChild != null && head.rightChild.value < head.value)
            {
                return false;
            }


            return IsValidBST(head.leftChild) && IsValidBST(head.rightChild);
        }
    }
}
