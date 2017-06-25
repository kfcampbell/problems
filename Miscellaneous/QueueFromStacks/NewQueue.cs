using System;
using System.Collections.Generic;

namespace QueueFromStacks
{
    class NewQueue
    {
        private Stack<int> mainStack;
        private Stack<int> spareStack;

        public NewQueue()
        {
            mainStack = new Stack<int>();
            spareStack = new Stack<int>();
        }

        public void Enqueue(int item)
        {
            mainStack.Push(item);
        }

        public int Dequeue()
        {
            return PeekPopHelper(true);
        }

        public int Peek()
        {
            return PeekPopHelper(false);            
        }

        private int PeekPopHelper(bool isPop)
        {
            while(mainStack.Count != 0)
            {
                int item = mainStack.Pop();
                spareStack.Push(item);
            }
            int firstElement = isPop ? spareStack.Pop() : spareStack.Peek();

            while(spareStack.Count != 0)
            {
                int item = spareStack.Pop();
                mainStack.Push(item);
            }

            return firstElement;
        }

        public int Count()
        {
            return mainStack.Count;
        }

        public void Clear()
        {
            mainStack.Clear();
        }
    }
}
