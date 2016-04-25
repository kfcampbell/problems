// this is Plus One, problem #66 on LeetCode.
// it has a runtime of 0ms on LeetCode.
import java.util.*;

public class PlusOne
{
    public static int[] plusOne(int[] digits)
    {
        int carry = 1;
        for(int i = digits.length - 1; i >= 0; i--)
        {
            digits[i] += carry;
            if(digits[i] <= 9)
            {
                return digits;
            }
            digits[i] = 0;
        }

        // if we've made it this far, we need to make a new, bigger array.
        int[] new_digits = new int[digits.length + 1];
        new_digits[0] = 1;
        /*
        // upon further testing, it turns out this is unnecessary as the default values
        // of the newly created array are all 0.
        // now we need to copy the contents of the old array back to the new one.
        for(int i = 1; i < digits.length; i++)
        {
            new_digits[i] = digits[i];
        }
        */
        return new_digits;
    }

    public static void main(String[] args)
    {
        // some test cases.
        int[] digits = {4, 5, 6, 7};
        System.out.println("PlusOne: " + Arrays.toString(plusOne(digits)));

        int[] digits_1 = {9, 9, 9, 9};
        System.out.println("PlusOne_1: " + Arrays.toString(plusOne(digits_1)));

        int[] digits_2 = {0};
        System.out.println("PlusOne_2: " + Arrays.toString(plusOne(digits_2)));
    }
}
