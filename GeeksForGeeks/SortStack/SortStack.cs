using System;
using System.Collections.Generic;

// Given a stack, return a sorted stack.
namespace SortStack
{
    class SortStack
    {
        static void Main(string[] args)
        {
            Stack<int> stack = new Stack<int>();
            stack.Push(5);
            stack.Push(9);
            stack.Push(15);
            stack.Push(2);
            stack.Push(4);
            stack.Push(8);

            Console.WriteLine("Pre sorting: " + string.Join(",", stack.ToArray()));
            stack = Sort(stack);
            Console.WriteLine("Post sorting: " + string.Join(",", stack.ToArray()));
        }

        static Stack<int> Sort(Stack<int> stack)
        {
            if(stack == null || stack.Count < 1) return stack;

            int top = stack.Pop();
            stack = Sort(stack);
            stack = Insert(stack, top);
            
            return stack;
        }
        
        static Stack<int> Insert(Stack<int> stack, int n)
        {
            if(stack.Count < 1 || stack.Peek() > n)
            {
                stack.Push(n);
                return stack;
            }

            int temp = stack.Pop();
            stack = Insert(stack, n);
            stack.Push(temp);
            return stack;
        }

    }
}
