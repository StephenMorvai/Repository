
public class Deck 
{
	private boolean hasJokers;//Will do
	private Card[] cards;
	private int indexTop;
	public Deck()
	{
		cards = new Card[52];
		indexTop = 0;
		fillDeck();
	}
	private void fillDeck()
	{
		for(int i = 0; i < 4; i++)
		{
			for(int j = 1; j <= 13; j++)
			{
				cards[i*13 + j - 1] = new Card(i,j);
			}
		}
	}
	public void shuffleDeck()
	{
		indexTop = 0;
		for(int i = 0; i < 100; i++)
		{
			int rand1 = (int)(Math.random()*52);
			int rand2 = (int)(Math.random()*52);
			Card temp = cards[rand1];
			cards[rand1] = cards[rand2];
			cards[rand2] = temp;
		}//end for
	}
	public void drawCard()
	{
		indexTop++;
	}
	public int getIndexTop()
	{
		return indexTop;
	}
	public Card[] getCards()
	{
		return cards;
	}
	public String toString()
	{
		String print = "";
		for(int i = 0; i < 52; i++)
		{
			print = print + "\n" + cards[i];
		}
		return print;
	}
}
