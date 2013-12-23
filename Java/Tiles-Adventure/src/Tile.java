
import java.util.*;

import javax.swing.*;
/***
 * This class is the game tiles. They store there images and locations in the game world.
 * @author Stephen Morvai
 *
 */

public class Tile extends GameObject implements Comparable<GameObject>
{
	final static int BLANK = 0;
	//water
	final static int WATER = 100;
	//natural land
	final static int GRASS = 200;
	final static int DIRT = 201;
	final static int SAND = 202;
	final static int ROCK = 203;
	final static int BLOCK = 204;
	//surfaces
	final static int GRID = 300;
	final static int COBBLE = 301;
	final static int WOOD = 302;
	//building
	final static int WALL_X = 400;
	final static int WALL_Y = 401;
	final static int WALL_NW = 402;
	final static int WALL_SW = 403;
	final static int WALL_NE = 404;
	final static int WALL_SE = 405;
	final static int WALL_T = 406;
	//items
	final static int DOOR_CLOSED = 500;
	final static int DOOR_OPEN = 501;
	final static int DOOR_Y_CLOSED = 502;
	final static int DOOR_Y_OPEN = 503;
	final static int TABLE_EMPTY = 510;
	final static int TABLE_KEY_UP = 511;
	final static int TABLE_KEY_DOWN = 512;
	final static int TABLE_KEY_LEFT = 513;
	final static int TABLE_KEY_RIGHT = 514;
	//NPC
	final static int SILLY = 600;
	final static int QUIZZER1 = 601;
	final static int QUIZZER2= 602;
	final static int SOLDIER1 = 603;
	final static int SOLDIER2 = 604;
	final static int LEADER = 605;
	
	
	
	
	
	int xPosition;
	int yPosition;
	int type;
	static int numOfTiles = 0;
	ImageIcon image;
	ImageIcon miniImage;
	ImageIcon miniMap;
	ImageIcon map;
	
	boolean hasPlayer;
	
	public Tile(int xPos, int yPos)
	{
		this(xPos,yPos,BLANK);
	}
	public Tile(int xPos, int yPos, int typ)
	{
		setXPosition(xPos);
		setYPosition(yPos);
		setType(typ);
		numOfTiles++;
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
		image = new ImageIcon("Library/Images/Sprites/Tiles/terrain/" + getTypeString() + ".PNG");
	}
	/**
	 * Can set a tile's location if string sent is in "x,y" format
	 * @param loc
	 */
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
	/**
	 * converts a type in the string format to integer format. Used when the map is settign types
	 * @param typ
	 * @return
	 */
	public static int convertType(String typ)
	{
		if(typ.equalsIgnoreCase(null))
			return(BLANK);
		else if(typ.equalsIgnoreCase("water"))
			return(WATER);
		else if(typ.equalsIgnoreCase("grass"))
			return(GRASS);
		else if(typ.equalsIgnoreCase("dirt"))
			return(DIRT);
		else if(typ.equalsIgnoreCase("sand"))
			return(SAND);
		else if(typ.equalsIgnoreCase("rock"))
			return(ROCK);
		else if(typ.equalsIgnoreCase("grid"))
			return(GRID);
		else if(typ.equalsIgnoreCase("cobble"))
			return(COBBLE);
		else if(typ.equalsIgnoreCase("wood"))
			return(WOOD);
		else if(typ.equalsIgnoreCase("block"))
			return(BLOCK);
		else if(typ.equalsIgnoreCase("wall_x"))
			return(WALL_X);
		else if(typ.equalsIgnoreCase("wall_y"))
			return(WALL_Y);
		else if(typ.equalsIgnoreCase("wall_nw"))
			return(WALL_NW);
		else if(typ.equalsIgnoreCase("wall_ne"))
			return(WALL_NE);
		else if(typ.equalsIgnoreCase("wall_sw"))
			return(WALL_SW);
		else if(typ.equalsIgnoreCase("wall_se"))
			return(WALL_SE);
		else if(typ.equalsIgnoreCase("wall_t"))
			return(WALL_T);
		else if(typ.equalsIgnoreCase("door_closed"))
			return(DOOR_CLOSED);
		else if(typ.equalsIgnoreCase("door_open"))
			return(DOOR_OPEN);
		else if(typ.equalsIgnoreCase("door_y_closed"))
			return(DOOR_Y_CLOSED);
		else if(typ.equalsIgnoreCase("door_y_open"))
			return(DOOR_Y_OPEN);
		else if(typ.equalsIgnoreCase("table_empty"))
			return(TABLE_EMPTY);
		else if(typ.equalsIgnoreCase("table_key_up"))
			return(TABLE_KEY_UP);
		else if(typ.equalsIgnoreCase("table_key_down"))
			return(TABLE_KEY_DOWN);
		else if(typ.equalsIgnoreCase("table_key_left"))
			return(TABLE_KEY_LEFT);
		else if(typ.equalsIgnoreCase("table_key_right"))
			return(TABLE_KEY_RIGHT);
		else if(typ.equalsIgnoreCase("silly"))
			return(SILLY);
		else if(typ.equalsIgnoreCase("quizzer1"))
			return(QUIZZER1);
		else if(typ.equalsIgnoreCase("quizzer2"))
			return(QUIZZER2);
		else if(typ.equalsIgnoreCase("soldier1"))
			return(SOLDIER1);
		else if(typ.equalsIgnoreCase("soldier2"))
			return(SOLDIER2);
		else if(typ.equalsIgnoreCase("leader"))
			return(LEADER);
		else
			return(BLANK);
	}
	
