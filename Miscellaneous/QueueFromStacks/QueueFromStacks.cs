using System;
using System.Collections.Generic;

namespace QueueFromStacks
{
    class QueueFromStacks
    {
        static void Main(string[] args)
        {
            NewQueue queue = new NewQueue();
            queue.Enqueue(4);
            queue.Enqueue(5);
            queue.Enqueue(6);
            Console.WriteLine("first element in queue: " + queue.Peek());

            int firstElement = queue.Dequeue();
            int secondElement = queue.Dequeue();
            Console.WriteLine("first element in queue: " + queue.Peek());

            queue.Clear();
            Console.WriteLine("queue size: " + queue.Count());
        }
    }
}
