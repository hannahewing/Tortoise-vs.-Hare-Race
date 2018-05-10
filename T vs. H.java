//Ewing, Hannah

package PP5Package;

import java.util.Random;

public class PP5
{
	public static void track(String r[])
	{
		for(int i = 0; i < r.length; i++)
		System.out.print(r[i]);
		System.out.println();
	}
	
	public static void main( String [] args)
	{
		int turn = 1;
		int turtle = 0;
		int hare = 0;
		String blank = "_ ";
		int prev = -1;
		
		Random random = new Random();
		//Make the track 50 long
		String race[] = new String[50];
		//Make each place a _
		for (int p = 0; p < race.length; p++)
		{
			race[p] = "_ ";
		}
		//Start them at 0
		race[0] = "T & H ";
		//Display the track
		track(race);
		while ((turtle < 50) && (hare < 50))
		{
			//This is what each number means while the turtle is "running"
		if (turn % 2 == 0)
		{
			int r = random.nextInt(10);
			//fast plod
			if (r <= 5)
			{
				prev = turtle;
				turtle += 3;
				if (turtle >= 50)
					System.out.println("The Turtle won!");

				else
				{
					race[turtle] = "T ";
				}
			}
			//slip
			else if (r <= 7)
			{
				prev = turtle;
				turtle -= 6;
				if (turtle < 0)
					{
					turtle = 0;
					race[turtle] = "T ";
					}
				else
				race[turtle] = "T ";
			}
			//slow plod
			else
			{
				prev = turtle;
				turtle += 1;
				if (turtle >= 50)
					System.out.println("The Turtle won!");

				else
				race[turtle] = "T ";
			}
			race[prev] = blank;
			turn ++;
			
			if (turtle == hare)
				race[turtle] = "! ";
			
			track(race);
		}
		//This is what each number means when the hare is running
		else
		{
			int r = random.nextInt(10);
			//Sleep
			if (r <= 2)
			{
				prev = hare;
				hare += 0;
				race[hare] = "H ";
			}
			//Big hop
			else if (r <= 4)
			{
				prev = hare;
				hare += 9;
				if (hare >= 50)
					System.out.println("The Hare won!");
				else
				race[hare] = "H ";
			}
			//big slip
			else if (r == 5)
			{
				prev = hare;
				hare -= 12;
				//The hare can't be in a negative position
				if (hare < 0)
					{
					hare = 0;
					race[hare] = "H ";
					}
				else
				race[hare] = "H ";
			}
			//small hop
			else if (r <= 8)
			{
				prev = hare;
				hare += 1;
				//If the hare goes over 50 it wins
				if (hare >= 50)
					System.out.println("The Hare won!");
				else
				{
					race[hare] = "H ";
				}
			}
			//small slip
			else
			{
				prev = hare;
				hare -= 2;
				//The hare can't have a negative number
				if (hare < 0)
				{
					hare = 0;
					race[hare] = "H ";
				}
				else
				race[hare] = "H ";
			}
			race[prev] = blank;
			turn++;
			
			track(race);
			//If the turtle and hare are tied
			if (turtle == hare)
				race[turtle] = "! ";
		}
		}
		//If they end in a tie
		if (hare == turtle)
			System.out.println("It was a tie!");
		
	}
}
