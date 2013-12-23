import java.io.IOException;
import java.util.*;

import javax.swing.JOptionPane;


public class Game 
{
	final static int UP = 0;
	final static int DOWN = 1;
	final static int LEFT = 2;
	final static int RIGHT = 3;
	
	
	int worldX;
	int worldY;

	int playerX;
	int playerY;
	
	private Tile[][] tiles;
	private int[][] types;
	
	String saveFile;
	
	Player player;
	
	
	
	//Game progression booleans
	//level 1
	boolean hasRedKey = false;
	boolean hasTalkedToSilly = false;
	boolean hasGreenKey = false;
	boolean hasBridge = false;
	boolean hasShovel = false;
	boolean hasBlueKey = false;
	boolean hasEnteredCastle = false;
	final static int ITEMS = 5;
	int level = 1;
	/**
	 * Creates new Game
	 */
	public Game()
	{
		String nam = JOptionPane.showInputDialog(Run.getGui().getRootPane(), "Enter your name", "Name", JOptionPane.QUESTION_MESSAGE);
		String col = JOptionPane.showInputDialog(Run.getGui().getRootPane(), "Enter your favorite color", "Favourite color", JOptionPane.QUESTION_MESSAGE);
		player = new Player(nam, col, Player.MALE);
		try 
		{
			createTypes("Levels/Level1", false);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		createTiles();
		playerX = 6;
		playerY = 8;
		Run.getGui().setGameLoaded(true);
	}
	/**
	 * Loads old Game (unused since it did not work)
	 * @param save name of saved game file
	 */
	public Game(String save)
	{
		try
		{
			try 
			{
				createTypes(save + "map", true);
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
			createTiles();
			IO.openInputFile(save + "game.txt");
			playerX = Integer.parseInt(IO.readLine());
			playerY = Integer.parseInt(IO.readLine());
			player = new Player(IO.readLine(),IO.readLine(), Player.MALE);
			for(int i = 0; i < 5; i++)
			{
				String line = IO.readLine();
				switch (i)
				{
				case(0): 
					if(line.equalsIgnoreCase("true"))
					{
						hasRedKey = true;
						Run.getGui().inventoryArea.append("\nRed Key");
						Run.getGui().itemArea.append("\nRed Key");
						Run.getGui().addToItems();
					}
					break;
				case(1): 
					if(line.equalsIgnoreCase("true"))
					{
						hasGreenKey = true;
						Run.getGui().inventoryArea.append("\nGreen Key");
						Run.getGui().itemArea.append("\nGreen Key");
						Run.getGui().addToItems();
					}
					break;
				case(2): 
					if(line.equalsIgnoreCase("true"))
					{
						hasBlueKey = true;
						Run.getGui().inventoryArea.append("\nBlue Key");
						Run.getGui().itemArea.append("\nBlue Key");
						Run.getGui().addToItems();
					}
					break;
				case(3): 
					if(line.equalsIgnoreCase("true"))
					{
						hasBridge = true;
						Run.getGui().inventoryArea.append("\nBridge");
						Run.getGui().itemArea.append("\nBridge");
						Run.getGui().addToItems();
					}
					break;
				case(4): 
					if(line.equalsIgnoreCase("true"))
					{
						hasShovel = true;
						Run.getGui().inventoryArea.append("\nShovel");
						Run.getGui().itemArea.append("\nShovel");
						Run.getGui().addToItems();
					}
					break;
				}
				level = Integer.parseInt(IO.readLine());
				IO.closeInputFile();
			}
		}
		catch(NumberFormatException e)
		{
			JOptionPane.showMessageDialog(Run.getGui().getRootPane(), "Save file has been corrupted", "Corrupted Save File", JOptionPane.ERROR_MESSAGE);
		}
		Run.getGui().setGameLoaded(true);
	}
	public void saveGame(String file)
	{
		IO.createOutputFile("Library/Maps/" + file + "map.txt");
		IO.println(worldX + "," + worldY);
		for(int i = 0; i < worldY; i++)
		{
			for(int j = 0; j < worldX; j++)
			{
				IO.print(tiles[j][i].getTypeString() + " ");
			}//end for
			IO.println("");
		}//end for
		IO.closeOutputFile();
		IO.createOutputFile(file + "game.txt");
		IO.println(playerX + "");
		IO.println(playerY + "");
		IO.println(player.getName());
		IO.println(player.getFaveColor());
		IO.println(hasRedKey + "");
		IO.println(hasGreenKey + "");
		IO.println(hasBlueKey + "");
		IO.println(hasBridge+ "");
		IO.println(hasShovel + "");
		IO.println(level + "");
		IO.closeOutputFile();
	}
	
	public int[][] getTypes()
	{
		return types;
	}
	public Tile[][] getTiles()
	{
		return tiles;
	}
	public void setWorldX(int x)
	{
		worldX = x;
	}
	public int getWorldX()
	{
		return worldX;
	}
	public void setWorldY(int y)
	{
		worldY = y;
	}
	public int getWorldY()
	{
		return worldY;
	}
	
	/**
	 * This is the first way of creating the tiles on the map. This one uses a text file with the 
	 * types in a 1D sequence on different lines.
	 * Like this:
	 * 8
	 * GRASS
	 * GRASS
	 * 2
	 * WOOD
	 * DIRT
	 * new
	 * 
	 * The number refer to the number of blank spaces, 
	 * and the next row is filled out when new is reached.
	 * This is used to create level 1
	 * 
	 * String manipulation occurs to turn the first line (X,Y) into the size of the 2D array.
	 * @param mapFile
	 * @throws IOException
	 */
	
	public void createTypes(String mapFile) throws IOException
	{
		IO.openInputFile("Library/Maps/" + mapFile + ".txt");
		String size = IO.readLine();
		setWorldX(Integer.parseInt(size.substring(0,size.indexOf(','))));
		setWorldY(Integer.parseInt(size.substring(size.indexOf(',')+1)));
		types = new int[worldX][worldY];
		String[] names = new String [worldX*worldY + 2*worldY];
		int row = 0;
		int column = 0;
		int a = 0;
		while((names[a]=IO.readLine()) != null) 
		{
			try
			{
				int c = Integer.parseInt(names[a]);
				for(int b = 0; b < c; b++)
				{
					types[column][row] = Tile.BLANK;
					column++;
				}
			}
			catch(NumberFormatException e)
			{
				if(names[a].equalsIgnoreCase("new"))
				{
				row++;
				column = 0;
			}
			else if (!names[a].equals(null))
			{
				types[column][row] = Tile.convertType(names[a]);
				column++;
			}
		}
		a++;
		}//end while
	}//end createTypes 
	/**
	 * uses the types from the text file to create the tiles.
	 */
	public void createTiles()
	{
		tiles = new Tile[worldX][worldY];
		for(int i = 0; i < tiles.length; i++)
		{
			for(int j = 0; j < tiles[i].length; j++)
			{
				tiles[i][j] = new Tile(i,j,types[i][j]);
			}//end for
		}//end for
	}
	
	/**
	 * The alternative method of creating types that uses a 2D system.
	 * 
	 * GRASS BLANK GRASS WOOD
	 * WOOD  DIRT  WATER WALL_X
	 * 
	 * The program uses the methods found in the Tools class to identify the word in a line, 
	 * and then remove it before moving on to the next word.
	 * 
	 * This method is used for level 2
	 * @param mapFile
	 * @param d Boolean. If true it uses this, if false it uses the other method.
	 * @throws IOException
	 */
	public void createTypes(String mapFile, boolean d) throws IOException
	{
		if(d)
		{
			IO.openInputFile("Library/Maps/" + mapFile + ".txt");
			String size = IO.readLine();
			setWorldX(Integer.parseInt(size.substring(0,size.indexOf(','))));
			setWorldY(Integer.parseInt(size.substring(size.indexOf(',')+1)));
			types = new int[worldX][worldY];
			String[]lines= new String[worldY];
			for(int i = 0; i < worldY; i++)
			{
				lines[i] = IO.readLine();
				for(int j = 0; j < worldX; j++)
				{
					if(!(Tools.findWord(lines[i]).equals(null)))
					{
						types[j][i] = Tile.convertType(Tools.findWord(lines[i]));
						lines[i] = Tools.deleteWord(lines[i]);
					}
					else
					{
						types[j][i] = Tile.BLANK;
					}
				}
			}
		}
		else
		{
			createTypes(mapFile);
		}
	}//end createTypes 
	
	
	int countUp = -1;
	int countDown = 1;
	int countLeft = -1;
	int countRight = -1;
	/**
	 * Moves the player. Animates the walking by counting how many steps how been
	 * in that direction. The counter resets when the animation is complete. 
	 * When the player is not facing the direction the count is set to -1
	 * @param direction
	 */
	public void movePlayer(int direction)
	{
		Run.getGui().showGameScreen(false);
		try
		{
			if(direction == Game.UP)
			{
				boolean shouldMove = true;
				switch(countUp)
				{
					case 0:
						player.setSprite(Player.BACK_STANDING);
						countUp++;
						break;
					case 1:
						player.setSprite(Player.BACK_WALKING_LEFT);
						countUp++;
						break;
					case 2:
						player.setSprite(Player.BACK_STANDING);
						countUp++;
						break;
					case 3:
						player.setSprite(Player.BACK_WALKING_RIGHT);
						countUp = 0;
						break;
					default: // == -1
						player.setSprite(Player.BACK_STANDING);
						countUp = 1;
						shouldMove = false;
						countDown = -1;
						countLeft = -1;
						countRight = -1;
						break;
				}
				if(tiles[playerX][playerY - 1].isPassable()  && shouldMove)
				{
					playerY--;
				}
				else if (!tiles[playerX][playerY - 1].isPassable() && shouldMove)
				{
					Run.getGui().dialogArea.append("\nYou cannot go that way.");
				}
			}
			else if(direction == Game.DOWN)
			{
				boolean shouldMove = true;
				switch(countDown)
				{
					case 0:
						player.setSprite(Player.FRONT_STANDING);
						countDown++;
						break;
					case 1:
						player.setSprite(Player.FRONT_WALKING_LEFT);
						countDown++;
						break;
					case 2:
						player.setSprite(Player.FRONT_STANDING);
						countDown++;
						break;
					case 3:
						player.setSprite(Player.FRONT_WALKING_RIGHT);
						countDown = 0;
						break;
					default: // == -1
						player.setSprite(Player.FRONT_STANDING);
						countDown = 1;
						shouldMove = false;
						countUp = -1;
						countLeft = -1;
						countRight = -1;
						break;
				}
				if(tiles[playerX][playerY + 1].isPassable() && shouldMove)
				{
					playerY++;
				}
				else if (!tiles[playerX][playerY + 1].isPassable() && shouldMove)
				{
					Run.getGui().dialogArea.append("\nYou cannot go that way.");
				}
			}
			else if(direction == Game.LEFT)
			{
				boolean shouldMove = true;
				switch(countLeft)
				{
					case 0:
						player.setSprite(Player.LEFT_STANDING);
						countLeft++;
						break;
					case 1:
						player.setSprite(Player.LEFT_WALKING_LEFT);
						countLeft++;
						break;
					case 2:
						player.setSprite(Player.LEFT_STANDING);
						countLeft++;
						break;
					case 3:
						player.setSprite(Player.LEFT_WALKING_RIGHT);
						countLeft = 0;
						break;
					default: // == -1
						player.setSprite(Player.LEFT_STANDING);
						countLeft = 1;
						shouldMove = false;
						countUp = -1;
						countDown = -1;
						countRight = -1;
						break;
				}
				if(tiles[playerX - 1][playerY].isPassable() && shouldMove)
				{
					playerX--;
				}
				else if (!tiles[playerX - 1][playerY].isPassable() && shouldMove)
				{
					Run.getGui().dialogArea.append("\nYou cannot go that way.");
				}
			}
			else if(direction == Game.RIGHT)
			{
				boolean shouldMove = true;
				switch(countRight)
				{
					case 0:
						player.setSprite(Player.RIGHT_STANDING);
						countRight++;
						break;
					case 1:
						player.setSprite(Player.RIGHT_WALKING_LEFT);
						countRight++;
						break;
					case 2:
						player.setSprite(Player.RIGHT_STANDING);
						countRight++;
						break;
					case 3:
						player.setSprite(Player.RIGHT_WALKING_RIGHT);
						countRight = 0;
						break;
					default: // == -1
						player.setSprite(Player.RIGHT_STANDING);
						countRight = 1;
						shouldMove = false;
						countUp = -1;
						countDown = -1;
						countLeft = -1;
						break;
				}
				if(tiles[playerX + 1][(int)playerY].isPassable() && shouldMove)
				{
					playerX++;
				}
				else if (!tiles[playerX + 1][playerY].isPassable() && shouldMove)
				{
					Run.getGui().dialogArea.append("\nYou cannot go that way.");
				}
			}
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			JOptionPane.showMessageDialog(Run.getGui().getRootPane(), "Cannot access out of bounds location", "Out of Bounds", JOptionPane.ERROR_MESSAGE);
		}
		Run.getGui().showGameScreen(true);
		System.out.println(playerX);
		System.out.println(playerY);
	}
	/**
	 * Changes the level
	 */
	public void goToNextLevel()
	{
		level++;
		Run.getGui().showGameScreen(false);
		playerX = 4;
		playerY = 1;
		try 
		{
			createTypes("Levels/Level2", true);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		createTiles();
		Run.getGui().createTerrains();
		Run.getGui().showGameScreen(true);
	}
	
	/**
	 * Unused
	 * @param time
	 */
	public void wait(int time)
	{
		try 
		{
			Thread.sleep(time);
		} 
		catch 
		(InterruptedException e) 
		{
			e.printStackTrace();
		}
	}
}
