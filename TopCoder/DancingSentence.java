import java.lang.*;

// working, passes all tests. although there's no way to make letters capital.

public class DancingSentence
{
	// required public constructor
	public DancingSentence()
	{

	}

	public String makeDancing(String sentence)
	{
		StringBuilder alteredMessage = new StringBuilder();
		boolean dancingFlag = true;

		for(int i = 0; i < sentence.length(); i++)
		{
			char letter = sentence.charAt(i);
			int diff = 0;
			if(dancingFlag == true)
			{
				// if it's a space
				if(letter == ' ')
				{
					alteredMessage.append(letter);
					// dancingFlag stays true
				}
				else
				{
					// subtract 32 from the char to make it upper case
					diff = (int) letter;

					// if the letter is lowercase, make it uppercase
					if(diff > 96)
					{
						diff -= 32;
						letter = (char) diff;
						alteredMessage.append(letter);
						dancingFlag = false;
					}
					else
					{
						alteredMessage.append(letter);
						dancingFlag = false;
					}
				}
			}
			else
			{
				if(letter != ' ')
				{
					alteredMessage.append(letter);
					dancingFlag = true;
				}
				else
				{
					alteredMessage.append(letter);
				}
			}
		}

		return alteredMessage.toString();
	}
}