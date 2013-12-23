public class Roulette 
{
	int results;
	int winnings;
	int bet;
	int limit;
	int roll;
	int time;
	public static void main(String[]args)
	{
		System.out.println();
		for(int i = 1; i < 100; i++)
		{
			Roulette roulette = new Roulette(1000000000,100,10000);
		}
	}
	public Roulette(int lim, int tim, int tri)
	{
		results = 0;
		for(int k = 0; k < tri; k++)
		{
			winnings = 0;
			time = tim;
			limit = lim;
			bet = 1;
			for(int i = 0; i < time; i++)
			{
				roll = (int)(Math.random()*38);
				if(roll >= 1 && roll <=18)
				{
					winnings+= bet;
					bet = 1;
				}//end if
				else
				{
					winnings -= bet;
					if((winnings - bet*2) > (-1*limit))
					{
						bet = bet*2;
					}
					else
					{
						i = time;
					}
				}//end else
				//System.out.println(winnings);
			}//end for
			results+= winnings;
			//System.out.println(winnings);
			//System.out.println(results);
		}//end for
		System.out.println((double)results/tri);
	}//end method
}//end class
