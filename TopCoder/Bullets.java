public class Bullets
{
	// function to shift the string one character to the right (wrap-around)
	public static String shift(String s) 
	{
    	return s.charAt(s.length()-1)+s.substring(0, s.length()-1);
	}	
	
	public static int match(String[] guns, String bullet)
	{
		// first iterate through all the possible shifts of bullet
		for(int i = 0; i < bullet.length(); i++)
		{
			// then check if any of the shifts is equal to the gun pattern
			for(int j = 0; j < guns.length; j++)
			{
				// if there is a match, we can return right away
				if(guns[j].equals(bullet))
				{
					System.out.println("Match found! -> " + j);
					return j;
				}
			}

			// shift the bullet one pattern before checking all the gun patterns again.
			bullet = shift(bullet);
			System.out.println("Bullet: " + bullet);
		}

		// if we've checked everything and haven't returned yet, there isn't a match.
		System.out.println("No match found");
		return -1;
	}

	// main function for testing
	public static void main(String[] args)
	{
		//String[] guns = {"| | | |","|| || |"," |||| "};
		//match(guns, "|| || |");

		String[] guns = {"||| |","| | || "};
		match(guns, "|||| ");
	}

	
}