	/**
	 * sets the type of a tile with its string format
	 * @param typ
	 */
	public void setType(String typ)
	{
		if(typ.equalsIgnoreCase(null))
			setType(BLANK);
		else if(typ.equalsIgnoreCase("water"))
			setType(WATER);
		else if(typ.equalsIgnoreCase("grass"))
			setType(GRASS);
		else if(typ.equalsIgnoreCase("dirt"))
			setType(DIRT);
		else if(typ.equalsIgnoreCase("sand"))
			setType(SAND);
		else if(typ.equalsIgnoreCase("rock"))
			setType(ROCK);
		else if(typ.equalsIgnoreCase("block"))
			setType(BLOCK);
		else if(typ.equalsIgnoreCase("grid"))
			setType(GRID);
		else if(typ.equalsIgnoreCase("cobble"))
			setType(COBBLE);
		else if(typ.equalsIgnoreCase("wood"))
			setType(WOOD);
		else if(typ.equalsIgnoreCase("wall_x"))
			setType(WALL_X);
		else if(typ.equalsIgnoreCase("wall_y"))
			setType(WALL_Y);
		else if(typ.equalsIgnoreCase("wall_nw"))
			setType(WALL_NW);
		else if(typ.equalsIgnoreCase("wall_ne"))
			setType(WALL_NE);
		else if(typ.equalsIgnoreCase("wall_sw"))
			setType(WALL_SW);
		else if(typ.equalsIgnoreCase("wall_se"))
			setType(WALL_SE);
		else if(typ.equalsIgnoreCase("wall_t"))
			setType(WALL_T);
		else if(typ.equalsIgnoreCase("door_closed"))
			setType(DOOR_CLOSED);
		else if(typ.equalsIgnoreCase("door_open"))
			setType(DOOR_OPEN);
		else if(typ.equalsIgnoreCase("door_y_closed"))
			setType(DOOR_Y_CLOSED);
		else if(typ.equalsIgnoreCase("door_y_open"))
			setType(DOOR_Y_OPEN);
		else if(typ.equalsIgnoreCase("table_empty"))
			setType(TABLE_EMPTY);
		else if(typ.equalsIgnoreCase("table_key_up"))
			setType(TABLE_KEY_UP);
		else if(typ.equalsIgnoreCase("table_key_down"))
			setType(TABLE_KEY_DOWN);
		else if(typ.equalsIgnoreCase("table_key_left"))
			setType(TABLE_KEY_LEFT);
		else if(typ.equalsIgnoreCase("table_key_right"))
			setType(TABLE_KEY_RIGHT);
		else if(typ.equalsIgnoreCase("silly"))
			setType(SILLY);
		else if(typ.equalsIgnoreCase("quizzer1"))
			setType(QUIZZER1);
		else if(typ.equalsIgnoreCase("quizzer2"))
			setType(QUIZZER2);
		else if(typ.equalsIgnoreCase("soldier1"))
			setType(SOLDIER1);
		else if(typ.equalsIgnoreCase("soldier2"))
			setType(SOLDIER2);
		else if(typ.equalsIgnoreCase("leader"))
			setType(LEADER);
		else
			setType(BLANK);
	}
	
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
	public static int getNumOfTiles()
	{
		return numOfTiles;
	}
	public String getLocation()
	{
		return xPosition + "," + yPosition;
	}
	
