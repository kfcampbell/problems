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
            if(newNode.value < this.value)
            {
                if(leftChild == null)
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
                if(rightChild == null)
                {
                    this.rightChild = newNode;
                }
                else 
                {
                    rightChild.Insert(newNode);
                }
            }
        }
    }
}