using System;

namespace IndexOfFirstOne
{
    class IndexOfFirstOne
    {
        // Given a sorted array consisting 0s and 1s, find the index of first ‘1’ in the array.
        static void Main(string[] args)
        {
            int[] firstCase = new int[] { 0, 0, 0, 0, 0, 1, 1, 1, 1 };
            int[] secondCase = new int[] { 0, 0, 0, 0 };
            int[] thirdCase = new int[] { 1, 1, 1 };

            Console.WriteLine($"firstCase index of first 1: {GetIndexOfFirstOne(firstCase)}");
            Console.WriteLine($"secondCase index of first 1: {GetIndexOfFirstOne(secondCase)}");
            Console.WriteLine($"thirdCase index of first 1: {GetIndexOfFirstOne(thirdCase)}");
        }

        public static int GetIndexOfFirstOne(int[] nums)
        {
            int mid = nums.Length / 2;
            int low = 0;
            int high = nums.Length - 1;

            if(nums[mid] == 0) return GetIndexOfFirstOne(nums, mid + 1, high);
            else if(nums[mid] == 1) return GetIndexOfFirstOne(nums, low, mid - 1);

            // given the parameters of the problem, this will never happen.
            return -1;
        }

        public static int GetIndexOfFirstOne(int[] nums, int low, int high)
        {
            if(low > high) return -1;
            if(low == high && nums[low] == 1) return low;

            int mid = (high + low) / 2;
            
            if(nums[mid] == 0) return GetIndexOfFirstOne(nums, mid + 1, high);
            if(nums[mid] == 1) return GetIndexOfFirstOne(nums, low, mid - 1);

            // given the parameters of the problem, this will never happen.
            return -1;
        }
    }
}
