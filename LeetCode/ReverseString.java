public class ReverseString
{
    public static String reverseString(String s) 
    {
        if(s == null || s.length() == 0 || s.length() == 1)
        {
            return s;
        }

        // brute force solution too long a runtime to be accepted
        /*String new_string = "";
        for(int i = s.length() - 1; i >= 0; i--)
        {
            new_string += s.charAt(i);
        }

        return new_string;*/

        // try just swapping the letters around
        char[] s_chars = s.toCharArray();
        int mid = s.length()/2;
        for(int i = 0; i < mid; i++)
        {
            Character temp = s_chars[s.length() - 1 - i];
            s_chars[s.length() - 1 - i] = s_chars[i];
            s_chars[i] = temp;
        }
        
        return String.valueOf(s_chars);
    }

    public static void main(String[] args)
    {
        System.out.println("test case: hello " + reverseString("hello"));
    }
}