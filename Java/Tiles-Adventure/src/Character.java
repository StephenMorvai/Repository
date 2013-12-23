/**
 * Basically unused beyond being the parent to the player class. 
 * Extending to the GameObject class give the player class more methods
 * @author Stephen Morvai
 */
public class Character extends GameObject
{
	//types
	final static int GENERIC = 0;
	final static int NPC = 1;
	final static int PLAYER = 2;
	//Genders
	final static int OTHER = 0;
	final static int MALE = 1;
	final static int FEMALE = 2;

	int xPosition;
	int yPosition;
	int type;
	String name;
	int gender;
	
	public Character(int xPos, int yPos)
	{
		this(xPos, yPos, GENERIC, null, OTHER);
	}
	public Character(int xPos, int yPos, int typ)
	{
		this(xPos, yPos, typ, null, OTHER);
	}
	public Character(int xPos, int yPos, int typ, String nam, int gen)
	{
		//nothing. Class unused beyond being parent.
	}
	
	public void setXPosition(int xPos)
	{
		xPosition = xPos;
	}
	public void setYPosition(int yPos)
	{
		yPosition = yPos;
	}
	public void setType(int typ)
	{
		type = typ;
	}
	public void setName (String nam)
	{
		name = nam;
	}
	public void setGender(int gen)
	{
		gender = gen;
	}
	public void setLocation(String loc)
	{
		if(loc.indexOf(',') != -1 )
		{
			if(Tools.isInteger(loc.substring(0,loc.indexOf(','))))
			{
				if(Tools.isInteger(loc.substring(loc.indexOf(',')+1)))
				{
					setXPosition(Integer.parseInt(loc.substring(0,loc.indexOf(','))));
					setYPosition(Integer.parseInt(loc.substring(loc.indexOf(',')+1)));
				}//end if
				else
				{
					System.out.print("Tile.setLocation(String): Y position not an integer");
				}
			}//end if
			else
			{
				System.out.print("Tile.setLocation(String): X position not an integer");
			}
		}//end if
		else
		{
			System.out.print("Tile.setLocation(String): Not correct format");
		}
	}//end setLocation
	
	
	public int getXPosition()
	{
		return xPosition;
	}
	public int getYPosition()
	{
		return yPosition;
	}
	public int getType()
	{
		return type;
	}
	public String getName()
	{
		return name;
	}
	public int getGender()
	{
		return gender;
	}
	public String getTypeString()
	{
		if(type == GENERIC)
			return "generic";
		else if(type == NPC)
			return "NPC";
		else if(type == PLAYER)
			return "player";
		else
			return "generic";
	}
	public String getGenderString()
	{
		if(type == OTHER)
			return "other";
		else if(type == MALE)
			return "male";
		else if(type == FEMALE)
			return "female";
		else
			return "other";
	}
	public String getLocation()
	{
		return xPosition + "," + yPosition;
	}
	
	
	public void move(int direction)
	{
		if(direction == Game.UP)
		{
			xPosition--;
		}
		else if(direction == Game.DOWN)
		{
			xPosition++;
		}
		else if(direction == Game.LEFT)
		{
			yPosition--;
		}
		else if(direction == Game.RIGHT)
		{
			yPosition++;
		}
	}
	
	
	
	
	
	public boolean isOn(int typ)
	{
		return typ == getTile().getType();
	}
	
	public boolean isOn(Tile t)
	{
		return isSameLocation(t);
	}
	public Tile getTile()
	{
		return Run.getGui().getGame().getTiles()[getXPosition()][getYPosition()];
	}
	public boolean isSameLocation(GameObject o)
	{
		return o.getXPosition() == getXPosition() && o.getYPosition() == getYPosition();
	}
	public boolean isSameType(Character c)
	{
		return c.getType() == getType();
	}
	public boolean equals(Character c)
	{
		return isSameType(c) && isSameLocation((GameObject)c);
	}
	public String toString()
	{
		return "X= " + getXPosition() + "\nY= " + getYPosition() + "\nType =" + getTypeString() + "\nName =" + getName()+ "\nGender =" + getGenderString();
	}
	
	
	
	
	
}
