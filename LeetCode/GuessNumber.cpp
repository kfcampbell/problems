// Forward declaration of guess API.
// // @param num, your guess
// // @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
int guess(int num);

class Solution
{

 public:
     int guessNumber(int n)
     {
         int low = 1;
         int high = n; // apparently the range is from 1-n 

         if(guess(0) == n)
         {
             return n;
         }

         while (low <= high)
         {
             int mid = low + ((high - low)/2);
             int currGuess = guess(mid);

             if(currGuess == 0) // we've done it
             { 
                 return mid;
             }
             else if(currGuess == -1)
             {
                 high = mid - 1;
             }
             else // if currGuess == 1
             {
                 low = mid + 1;
             }
         }
         return -1; // this wasn't supposed to happen...
     }

};
