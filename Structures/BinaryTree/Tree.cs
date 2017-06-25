using System;
using System.Collections.Generic;

namespace BinaryTree
{
    public class Tree
    {
        int value;
        Tree leftChild;
        Tree rightChild;

        public Tree(int value)
        {
            this.value = value;
            leftChild = null;
            rightChild = null;
        }

        public int GetValue()
        {
            return this.value;
        }

        public Tree GetLeftChild()
        {
            return leftChild;
        }

        public Tree GetRightChild()
        {
            return rightChild;
        }

        public void Insert(Tree newNode)
        {
            if (newNode.value < this.value)
            {
                if (leftChild == null)
                {
                    this.leftChild = newNode;
                }
                else
                {
                    leftChild.Insert(newNode);
                }
            }
            else
            {
                if (rightChild == null)
                {
                    this.rightChild = newNode;
                }
                else
                {
                    rightChild.Insert(newNode);
                }
            }
        }

        public Tree BFS(int key)
        {
            if (this.value == key) return this;

            Queue<Tree> nodesToVisit = new Queue<Tree>();
            nodesToVisit.Enqueue(this);
            return BFSHelper(key, nodesToVisit);
        }

        private Tree BFSHelper(int key, Queue<Tree> nodesToVisit)
        {
            while (nodesToVisit.Count > 0)
            {
                Tree currentNode = nodesToVisit.Dequeue();

                if (currentNode.value == key)
                {
                    return currentNode;
                }
                else
                {
                    if (currentNode.leftChild != null)
                    {
                        nodesToVisit.Enqueue(currentNode.leftChild);
                    }
                    if (currentNode.rightChild != null)
                    {
                        nodesToVisit.Enqueue(currentNode.rightChild);
                    }
                }
            }

            return null;
        }

        public Tree DFS(int key)
        {
            if (this.value == key) return this;

            Stack<Tree> nodesToVisit = new Stack<Tree>();
            nodesToVisit.Push(this);
            return DFSHelper(key, nodesToVisit);
        }

        private Tree DFSHelper(int key, Stack<Tree> nodesToVisit)
        {
            while (nodesToVisit.Count > 0)
            {
                Tree currentNode = nodesToVisit.Pop();

                if (currentNode.value == key)
                {
                    return currentNode;
                }

                if (currentNode.leftChild != null)
                {
                    nodesToVisit.Push(currentNode.leftChild);
                }

                if (currentNode.rightChild != null)
                {
                    nodesToVisit.Push(currentNode.rightChild);
                }
            }

            return null;
        }
    }
}