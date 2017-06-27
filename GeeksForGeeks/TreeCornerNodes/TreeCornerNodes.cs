using System;
using System.Collections.Generic;


// print the corner nodes at each level of a given binary tree.
namespace TreeCornerNodes
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

    class TreeCornerNodes
    {
        public static void PrintCornerNodes(Tree head)
        {
            if (head == null) return;

            Queue<Tree> queue = new Queue<Tree>();
            queue.Enqueue(head);

            while (queue.Count > 0)
            {
                int size = queue.Count;
                int currentLevelSize = size;

                while (currentLevelSize > 0)
                {
                    Tree currentNode = queue.Dequeue();
                    currentLevelSize--;

                    if (currentLevelSize == size - 1 || currentLevelSize == 0)
                    {
                        Console.Write($"{currentNode.value} ");
                    }

                    if(currentNode.leftChild != null)
                    {
                        queue.Enqueue(currentNode.leftChild);
                    }
                    if(currentNode.rightChild != null)
                    {
                        queue.Enqueue(currentNode.rightChild);
                    }
                }

                Console.WriteLine();
            }
        }

        static void Main(string[] args)
        {
            Tree head = new Tree(5);
            Tree leftChild = new Tree(3);
            Tree rightChild = new Tree(7);
            Tree leftCenterGrandChild = new Tree(4);
            Tree leftLeftGrandChild = new Tree(1);
            Tree rightGrandChild = new Tree(8);

            head.leftChild = leftChild;
            head.rightChild = rightChild;
            head.leftChild.rightChild = leftCenterGrandChild;
            head.leftChild.leftChild = leftLeftGrandChild;
            head.rightChild.rightChild = rightGrandChild;

            PrintCornerNodes(head);
        }
    }
}
