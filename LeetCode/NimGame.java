public class NimGame
{ // this is problem # 292
  // note that you always have the first turn removing stones.
  // 1, 2, or 3 stones can be removed at a time.
  public static boolean canWinNim(int n)
  {
      if(n % 4 == 0) // it's impossible to win when picking first if the number of stones is a multiple of 4.
      {
        return false;
      }
      else // otherwise it's possible to win.
      {
        return true;
      }
  }

  public static void main(String[] args)
  {
    System.out.println("Case of 16 stones: " + canWinNim(16));
    System.out.println("Case of 15 stones: " + canWinNim(15));
  }
}
