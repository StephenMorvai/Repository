import javax.swing.*;

/**
 * Stores the images for the player and any information about the player
 * @author Stephen Morvai
 *
 */
public class Player extends Character
{
	private ImageIcon[] sprites;
	private ImageIcon sprite;
	final static int FRONT_STANDING = 0;
	final static int FRONT_WALKING_LEFT = 1;
	final static int FRONT_WALKING_RIGHT = 2;
	final static int BACK_STANDING = 3;
	final static int BACK_WALKING_LEFT = 4;
	final static int BACK_WALKING_RIGHT = 5;
	final static int LEFT_STANDING = 6;
	final static int LEFT_WALKING_LEFT = 7;
	final static int LEFT_WALKING_RIGHT = 8;
	final static int RIGHT_STANDING = 9;
	final static int RIGHT_WALKING_LEFT = 10;
	final static int RIGHT_WALKING_RIGHT = 11;
	
	String[] inventory;
	
	String faveColor;
	
	public Player(String nam, String col, int gen) 
	{
		super(0, 0, PLAYER, nam, gen);
		sprites = new ImageIcon[12];
		for(int i = 0; i < sprites.length; i++)
		{
			switch(i)
			{
				case FRONT_STANDING:
					sprites[i] = new ImageIcon("Library/Images/Sprites/Characters/Player/" + "FRONT_STANDING" + ".PNG");
					break;
				case FRONT_WALKING_LEFT:
					sprites[i] = new ImageIcon("Library/Images/Sprites/Characters/Player/" + "FRONT_WALKING_LEFT" + ".PNG");
					break;
				case FRONT_WALKING_RIGHT:
					sprites[i] = new ImageIcon("Library/Images/Sprites/Characters/Player/" + "FRONT_WALKING_RIGHT" + ".PNG");
					break;
				case BACK_STANDING:
					sprites[i] = new ImageIcon("Library/Images/Sprites/Characters/Player/" + "BACK_STANDING" + ".PNG");
					break;
				case BACK_WALKING_LEFT:
					sprites[i] = new ImageIcon("Library/Images/Sprites/Characters/Player/" + "BACK_WALKING_LEFT" + ".PNG");
					break;
				case BACK_WALKING_RIGHT:
					sprites[i] = new ImageIcon("Library/Images/Sprites/Characters/Player/" + "BACK_WALKING_RIGHT" + ".PNG");
					break;
				case LEFT_STANDING:
					sprites[i] = new ImageIcon("Library/Images/Sprites/Characters/Player/" + "LEFT_STANDING" + ".PNG");
					break;
				case LEFT_WALKING_LEFT:
					sprites[i] = new ImageIcon("Library/Images/Sprites/Characters/Player/" + "LEFT_WALKING_LEFT" + ".PNG");
					break;
				case LEFT_WALKING_RIGHT:
					sprites[i] = new ImageIcon("Library/Images/Sprites/Characters/Player/" + "LEFT_WALKING_RIGHT" + ".PNG");
					break;
				case RIGHT_STANDING:
					sprites[i] = new ImageIcon("Library/Images/Sprites/Characters/Player/" + "RIGHT_STANDING" + ".PNG");
					break;
				case RIGHT_WALKING_LEFT:
					sprites[i] = new ImageIcon("Library/Images/Sprites/Characters/Player/" + "RIGHT_WALKING_LEFT" + ".PNG");
					break;
				case RIGHT_WALKING_RIGHT:
					sprites[i] = new ImageIcon("Library/Images/Sprites/Characters/Player/" + "RIGHT_WALKING_RIGHT" + ".PNG");
					break;
			}
		}
		setSprite(FRONT_STANDING);
		inventory = new String[8];
		name = nam;
		faveColor = col;

	}
	public String getName()
	{
		return name;
	}
	public String getFaveColor()
	{
		return faveColor;
	}
	public void move(int direction)
	{
		Run.getGui().getGame().movePlayer(direction);
	}
	
	public void setSprite(int sp)
	{
		sprite = sprites[sp];
	}
	public ImageIcon getSprite()
	{
		return sprite;
	}
	public void setFaveColor(String col) 
	{
		faveColor = col;
	}

}
