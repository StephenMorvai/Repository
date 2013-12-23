
public class Poker 
{
	private Card[] c = new Card[5]; 
	private int[] tally = new int[15];
	private int[] counts = new int[10];
	
	public static void main(String[]args)
	{
		Poker poker = new Poker();
	}
	public Poker()
	{
		int percent = 0;
		for(int i = 0; i < 10; i ++)
		{
			counts[i] = 0;
		}
		for(int k = 0; k < 100000000; k++)
		{
			if(k%1000000 == 0)
			{
				percent++;
				System.out.println(percent + "% complete");
			}
			for(int i = 1; i <= 13; i ++)
			{
				tally[i] = 0;
			}
			Deck deck = new Deck();
			deck.shuffleDeck();
			checkHand(deck.getCards());
		}//end for
		for(int i = 0; i < 10; i++)
		{
			System.out.println(counts[i]);
		}//end for
	}
	private void checkHand(Card[] cards)
	{
		for(int i = 0; i < 5; i++)
		{
			c[i] = cards[i];
			tally[c[i].getValue()]++;
		}//end for
		Sort.insertionSort(c);
		if(isRoyalFlush())
		{
			
		}
		else if (isStraightFlush())
		{
			
		}
		else if (isFour())
		{
			
		}
		else if(isFullHouse())
		{
			
		}
		else if (isFlush())
		{
			
		}
		else if (isStraight())
		{
			
		}
		else if (isThree())
		{
			
		}
		else if (isTwoPair())
		{
			
		}
		else if(isPair())
		{
			
		}
		else //High Card
		{
			counts[9]++;
		}
	}
	private boolean isRoyalFlush()
	{
		if(c[0].getSuit() == c[1].getSuit() && c[1].getSuit() == c[2].getSuit() && c[2].getSuit() == c[3].getSuit() && c[3].getSuit() == c[4].getSuit() && c[0].getValue() == Card.ACE && c[1].getValue() == 10 && c[2].getValue() == Card.JACK && c[3].getValue() == Card.QUEEN && c[4].getValue() == Card.KING)
		{
			counts[0]++;
			return true;
		}//end if
		else
		{
			return false;
		}//end else
	}//end is RoyalFlush
	private boolean isStraightFlush()
	{
		if(c[0].getSuit() == c[1].getSuit() && c[1].getSuit() == c[2].getSuit() && c[2].getSuit() == c[3].getSuit() && c[3].getSuit() == c[4].getSuit() && isStraight())
		{
			counts[5]--;
			counts[1]++;
			return true;
		}//end if
		else
		{
			return false;
		}//end else
	}//end is StraightFlush
	private boolean isFlush()
	{
		if(c[0].getSuit() == c[1].getSuit() && c[1].getSuit() == c[2].getSuit() && c[2].getSuit() == c[3].getSuit() && c[3].getSuit() == c[4].getSuit())
		{
			counts[4]++;
			return true;
		}//end if
		else
		{
			return false;
		}//end else
	}
	private boolean isStraight()
	{
		for(int i = 1; i < 5; i++)
		{
			if(c[i].getValue() != c[0].getValue() + i)
			{
				if(c[0].getValue() == Card.ACE && c[1].getValue() == 10 && c[2].getValue() == Card.JACK && c[3].getValue() == Card.QUEEN && c[4].getValue() == Card.KING)
				{
					counts[5]++;
					return true;
				}//end if
				else
				{
					return false;
				}//end else
			}//end if
		}//end for
		counts[5]++;
		return true;
	}//end isStraight
	public boolean isFullHouse()
	{
		for(int i = 1; i <=13; i++)
		{
			if(tally[i] == 3)
			{
				for(int j = 1; j <=13; j++)
				{
					if(tally[j] == 2)
					{
						counts[3]++;
						return true;
					}//end if
				}//end for
			}//end if
		}//end for
		return false;
	}//end isFullHouse
	public boolean isFour()
	{
		for(int i = 1; i <=13; i++)
		{
			if(tally[i] == 4)
			{
				counts[2]++;
				return true;
			}//end if
		}//end for
		return false;
	}//end isFour
	public boolean isThree()
	{
		for(int i = 1; i <=13; i++)
		{
			if(tally[i] == 3)
			{
				counts[6]++;
				return true;
			}//end if
		}//end for
		return false;
	}//end isThree
	public boolean isTwoPair()
	{
		int count = 0;
		for(int i = 1; i <=13; i++)
		{
			if(tally[i]==2)
			{
				count++;
			}
		}//end for
		if(count==2)
		{
			counts[7]++;
			return true;
		}
		else
		{
			return false;
		}
	}//end isTwoPair
	public boolean isPair()
	{
		for(int i = 1; i <=13; i++)
		{
			if(tally[i]==2)
			{
				counts[8]++;
				return true;
			}
		}//end for
		return false;
	}//end isPair
}//end class
