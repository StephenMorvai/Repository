/**
 * Is the base for the tile class.
 * Before when items and obstacles were there own class, 
 * items and obstacles would have also been GameObjects
 * @author Stephen Morvai
 *
 */
public class GameObject implements Comparable<GameObject>
{
	int xPosition = 0;
	int yPosition = 0;
	int type = 0;
	
	public int getXPosition()
	{
		return xPosition;
	}
	public void setXPosition(int xPos)
	{
		xPosition = xPos;
	}
	public int getYPosition()
	{
		return yPosition;
	}
	public void setYPosition(int yPos)
	{
		yPosition = yPos;
	}
	public int getType()
	{
		return type;
	}
	public int compareTo(GameObject o) 
	{
		if(o.getXPosition() > getXPosition())
		{
			return 1;
		}
		else if (o.getXPosition() < getXPosition())
		{
			return -1;
		}
		else if (o.getYPosition() > getYPosition())
		{
			return 1;
		}
		else if (o.getYPosition() > getYPosition())
		{
			return -1;
		}
		else
		{
			return 0;
		}
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
}
