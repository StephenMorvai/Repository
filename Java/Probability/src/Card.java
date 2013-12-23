

public class Card implements Comparable<Card>
{
	public final static int SPADES = 0;
	public final static int CLUBS = 1;
	public final static int HEARTS = 2;
	public final static int DIAMONDS = 3;
	public final static int UNKOWN = 4;
	
	public final static int ACE = 1;
	public final static int JACK = 11;
	public final static int QUEEN = 12;
	public final static int KING = 13;
	public final static int JOKER = 14;
	
	private int suit;
	private int value;
	
	public Card(int s, int v)
	{
		setSuit(s);
		setValue(v);
	}//end constructor
	public void setSuit(int s)
	{
		if(s == SPADES || s == CLUBS || s == HEARTS || s == DIAMONDS)
		{
			suit = s;
		}//end if
	}//end setSuit
	public void setValue(int v)
	{
		if(v >= 1 && v <= 14)
		{
			value = v;
		}//end if
	}//end setValue
	public int getSuit()
	{
		return suit;
	}//end get suit
	public String getSuitString()
	{
		if(getSuit()== SPADES)
			return "spades";
		else if(getSuit()== CLUBS)
			return "clubs";
		else if(getSuit()== HEARTS)
			return "hearts";
		else if(getSuit()== DIAMONDS)
			return "diamonds";
		else
			return "unknown";
	}//end getSuitString
	public int getValue()
	{
		return value;
	}//end get value
	public String getValueString()
	{
		if(getValue()== ACE)
			return "ace";
		else if(getValue()== 2)
			return "two";
		else if(getValue()== 3)
			return "three";
		else if(getValue()== 4)
			return "four";
		else if(getValue()== 5)
			return "five";
		else if(getValue()== 6)
			return "six";
		else if(getValue()== 7)
			return "seven";
		else if(getValue()== 8)
			return "eight";
		else if(getValue()== 9)
			return "nine";
		else if(getValue()== 10)
			return "ten";
		else if(getValue()== JACK)
			return "jack";
		else if(getValue()== QUEEN)
			return "queen";
		else if(getValue()== KING)
			return "king";
		else if(getValue()== JOKER)
			return "joker";
		else
			return "joker";
	}//end get value
	public String toString()
	{
		return getValueString() + " of " + getSuitString();
	}
	public boolean equals(Card c)
	{
		return c.getSuit() == getSuit() && c.getValue() == getValue();
	}
	public int compareTo(Card c) 
	{
		return getValue() - c.getValue();
	}
}//end class
