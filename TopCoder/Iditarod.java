import java.util.*;

public class Iditarod
{
	// problems with this code: variables declared should be at the beginning of relevant code blocks and not spread throughout the code
	public int avgMinutes(String[] times)
	{
		// initialize an array to hold the times in minutes
		int[] allTimes = new int[times.length];

		// now iterate through the string versions of the times
		for(int i = 0; i < times.length; i++)
		{
			// values to hold the useful digits
			char hourFirst = times[i].charAt(0);
			char hourSecond = times[i].charAt(1);
			char minFirst = times[i].charAt(3);
			char minSecond = times[i].charAt(4);
			char ampm = times[i].charAt(6);
			char dayFirst = ' ';
			char daySecond = ' ';

			// check if day is one or two digits.
			try
			{
				dayFirst = times[i].charAt(14);
				daySecond = times[i].charAt(15);
			}
			catch(Exception ex)
			{
				dayFirst = times[i].charAt(14);
				daySecond = 'x';
			}

			System.out.println("Chars:");
			System.out.println("hourone:" + hourFirst + "hourtwo:" + hourSecond + "minone:" + minFirst + "mintwo:" + minSecond + "ampm:" + ampm + "dayone:"
				+ dayFirst + "daytwo:" + daySecond);

			// get the numeric values of each character
			int hourOne = Character.getNumericValue(hourFirst);
			int hourTwo = Character.getNumericValue(hourSecond);
			int minOne = Character.getNumericValue(minFirst);
			int minTwo = Character.getNumericValue(minSecond);
			int dayOne;
			int dayTwo;
			int daysCheck;

			if(daySecond == 'x')
			{
				dayOne = Character.getNumericValue(dayFirst);
				dayTwo = -1;
				daysCheck = Character.getNumericValue(dayFirst);
			}
			else
			{
				dayOne = Character.getNumericValue(dayFirst);
				dayTwo = Character.getNumericValue(daySecond);
				daysCheck = Character.getNumericValue(dayFirst)*10 + Character.getNumericValue(daySecond);
			}

			System.out.println("Ints:");
			System.out.println("hourone:" + hourOne + "hourtwo:" + hourTwo + "minone:" + minOne + "mintwo:" + minTwo + "ampm:" + ampm + "dayone:"
				+ dayOne + "daytwo:" + dayTwo);

			System.out.println("Dayscheck:" + daysCheck);

			// translate this into hours and minutes from 8:00AM Day 1
			int hours;
			int minutes;
			int totalMinutes = 0;

			// add the number of minutes for each complete day
			for(int j = 1; j < daysCheck; j++)
			{
				totalMinutes += 24*60;
			}

			hours = hourOne*10 + hourTwo;
			minutes = minOne*10 + minTwo;

			// special case: when the time is 12:xx PM, don't add 12 hours to adjust for non-military clocks.
			if(ampm == 'P' && hours < 12)
			{
				System.out.println("ampm check entered");
				hours += 12;
			}

			// special case: when the time is 12:xx AM, only add the minutes.
			if(ampm == 'A' && hours == 12)
			{
				hours = 0;
			}

			System.out.println("totalHours:" + hours + "totalMinutes:" + minutes);

			totalMinutes += hours*60;
			totalMinutes += minutes;
			totalMinutes -= 480;

			// finally, get the total number of minutes.
			int totalHours;
			int totalDays;

			//totalMinutes = minutes + hours*60 + days*24*60 - ;
			allTimes[i] = totalMinutes;
			System.out.println("totalMinutes:" + totalMinutes);

		}

		// now calculate the average number of minutes and return it.
		double runningTotal = 0;
		double avg;

		for(int i = 0; i < allTimes.length; i++)
		{
			runningTotal += allTimes[i];
		}

		avg = runningTotal/allTimes.length;

		System.out.println("average:" + avg);
		System.out.println("runningTotal:" + runningTotal);
		return (int)Math.round(avg);
	}

	public static void main(String[] args) 
	{ 
      	Iditarod id = new Iditarod();
      	String[] arguments = {"12:00 PM, DAY 1", "12:01 PM, DAY 1"};
      	id.avgMinutes(arguments);
   	}
}