public class TimeOfPossession
{
  public static String getTime(String[] times)
  {
    int minutes = 0; // hold the amount of minutes
    int seconds = 0; // hold the amount of seconds
    boolean possession = false; // true if A has possession of the ball currently

    for(int i = 0; i < times.length; i++) // first possession a special case?
    {
      String curr = times[i]; // hold the string we're looking at currently
      String[] possSplit = curr.split("\\s+"); // going to be only two elements

      String ball = possSplit[0]; // check if A or B has possession or it's the end of the game
      String time = possSplit[1]; // record the amount of time it is

      String[] timeSplit = curr.split(":"); // so we can get at the hours and minutes individually

      String minutesPart = timeSplit[0]; // get a string with the minutes.
      String secondsPart = timeSplit[1]; // get a string with the seconds

      minutesPart = minutesPart.replaceAll("\\D+",""); // remove the word from the minutes part

      System.out.println("Minutes part: " + minutesPart);
      System.out.println("Seconds part: " + secondsPart);

      // see who has the ball
      if(ball.charAt(0) == 'A') // A has the ball now.
      {
        possession = true; // A has the ball now.
        // now it's time to worry about the time
        for(int j = minutesPart.length() - 1; j >= 0; j--) // iterate through the minutes digits
        {
          int currDigit = Character.getNumericValue(minutesPart.charAt(j));
          minutes = minutes + currDigit*(int)Math.pow(10, j);
          System.out.println("Value to be added: " + currDigit*(int)Math.pow(10, j));
          System.out.println("Current total: " + minutes + ", j = " + j + ", currDigit = " + currDigit);
        }

        for(int j = secondsPart.length() - 1; j >= 0; j--)
        {
          int currDigit = Character.getNumericValue(secondsPart.charAt(j));
          seconds = seconds + currDigit*(int)Math.pow(10, j);
          System.out.println("Value to be added: " + currDigit*(int)Math.pow(10, j));
          System.out.println("Current total: " + seconds + ", j = " + j + ", currDigit = " + currDigit);
        }

      }
      else if(ball.charAt(0) == 'B') // if B has the ball now
      {
        System.out.println("B has the ball now.");
      }
      else if(ball.charAt(0) == 'S') // if possession is switched
      {
        System.out.println("Possession switches now.");
      }
      else // if(split[0].charAt(2) == 'E') // if it's the end of the game
      {
        System.out.println("End of the game.");
      }
    }

    System.out.println("Total time of possession for A is " + minutes + ":" + seconds + ".");

    return "True";
  }

  public static void main(String[] args)
  {
    // topcoder test cases
    String[] test1 = {"A 0:00","SWITCH 1:23","END 3:00"};
    String[] test2 = {"A 0:00","SWITCH 1:23","SWITCH 4:50","END 15:00"};
    String[] test3 = {"A 0:00","SWITCH 0:00","END 15:00"};

    String test1Result = getTime(test1);
    String test2Result = getTime(test2);
    String test3Result = getTime(test3);

    System.out.println("Test 1 result: " + test1Result);
    System.out.println("Test 2 result: " + test2Result);
    System.out.println("Test 3 result: " + test3Result);
  }
}
