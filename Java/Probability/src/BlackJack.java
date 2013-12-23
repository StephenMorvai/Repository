
public class BlackJack 
{
	private Card[] p = new Card[10];
	private Card[] d = new Card[10];
	private Deck deck;
	
	private int playerLimit;
	private int dealerLimit;
	
	private int[] playerBustTally = new int[12];
	private int[] dealerBustTally = new int[12];
	
	private int playerWins;
	private int dealerWins;
	private int ties;
	
	public static void main(String[]args)
	{
		BlackJack blackjack = new BlackJack();
	}
	public BlackJack()
	{
		deck = new Deck();
		deck.shuffleDeck();
		for(int i = 0; i < 10; i++)
		{
			p[i] = deck.getCards()[i];
		}
		for(int i = 0; i < 10; i++)
		{
			d[i] = deck.getCards()[10 + i];
		}
		playerBustTally[checkPlayerCardsBeforeBust()]++;
		dealerBustTally[checkDealerCardsBeforeBust()]++;
		for(int i = 0; i < 10; i++)
		{
			System.out.println(p[i].getValue());
		}
		System.out.println(playerBustTally[1]);
		System.out.println(playerBustTally[2]);
		System.out.println(playerBustTally[3]);
		System.out.println(playerBustTally[4]);
		System.out.println(playerBustTally[5]);
		System.out.println(playerBustTally[6]);
		System.out.println(playerBustTally[7]);
	}
	public int checkPlayerCardsBeforeBust()
	{
		int sum = 0;
		for(int i = 0; i < 10; i++)
		{
			sum += convertToBlackJack(p[i].getValue());
			if(sum > 21 && playerWentBust())
			{
				return i+1;
			}
		} 
		return 11;
	}
	public int checkDealerCardsBeforeBust()
	{
		int sum = 0;
		for(int i = 0; i < 10; i++)
		{
			sum += convertToBlackJack(d[i].getValue());
			if(sum > 21 && dealerWentBust())
			{
				return i+1;
			}
		} 
		return 11;
	}
	int sum = 0;
	public int getPlayerSum()
	{
		sum = 0;
		for(int i = 0; i < 10; i++)
		{
			sum += convertToBlackJack(p[i].getValue());
			if(sum > playerLimit)
			{
				return sum;
			}
		} 
		return sum;
	}
	int sum2 = 0;
	public int getDealerSum()
	{
		sum2 = 0;
		for(int i = 0; i < 10; i++)
		{
			sum2 += convertToBlackJack(d[i].getValue());
			if(sum2 > dealerLimit)
			{
				return sum2;
			}
		} 
		return sum2;
	}
	public boolean playerWentBust()
	{
		if(getPlayerSum() > 21)
		{
			for(int i = 0; i < 10; i++)
			{
				if(p[i].getValue() == Card.ACE)
				{
					p[i].setValue(Card.JOKER);
					i = 10;
				}
			}
		}
		else
		{
			return false;
		}
		if(getPlayerSum() > 21)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public boolean dealerWentBust()
	{
		if(getDealerSum() > 21)
		{
			for(int i = 0; i < 10; i++)
			{
				if(d[i].getValue() == Card.ACE)
				{
					d[i].setValue(Card.JOKER);
					i = 10;
				}
			}
		}
		else
		{
			return false;
		}
		if(getDealerSum() > 21)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public int convertToBlackJack(int card)
	{
		switch(card)
		{
			case Card.ACE:
				return 11;
			case 2:
				return 2;
			case 3:
				return 3;
			case 4:
				return 4;
			case 5:
				return 5;
			case 6:
				return 6;
			case 7:
				return 7;
			case 8:
				return 8;
			case 9:
				return 9;
			case 10:
				return 10;
			case Card.JACK:
				return 10;
			case Card.QUEEN:
				return 10;
			case Card.KING:
				return 10;
			default:
				return 1;
		}
	}//end if
}