	/**
	 * returns the type of the tile in string format
	 * @return
	 */
	public String getTypeString()
	{
		if(type == BLANK)
			return null;
		else if(type == WATER)
			return "water";
		else if(type == GRASS)
			return "grass";
		else if(type == DIRT)
			return "dirt";
		else if(type == SAND)
			return "sand";
		else if(type == ROCK)
			return "rock";
		else if(type == BLOCK)
			return "block";
		else if(type == GRID)
			return "grid";
		else if(type == COBBLE)
			return "cobble";
		else if (type == WOOD)
			return "wood";
		else if(type == WALL_X)
			return "wall_x";
		else if(type == WALL_Y)
			return "wall_y";
		else if(type == WALL_NW)
			return "wall_nw";
		else if(type == WALL_NE)
			return "wall_ne";
		else if(type == WALL_SW)
			return "wall_sw";
		else if(type == WALL_SE)
			return "wall_se";
		else if(type == WALL_T)
			return "wall_t";
		else if(type == DOOR_CLOSED)
			return "door_closed";
		else if(type == DOOR_OPEN)
			return "door_open";
		else if(type == DOOR_Y_CLOSED)
			return "door_y_closed";
		else if(type == DOOR_Y_OPEN)
			return "door_y_open";
		else if(type == TABLE_EMPTY)
			return "table_empty";
		else if(type == TABLE_KEY_UP)
			return "table_key_up";
		else if(type == TABLE_KEY_DOWN)
			return "table_key_down";
		else if(type == TABLE_KEY_LEFT)
			return "table_key_left";
		else if(type == TABLE_KEY_RIGHT)
			return "table_key_right";
		else if(type == SILLY)
			return "silly";
		else if(type == QUIZZER1)
			return "quizzer1";
		else if(type == QUIZZER2)
			return "quizzer2";
		else if(type == SOLDIER1)
			return "soldier1";
		else if(type == SOLDIER2)
			return "soldier2";
		else if(type == LEADER)
			return "leader";
		else
			return null;
	}
	public ImageIcon getImageIcon()
	{
		return image;
	}
	public ImageIcon getMiniImage()
	{
		return miniImage;
	}
	public ImageIcon getMapImage()
	{
		return map;
	}
	public ImageIcon getMiniMapImage()
	{
		return miniMap;
	}
	
	/*
	 * Object specific methods
	 */
	public boolean isPassable()
	{
		if(type == BLANK)
			return false;
		else if(type == WATER)
			return false;
		else if(type == GRASS)
			return true;
		else if(type == DIRT)
			return true;
		else if(type == SAND)
			return true;
		else if(type == ROCK)
			return true;
		else if(type == BLOCK)
			return false;
		else if(type == GRID)
			return true;
		else if(type == COBBLE)
			return true;
		else if (type == WOOD)
			return true;
		else if(type == WALL_X)
			return false;
		else if(type == WALL_Y)
			return false;
		else if(type == WALL_NW)
			return false;
		else if(type == WALL_NE)
			return false;
		else if(type == WALL_SW)
			return false;
		else if(type == WALL_SE)
			return false;
		else if(type == WALL_SE)
			return false;
		else if(type == WALL_T)
			return false;
		else if(type == DOOR_CLOSED || type == DOOR_Y_CLOSED)
			return false;
		else if(type == DOOR_OPEN || type == DOOR_Y_OPEN)
			return true;
		else if(type == TABLE_EMPTY || type == TABLE_KEY_UP || type == TABLE_KEY_DOWN || type == TABLE_KEY_LEFT || type == TABLE_KEY_RIGHT )
			return false;
		else if(type == SILLY || type == QUIZZER1 || type == QUIZZER2 || type == SOLDIER1 || type == SOLDIER2 || type == LEADER)
			return false;
		else
			return false;
	}
	public boolean hasPlayer()
	{
		return hasPlayer;
	}
	public boolean isSameLocation(GameObject o)
	{
		return compareTo(o)==0;
	}
	public boolean isSameType(Tile t)
	{
		return t.getType() == getType();
	}
	public boolean equals(Tile t)
	{
		return isSameType(t) && isSameLocation((GameObject)t);
	}
	public String toString()
	{
		return "X= " + getXPosition() + "\nY= " + getYPosition() + "\nType =" + getTypeString();
	}
}
