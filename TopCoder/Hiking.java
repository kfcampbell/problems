public class Hiking
{
  public static int meet(int[] alice, int[] bob)
  {
    int i = 0; // count the minutes since 8:00
    int a = 0; // count the meters alice has hiked
    int b = 0; // count the meters bob has hiked
    int hillLength = 0; // holds the height of the hill

    // find the length of the hill
    for(int j = 0; j < alice.length; j++)
    {
      hillLength += alice[j];
    }

    b = hillLength; // bob starts at the top

    do // guarantees the loop runs at least once
    {
      a += alice[i]; // alice hikes up the hill
      b -= bob[i]; // bob hikes down the hill
      i++; // increment the minutes taken

      if(a == b) // if they meet and stop to talk a while.
      {
        i++;
        break; // stops the loop from still counting the time if they meet and stop to talk for a couple of minutes.
      }
    } while(a < b && (i < alice.length)); // make sure that alice hasn't passed bob yet and that they're still hiking.
    // NOTE: a better solution than alice.length would be to use max(alice.length, bob.length).

    return (i - 1); // round down to the beginning of the minute they passed each other.
  }

  public static void main(String[] args)
  {
    // test cases from topcoder.
    int[] alice = {25,25,25,25,25,25,25,25,25,25};
    int[] bob = {30,30,30,30,30,30,30,20,20};
    int test1 = meet(alice, bob);
    System.out.println("Test1 = " + test1);

    int[] alice2 = {100,100,0,0,0,100,100};
    int[] bob2 = {100,100,0,0,0,100,100};
    int test2 = meet(alice2, bob2);
    System.out.println("Test2 = " + test2);

    int[] alice3 = {100,100,100,100,100,100,100,100,100,100};
    int[] bob3 = {1000};
    int test3 = meet(alice3, bob3);
    System.out.println("Test3 = " + test3);

    int[] alice4 = {1,2,3,4,5,6,7,8,9,30};
    int[] bob4 = {1,2,3,4,5,6,7,8,9,30};
    int test4 = meet(alice4, bob4);
    System.out.println("Test4 = " + test4);

  }
}
