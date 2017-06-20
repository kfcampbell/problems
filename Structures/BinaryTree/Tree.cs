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

        public Tree Delete(int value)
        {
            if(value == this.value)
            {
                this.rightChild.Insert(this.leftChild);
                return this.rightChild;
            }
            else if(value < this.value)
            {
                if(this.leftChild != null)
                {
                    return this.leftChild.Delete(value);
                }
                return null;
            }
            else
            {
                if(this.rightChild != null)
                {
                    return rightChild.Delete(value);
                }
                return null;
            }
        }
    }
}