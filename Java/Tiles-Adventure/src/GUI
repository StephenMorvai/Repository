import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/**
 * This class creates the GUI and deals with the action events. 
 * It Calls upon the other class when needed, and creates the instance fo the game.
 * @author Stephen Morvai
 *
 */
public class GUI extends JFrame implements ActionListener, KeyListener
{
/*
 * Menu Bar
 */
JMenuBar menuBar;
JMenu fileMenu, viewMenu, infoMenu, helpMenu;//menuBar
JMenuItem newItem,loadItem,saveItem,saveAsItem,quitItem;//fileMenu
JMenuItem gameItem,statsItem,inventoryItem,mapItem;//viewMenu
JMenuItem highscoreItem,versionItem,creditsItem;//infoMenu
JMenuItem helpItem;//helpMenu
/*
 * welcome screen
 */
JLabel welcomeTitle;
JLabel[] welcomeText;
/*
 * Game Screen
 */

JLabel[][]terrains;
JLabel playerSprite;
JLabel miniMap;
/*
 * Stats Screen
 */
JLabel statsTitle;
JLabel playerLevel;
JLabel stepsTaken;
JLabel totalTiles;
/*
 * Inventory screen
 * Scrollpane 
 * Text Area
 */
JLabel inventoryTitle;
JScrollPane inventoryPane;
JTextArea inventoryArea;
/*
 * Map Screen
 */
JLabel map;

/*
 * Highscore screen
 */
JLabel	yourScore, highScore, highscoreTitle;
/*
 * Version screen
 */
JLabel versionNumber;
private static String version = "0.1.0";
private static String stage = "Beta";
/*
 * Credits screen
 */
JLabel[] credits;
/*
 * Help Screen
 */
JLabel helpTitle;
JLabel instructions;
/*
 * Action Buttons
 * Scroll panes
 * ComboBox
 * TextAreas
 */
JButton lButton, rButton, upButton,downButton,leftButton,rightButton,aButton,bButton,startButton,selectButton,useItemButton,mapButton,levelButton;
JComboBox selectedItemBox;
JTextArea itemArea,dialogArea;
JScrollPane itemPane, dialogPane;
/*
 * Start Menu Buttons
 * when the star button is pressed. The game "pauses" and these buttons are present
 */
JButton newButton,loadButton,saveButton,saveAsButton,highscoreButton,versionButton,creditButton,quitButton, xButton;


final static int RES_X = 800;
final static int RES_Y = 600;

final static int DISPLAY_X = 640;
final static int DISPLAY_Y = 480;

final static int MENU_HEIGHT = 32;
final static int TILE_LENGTH = 32;

final static int BLANK = 0;
final static int WELCOME = 1;
final static int GAME = 2;
final static int STATS = 3;
final static int INVENTORY = 4;
final static int MAP = 5;
final static int HIGHSCORE = 6;
final static int VERSION = 7;
final static int CREDITS = 8;
final static int HELP = 9;

private int screen;
Container c = getContentPane(); 
private Game game;
private boolean gameLoaded = false;

	/**
	 * Constructs the gui. Only constructs the menu bar and welcome screen.
	 * The rest are constructed when a game is made.
	 */
	public GUI()
	{
		super("Tiles Adventure " + stage + " " + version);
		setDefaultCloseOperation(EXIT_ON_CLOSE); 
		setSize(RES_X,RES_Y + 32 + MENU_HEIGHT); 
		setResizable(false);
		
		c.setBackground(Tools.WHITE); //The default color was appropriate
		c.setLayout(null);
		
		addKeyListener(this);
		
		createMenuBar();
		createWelcomeScreen();
		
		/***************************/
		setVisible(true);
	}
	/**
	 * 
	 * @return the game that is running
	 */
	public Game getGame()
	{
		return game;
	}
	/**
	 * sets the game that everythign is running on
	 * @param gam
	 */
	public void setGame(Game gam)
	{
		game = gam;
	}
	/**
	 * stores whether or not a game is running
	 * @param b
	 */
	public void setGameLoaded(boolean b)
	{
		gameLoaded = b;
	}
	/**
	 * gets whether or not the game is loaded
	 * @return
	 */
	public boolean isGameLoaded()
	{
		return gameLoaded;
	}
	
	/**
	 * Hides all the screens to clean up.
	 * Most of the time the one screen that is needed is reshown.
	 */
	public void hideAll()
	{
		showWelcomeScreen(false);
		showGameScreen(false);
		showStatsScreen(false);
		showInventoryScreen(false);
		showMapScreen(false);
		showHighscoreScreen(false);
		showVersionScreen(false);
		showCreditsScreen(false);
		showHelpScreen(false);
		showActionButtons(false);
		showMenuButtons(false);
	}
	/**
	 * Hides just the screens.
	 * Is used by the menu buttons as having objects 
	 * underneath the buttons caused graphical issues.
	 */
	public void hideScreens()
	{
		showWelcomeScreen(false);
		showGameScreen(false);
		showStatsScreen(false);
		showInventoryScreen(false);
		showMapScreen(false);
		showHighscoreScreen(false);
		showVersionScreen(false);
		showCreditsScreen(false);
		showHelpScreen(false);
	}
	/**
	 * Makes the welcome screen visible or not based upon a boolean.
	 * @param b
	 */
	public void showWelcomeScreen(boolean b)
	{
		welcomeTitle.setVisible(b);
		for(int i = 0; i < welcomeText.length; i++)
		{
			welcomeText[i].setVisible(b);
		}
	}
	/**
	 * Shows or hides game screen. Also places down the terrains, 
	 * and hides the one that are outside the game area
	 * @param b
	 */
	public void showGameScreen(boolean b)
	{
		playerSprite.setIcon(game.player.getSprite());
		playerSprite.setVisible(b);
		miniMap.setVisible(b);
		if(b)
		{
			placeTerrains();
		}
		for(int i = 0; i < game.getTiles().length; i++)
		{
			for(int j = 0; j < game.getTiles()[i].length; j++)
			{
				terrains[i][j].setVisible(b);
			}
		}
		if(b)
		{
			hideExtraTerrains();
		}
	}
	/**
	 * visibility of Stats Screen
	 * @param b
	 */
	public void showStatsScreen(boolean b)
	{
		statsTitle.setVisible(b);
		playerLevel.setVisible(b);
		stepsTaken.setVisible(b);
		totalTiles.setVisible(b);
	}
	public void showInventoryScreen(boolean b)
	{
		inventoryTitle.setVisible(b);
		inventoryPane.setVisible(b);
	}
	public void showMapScreen(boolean b)
	{
		map.setVisible(b);
	}
	public void showHighscoreScreen(boolean b)
	{
		highscoreTitle.setVisible(b);
		highScore.setVisible(b);
		yourScore.setVisible(b);
	}
	public void showVersionScreen(boolean b)
	{
		versionNumber.setVisible(b);
	}
	public void showCreditsScreen(boolean b)
	{
		for(int i = 0; i < credits.length; i++)
		{
			credits[i].setVisible(b);
		}
	}
	public void showHelpScreen(boolean b)
	{
		helpTitle.setVisible(b);
		instructions.setVisible(b);
	}
	public void showActionButtons(boolean b)
	{
		lButton.setVisible(b);
		rButton.setVisible(b);
		upButton.setVisible(b);
		downButton.setVisible(b);
		leftButton.setVisible(b);
		rightButton.setVisible(b);
		aButton.setVisible(b);
		bButton.setVisible(b);
		startButton.setVisible(b);
		selectButton.setVisible(b);
		useItemButton.setVisible(b);
		levelButton.setVisible(b);
		mapButton.setVisible(b);
		selectedItemBox.setVisible(b);
		itemPane.setVisible(b);
		dialogPane.setVisible(b);
	}
	
	public void enableActionButtons(boolean b)
	{
		lButton.setEnabled(b);
		rButton.setEnabled(b);
		upButton.setEnabled(b);
		downButton.setEnabled(b);
		leftButton.setEnabled(b);
		rightButton.setEnabled(b);
		aButton.setEnabled(b);
		bButton.setEnabled(b);
		startButton.setEnabled(b);
		selectButton.setEnabled(b);
		useItemButton.setEnabled(b);
		levelButton.setEnabled(b);
		mapButton.setEnabled(b);
		selectedItemBox.setEnabled(b);
	}
	public void showMenuButtons(boolean b)
	{
		enableActionButtons(!b);
		newButton.setVisible(b);
		loadButton.setVisible(b);
		saveButton.setVisible(b);
		saveAsButton.setVisible(b);
		highscoreButton.setVisible(b);
		versionButton.setVisible(b);
		creditButton.setVisible(b);
		quitButton.setVisible(b);
		xButton.setVisible(b);
	}
	/**
	 * These methods create the parts of the gui and the different screens
	 */
	public void createMenuBar()
	{
		/*
		 * Menu Bar
		 */
		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, getWidth(), MENU_HEIGHT);
		c.add(menuBar);
		
		fileMenu = new JMenu("File");
		fileMenu.setMnemonic('f');
			newItem = new JMenuItem("New");
			newItem.setMnemonic('n');
			newItem.addActionListener(this);
			fileMenu.add(newItem);
			loadItem = new JMenuItem("Load");
			loadItem.setMnemonic('l');
			loadItem.addActionListener(this);
			fileMenu.add(loadItem);
			fileMenu.addSeparator();
			saveItem = new JMenuItem("Save");
			saveItem.setMnemonic('s');
			saveItem.addActionListener(this);
			fileMenu.add(saveItem);
			saveAsItem = new JMenuItem("Save as");
			saveAsItem.setMnemonic('a');
			saveAsItem.addActionListener(this);
			fileMenu.add(saveAsItem);
			fileMenu.addSeparator();
			quitItem = new JMenuItem("Quit");
			quitItem.setMnemonic('q');
			quitItem.addActionListener(this);
			fileMenu.add(quitItem);
		menuBar.add(fileMenu);
		
		viewMenu = new JMenu("View");
		viewMenu.setMnemonic('v');
			gameItem = new JMenuItem("Game");
			gameItem.setMnemonic('g');
			gameItem.addActionListener(this);
			viewMenu.add(gameItem);
			statsItem = new JMenuItem("Stats");
			statsItem.setMnemonic('s');
			statsItem.addActionListener(this);
			viewMenu.add(statsItem);
			inventoryItem = new JMenuItem("Inventory");
			inventoryItem.setMnemonic('i');
			inventoryItem.addActionListener(this);
			viewMenu.add(inventoryItem);
			mapItem = new JMenuItem("Map");
			mapItem.setMnemonic('m');
			mapItem.addActionListener(this);
			viewMenu.add(mapItem);
		menuBar.add(viewMenu);
		
		infoMenu = new JMenu("Info");
		infoMenu.setMnemonic('i');
			highscoreItem = new JMenuItem("Highscore");
			highscoreItem.setMnemonic('h');
			highscoreItem.addActionListener(this);
			infoMenu.add(highscoreItem);
			versionItem = new JMenuItem("Version");
			versionItem.setMnemonic('v');
			versionItem.addActionListener(this);
			infoMenu.add(versionItem);
			creditsItem = new JMenuItem("Credits");
			creditsItem.setMnemonic('c');
			creditsItem.addActionListener(this);
			infoMenu.add(creditsItem);
		menuBar.add(infoMenu);
		
		helpMenu = new JMenu("Help");
		helpMenu.setMnemonic('h');
			helpItem = new JMenuItem("Help");
			helpItem.setMnemonic('h');
			helpItem.addActionListener(this);
			helpMenu.add(helpItem);
		menuBar.add(helpMenu);
	}
	public void createWelcomeScreen()
	{
		/*
		 * Welcome Screen
		 */
		
		welcomeTitle = new JLabel("Tiles Adventure");
		welcomeTitle.setBounds((RES_X/2) - 177, 100, 334, 48);
		welcomeTitle.setFont(new Font("Arial",Font.ITALIC,48));
		c.add(welcomeTitle);
		
		welcomeText = new JLabel[8];
		for(int i = 0; i < welcomeText.length; i++)
		{
			welcomeText[i]= new JLabel();
			welcomeText[i].setBounds(welcomeTitle.getX(), i*18 + welcomeTitle.getY() + welcomeTitle.getHeight(), 300, 18);
			welcomeText[i].setFont(new Font("Arial",Font.PLAIN,18));
			switch (i)
			{
				case 1:
					welcomeText[i].setText("To start new game");
					break;
				case 2:
					welcomeText[i].setText("click file menu and select \"new\"");
					break;
				case 3:
					welcomeText[i].setText("and your adventure begins.");
					break;
				case 5:
					welcomeText[i].setText("To load a previous game");
					break;
				case 6:
					welcomeText[i].setText("click file menu and select \"load\"");
					break;
				case 7:
					welcomeText[i].setText("and your adventure continues.");
					break;
			}//end switch
			c.add(welcomeText[i]);
		}//end for
	}//end createWelcome Screen
	public void createGameScreen()
	{
		/*
		 * Game Screen
		 */
		playerSprite = new JLabel();
		playerSprite.setBounds(DISPLAY_X/2, DISPLAY_Y/2 - 16 + MENU_HEIGHT, 32,32);
		c.add(playerSprite);
		createTerrains();
		miniMap = new JLabel(new ImageIcon("Library/Images/Icons/Minimaps/miniMap.PNG"));
		miniMap.setBounds(DISPLAY_X + 32, DISPLAY_Y + MENU_HEIGHT, 96, 120);
		c.add(miniMap);
	}
	public void createStatsScreen()
	{
		statsTitle = new JLabel("Statistics");
		statsTitle.setFont(new Font("Arial", Font.BOLD, 24));
		statsTitle.setBounds(DISPLAY_X/2 - 64, 24 + MENU_HEIGHT, 128, 32);
		c.add(statsTitle);
		playerLevel = new JLabel("Level: " + "player.getLevel()");
		playerLevel.setFont(new Font("Arial", Font.BOLD, 18));
		playerLevel.setBounds(DISPLAY_X/4 - 128, 64 + MENU_HEIGHT, 256, 32);
		c.add(playerLevel);
		stepsTaken = new JLabel("Steps: " + "player.getNumOfSteps()");
		stepsTaken.setFont(new Font("Arial", Font.BOLD, 18));
		stepsTaken.setBounds(DISPLAY_X/4 - 128, 128 + MENU_HEIGHT, 256, 32);
		c.add(stepsTaken);
		totalTiles = new JLabel("World Size: " + Tile.getNumOfTiles());
		totalTiles.setFont(new Font("Arial", Font.BOLD, 18));
		totalTiles.setBounds(DISPLAY_X/4 - 128, 192 + MENU_HEIGHT, 256, 32);
		c.add(totalTiles);
	}
	public void createInventoryScreen()
	{
		/*
		 * Inventory Screen
		 */
		inventoryTitle = new JLabel("Inventory");
		inventoryTitle.setFont(new Font("Arial", Font.BOLD, 24));
		inventoryTitle.setBounds(DISPLAY_X/2 - 64, MENU_HEIGHT, 128, 32);
		c.add(inventoryTitle);
		inventoryArea = new JTextArea();
		inventoryArea.setEditable(false);
		inventoryArea.setLineWrap(true);
		inventoryArea.setWrapStyleWord(true);
		inventoryPane = new JScrollPane(inventoryArea);
		inventoryPane.setBounds(DISPLAY_X/2 - 128, 32 + MENU_HEIGHT, 256, DISPLAY_Y - 64);
		c.add(inventoryPane);
	}
	public void createMapScreen()
	{
		map = new JLabel(new ImageIcon("Library/Images/Icons/Minimaps/LargeMap.PNG"));
		map.setBounds((DISPLAY_X/2) - 300, MENU_HEIGHT, 600, 480);
		c.add(map);
	}
	public void createHighscoreScreen()
	{
		highscoreTitle = new JLabel("Highscores");
		highscoreTitle.setFont(new Font("Arial", Font.BOLD, 24));
		highscoreTitle.setBounds(DISPLAY_X/2 - 80, 32 + MENU_HEIGHT, 160, 32);
		c.add(highscoreTitle);
		highScore = new JLabel("There is no score as of version " + version );
		highScore.setFont(new Font("Arial", Font.BOLD, 18));
		highScore.setBounds(DISPLAY_X/2 - 160, 96 + MENU_HEIGHT, 320, 32);
		c.add(highScore);
		yourScore = new JLabel("Score = " +"0");
		yourScore.setFont(new Font("Arial", Font.BOLD, 18));
		yourScore.setBounds(DISPLAY_X/2 - 64, 160 + MENU_HEIGHT, 128, 32);
		c.add(yourScore);
	}
	public void createVersionScreen()
	{
		/*
		 * Version Screen
		 */
		versionNumber = new JLabel("Version " + version);
		versionNumber.setFont(new Font("Arial", Font.BOLD, 24));
		versionNumber.setBounds(DISPLAY_X/2 - 96, DISPLAY_Y/2 - 16 + MENU_HEIGHT, 192, 32);
		c.add(versionNumber);
	}
	public void createCreditsScreen()
	{
		/*
		 * Credits Screen
		 */
		credits = new JLabel[5];
		for(int i = 0; i < credits.length; i++)
		{
			credits[i]= new JLabel();
			credits[i].setBounds(DISPLAY_X/2 - 128, DISPLAY_Y/2 - 80 + 32*i, 512, 32);
			credits[i].setFont(new Font("Arial",Font.PLAIN,16));
			switch (i)
			{
				case 0:
					credits[i].setText("Credits:");
					break;
				case 1:
					credits[i].setText("Design: Stephen Morvai");
					break;
				case 2:
					credits[i].setText("Code: Stephen Morvai");
					break;
				case 3:
					credits[i].setText("Graphics: Stephen Morvai (Terrain pixels from minecraft)");
					break;
				case 4:
					credits[i].setText("Made for Ms.Cianci's grade 11 programming course");
					break;
			}
			c.add(credits[i]);
		}//end for
	}
	public void createHelpScreen()
	{
		helpTitle = new JLabel("Help");
		helpTitle.setFont(new Font("Arial", Font.BOLD, 24));
		helpTitle.setBounds(DISPLAY_X/2 - 32, 16 + MENU_HEIGHT, 64, 32);
		c.add(helpTitle);
		instructions = new JLabel("Instructions: L & R buttons switch screens. Arrows to move. Press R to go to game");
		instructions.setFont(new Font("Arial", Font.PLAIN, 12));
		instructions.setBounds(DISPLAY_X/2 - 256, 64 + MENU_HEIGHT, 512, 32);
		c.add(instructions);
	}
	public void createActionButtons()
	{
		/*
		 * Action Buttons
		 */
		lButton = new JButton("L");
		lButton.setBounds(DISPLAY_X, MENU_HEIGHT, 64, 24);
		lButton.addActionListener(this);
		c.add(lButton);
		rButton = new JButton("R");
		rButton.setBounds(RES_X - 64, MENU_HEIGHT, 64, 24);
		rButton.addActionListener(this);
		c.add(rButton);
		upButton = new JButton(new ImageIcon("Library/Images/Icons/upArrow.PNG"));
		upButton.setBounds(RES_X -((RES_X - DISPLAY_X)/2) - 24, 96 + MENU_HEIGHT, 48, 48);
		upButton.addActionListener(this);
		c.add(upButton);
		downButton = new JButton(new ImageIcon("Library/Images/Icons/downArrow.PNG"));
		downButton.setBounds(RES_X -((RES_X - DISPLAY_X)/2) - 24, 192 + MENU_HEIGHT, 48, 48);
		downButton.addActionListener(this);
		c.add(downButton);
		leftButton = new JButton(new ImageIcon("Library/Images/Icons/leftArrow.PNG"));
		leftButton.setBounds(RES_X -((RES_X - DISPLAY_X)/2) - 72, 144 + MENU_HEIGHT, 48, 48);
		leftButton.addActionListener(this);
		c.add(leftButton);
		rightButton = new JButton(new ImageIcon("Library/Images/Icons/rightArrow.PNG"));
		rightButton.setBounds(RES_X -((RES_X - DISPLAY_X)/2) + 24, 144 + MENU_HEIGHT, 48, 48);
		rightButton.addActionListener(this);
		c.add(rightButton);
		aButton = new JButton("A");
		aButton.setBounds(RES_X -((RES_X - DISPLAY_X)/2) - 60, DISPLAY_Y - 24 - 48 - 120 + MENU_HEIGHT, 48, 48);
		aButton.addActionListener(this);
		c.add(aButton);
		bButton = new JButton("B");
		bButton.setBounds(RES_X -((RES_X - DISPLAY_X)/2) + 12, DISPLAY_Y - 24 - 48 - 120 + MENU_HEIGHT, 48, 48);
		bButton.addActionListener(this);
		c.add(bButton);
		startButton = new JButton("Start");
		startButton.setBounds(DISPLAY_X, DISPLAY_Y - 24 - 72 + MENU_HEIGHT, 64, 24);
		startButton.addActionListener(this);
		c.add(startButton);
		selectButton = new JButton("Sel");
		selectButton.setBounds(RES_X - 64, DISPLAY_Y - 24 - 72 + MENU_HEIGHT, 64, 24);
		selectButton.addActionListener(this);
		c.add(selectButton);
		useItemButton = new JButton("Use Item");
		useItemButton.setBounds(4, RES_Y - 28 + MENU_HEIGHT, 256, 24);
		useItemButton.addActionListener(this);
		c.add(useItemButton);
		levelButton = new JButton("Level: 1");
		levelButton.setBounds(4+256+12, DISPLAY_Y + 4 + MENU_HEIGHT, 128, 24);
		levelButton.addActionListener(this);
		c.add(levelButton);
		mapButton = new JButton("Map");
		mapButton.setBounds(DISPLAY_X, DISPLAY_Y - 24 + MENU_HEIGHT, RES_X - DISPLAY_X, 24);
		mapButton.addActionListener(this);
		c.add(mapButton);
		
		String[]def = {"Selected Item"};
		selectedItemBox = new JComboBox(def);
		selectedItemBox.setBounds(4, RES_Y - 56 + MENU_HEIGHT, 256, 24);
		c.add(selectedItemBox);
		
		itemArea = new JTextArea("Items:");
		itemArea.setEditable(false);
		itemArea.setLineWrap(true);
		itemArea.setWrapStyleWord(true);
		itemPane = new JScrollPane(itemArea);
		itemPane.setBounds(4, DISPLAY_Y + 4 + MENU_HEIGHT, 256, 56);
		c.add(itemPane);
		
		dialogArea = new JTextArea("Welcome to Tiles Adventure! ");
		dialogArea.setEditable(false);
		dialogArea.setLineWrap(true);
		dialogArea.setWrapStyleWord(true);
		dialogPane = new JScrollPane(dialogArea);
		dialogPane.setBounds(4+256+12, DISPLAY_Y + 32 + MENU_HEIGHT, 364, 84);
		c.add(dialogPane);
	}
	public void createMenuButtons()
	{
		/*
		 * Start Menu
		 */
		int gh = 0;
		newButton = new JButton("New");
		newButton.setBounds(DISPLAY_X/2 - 64, 64 + 48*gh + MENU_HEIGHT, 128, 32);
		newButton.addActionListener(this);
		c.add(newButton);
		gh++;
		loadButton = new JButton("Load");
		loadButton.setBounds(DISPLAY_X/2 - 64, 64 + 48*gh + MENU_HEIGHT, 128, 32);
		loadButton.addActionListener(this);
		c.add(loadButton);
		gh++;
		saveButton = new JButton("Save");
		saveButton.setBounds(DISPLAY_X/2 - 64, 64 + 48*gh + MENU_HEIGHT, 128, 32);
		saveButton.addActionListener(this);
		c.add(saveButton);
		gh++;
		saveAsButton = new JButton("Save as");
		saveAsButton.setBounds(DISPLAY_X/2 - 64, 64 + 48*gh + MENU_HEIGHT, 128, 32);
		saveAsButton.addActionListener(this);
		c.add(saveAsButton);
		gh++;
		highscoreButton = new JButton("Highscore");
		highscoreButton.setBounds(DISPLAY_X/2 - 64, 64 + 48*gh + MENU_HEIGHT, 128, 32);
		highscoreButton.addActionListener(this);
		c.add(highscoreButton);
		gh++;
		versionButton = new JButton("Version");
		versionButton.setBounds(DISPLAY_X/2 - 64, 64 + 48*gh + MENU_HEIGHT, 128, 32);
		versionButton.addActionListener(this);
		c.add(versionButton);
		gh++;
		creditButton = new JButton("Credits");
		creditButton.setBounds(DISPLAY_X/2 - 64, 64 + 48*gh + MENU_HEIGHT, 128, 32);
		creditButton.addActionListener(this);
		c.add(creditButton);
		gh++;
		quitButton = new JButton("Quit");
		quitButton.setBounds(DISPLAY_X/2 - 64, 64 + 48*gh + MENU_HEIGHT, 128, 32);
		quitButton.addActionListener(this);
		c.add(quitButton);
		xButton = new JButton("X");
		xButton.setBounds(DISPLAY_X/2 + 64 + 16, 64 - 16 + MENU_HEIGHT,48,48);
		xButton.addActionListener(this);
		c.add(xButton);
	}
	/**
	 * Turns the 2d array of tiles into Labels which the player can see.
	 */
	public void createTerrains()
	{
		terrains = new JLabel[game.getWorldX()][game.getWorldY()];
		for(int i = 0; i < game.getTiles().length; i++)
		{
			for(int j = 0; j < game.getTiles()[i].length; j ++)
			{
				terrains[i][j] = new JLabel(game.getTiles()[i][j].getImageIcon());
				c.add(terrains[i][j]);
			}
		}
	}
	/**
	 * Places the terrains relative to the player. The game class stores the characters position in the world, 
	 * and then the terrains are placed relative to the player.
	 */
	public void placeTerrains()
	{
		for(int i = 0; i < game.getTiles().length; i++)
		{
			for(int j = 0; j < game.getTiles()[i].length; j ++)
			{
				terrains[i][j].setBounds(DISPLAY_X/2 + (i - (int)game.playerX)*32, DISPLAY_Y/2 - 16 + (j-(int)game.playerY)*32 + MENU_HEIGHT, 32, 32);
			}
		}
	}
	/**
	 * hides all the terrains outside the display area
	 */
	private void hideExtraTerrains()
	{
		for(int i = 0; i < game.getTiles().length; i++)
		{
			for(int j = 0; j < game.getTiles()[i].length; j ++)
			{
				if(terrains[i][j].getX() > DISPLAY_X - 32 || terrains[i][j].getY() > DISPLAY_Y + MENU_HEIGHT - 32 || terrains[i][j].getX() < 0 || terrains[i][j].getY() < MENU_HEIGHT)
				{
					terrains[i][j].setVisible(false);
				}
			}
		}
	}
	/**
	 * Moves the player whenever an appropriate action event occurs
	 * @param direction
	 */
	public void runMove(int direction)
	{
		game.player.move(direction);
	}
	/**
	 * Runs what happens when the player presses A. 
	 * Most of the time nothing happens, but if the player is on a specific tile and facing a specific
	 * direction something may happen.
	 */
	public void runA()
	{
		if(game.playerX == 6 && game.playerY == 8 && game.countUp != -1 && game.level == 1)
		{
			JOptionPane.showMessageDialog(rootPane, "This is too hard!", "Achievement Get", JOptionPane.INFORMATION_MESSAGE);
			showGameScreen(false);
			game.getTiles()[6][7].setType(Tile.DOOR_OPEN);
			terrains[6][7].setIcon(game.getTiles()[6][7].getImageIcon());
			showGameScreen(true);
		}
		else if (game.playerX == 4 && game.playerY == 8 && game.countRight != -1 && game.level == 1)
		{
			game.hasRedKey = true;
			showGameScreen(false);
			game.getTiles()[5][8].setType(Tile.TABLE_EMPTY);
			terrains[5][8].setIcon(game.getTiles()[5][8].getImageIcon());
			showGameScreen(true);
			dialogArea.append("\nRed Key obtained.");
			inventoryArea.append("\nRed Key");
			itemArea.append("\nRed Key");
			addToItems();
		}
		else if (game.playerX == 6 && game.playerY == 8 && game.countLeft != -1 && game.level == 1)
		{
			dialogArea.append("\nCannot reach key. Need to be right next to it.");
		}
		else if (game.playerX == 5 && game.playerY == 9 && game.countUp != -1 && game.level == 1)
		{
			dialogArea.append("\nCannot reach key. Need to be right next to it.");
		}
		else if (game.playerX == 5 && game.playerY == 9 && game.countDown != -1 && game.level == 1)
		{
			if(game.hasRedKey)
			{
				showGameScreen(false);
				game.getTiles()[5][10].setType(Tile.DOOR_OPEN);
				terrains[5][10].setIcon(game.getTiles()[5][10].getImageIcon());
				showGameScreen(true);
				dialogArea.append("\nThe door opened.");
			}
			else
			{
				dialogArea.append("\nThe door is locked.");
			}
		}
		else if ((game.playerX == 15 && game.playerY == 9 && game.countUp != -1) || (game.playerX == 14 && game.playerY == 8 && game.countRight != -1)|| (game.playerX == 16 && game.playerY == 8 && game.countLeft != -1) && game.level == 1)
		{
			JOptionPane.showMessageDialog(rootPane, "Sure I could give you the green key, \nbut first you must answer these questions three!", "Quizzer", JOptionPane.PLAIN_MESSAGE);
			String answer1 = JOptionPane.showInputDialog(rootPane, "What is your name?", "Quizzer", JOptionPane.QUESTION_MESSAGE);
			System.out.println(answer1);
			System.out.println(game.player.getName());
			if(answer1.equalsIgnoreCase(game.player.getName()))	
			{
				String answer2 = JOptionPane.showInputDialog(rootPane, "What is your favourite colour?", "Quizzer", JOptionPane.QUESTION_MESSAGE);
				if(answer2.equalsIgnoreCase(game.player.getFaveColor()))
				{
					if(JOptionPane.showInputDialog(rootPane, "What is the average flight speed of an unleaden swallow?", "Quizzer", JOptionPane.QUESTION_MESSAGE).equalsIgnoreCase("african or european"))
					{
						JOptionPane.showMessageDialog(rootPane, "Oh... I don't know! African or European? Hmmm...\nSince I don't even know the answer anymore I guess I will have to give you the green key.", "Quizzer", JOptionPane.PLAIN_MESSAGE);
						game.hasGreenKey = true;
						dialogArea.append("\nGreen Key obtained.");
						inventoryArea.append("\nGreen Key");
						itemArea.append("\nGreen Key");
						addToItems();
					}
					else
					{
						JOptionPane.showMessageDialog(rootPane, "Go talk to the silly man up north from here. You may need to beat the answer out of him.", "Quizzer", JOptionPane.PLAIN_MESSAGE);
					}
				}
				else
				{
					JOptionPane.showMessageDialog(rootPane, "Come back when you know your favourite colour.", "Quizzer", JOptionPane.PLAIN_MESSAGE);
				}
			}
			else
			{
				JOptionPane.showMessageDialog(rootPane, "Come back when you know your name.", "Quizzer", JOptionPane.PLAIN_MESSAGE);
			}
		}//end quizzer 1
		else if ((game.playerX == 15 && game.playerY == 3 && game.countUp != -1)|| (game.playerX == 14 && game.playerY == 2 && game.countRight != -1)|| (game.playerX == 16 && game.playerY == 2 && game.countLeft != -1) && game.level == 1)
		{
			JOptionPane.showMessageDialog(rootPane, "Hehe! You want to know what the last answer of the quizzer is?\nI'll tell. The average swallow takes 1 day to deliver a package, but without the package it takes less time!\nAh! You seem interested now. Unleaden swallows aren't carrying anything!\nThis is not your answer! Because the swallow could be either European or African! African swallows are much faster!", "Silly Man", JOptionPane.PLAIN_MESSAGE);
		}
		else if (game.playerX == 27 && game.playerY == 13 && game.countDown != -1 && game.level == 1)
		{
			if(game.hasGreenKey)
			{
				showGameScreen(false);
				game.getTiles()[27][14].setType(Tile.DOOR_OPEN);
				terrains[27][14].setIcon(game.getTiles()[27][14].getImageIcon());
				showGameScreen(true);
				dialogArea.append("\nThe door opened.");
			}
			else
			{
				dialogArea.append("\nThe door is locked.");
			}
		}
		else if (game.playerX == 27 && game.playerY == 14 && game.countDown != -1 && game.level == 1)
		{
			JOptionPane.showMessageDialog(rootPane, "So you've beaten by brother, and now you think you're done,\n well, you still have to answer this question one!", "Quizzer", JOptionPane.PLAIN_MESSAGE);
			if(JOptionPane.showInputDialog(rootPane, "There is something wrong in this world. Somethign missing. Something broken. Something you need to continue.\nWhat is it?", "Quizzer", JOptionPane.QUESTION_MESSAGE).equalsIgnoreCase("bridge"))
			{
				JOptionPane.showMessageDialog(rootPane, "Correct! I will now give you the bridge! You know what? Give a man a bridge and he'll cross a river, \ngive a man all the bridges and he'll cross all the rivers. Take them all", "Quizzer", JOptionPane.PLAIN_MESSAGE);
				game.hasBridge = true;
				dialogArea.append("\nBridge obtained.");
				inventoryArea.append("\nBridge");
				itemArea.append("\nBridge");
				addToItems();
			}
			else
			{
				JOptionPane.showMessageDialog(rootPane, "Check the river. Something is wrong.", "Quizzer", JOptionPane.PLAIN_MESSAGE);
			}
		}
		else if (game.playerX == 15 && game.playerY == 19 && game.countDown != -1 && game.level == 1)
		{
			if(game.hasBridge)
			{
				showGameScreen(false);
				game.getTiles()[15][20].setType(Tile.WOOD);
				terrains[15][20].setIcon(game.getTiles()[15][20].getImageIcon());
				showGameScreen(true);
				dialogArea.append("\nYou placed a bridge");
			}
			else
			{
				dialogArea.append("\nThe bridge is broken");
			}
		}
		else if ((game.playerX == 15 && game.playerY == 24 && game.countLeft != -1)||(game.playerX == 13 && game.playerY == 24 && game.countRight != -1)||(game.playerX == 14 && game.playerY == 23 && game.countDown != -1)||(game.playerX == 14 && game.playerY == 25 && game.countUp != -1) && game.level == 1)
		{
			if(!game.hasShovel)
			{
				JOptionPane.showMessageDialog(rootPane, "I don't even know why they made me stand guard by the bridge. The Leader already told me to destroy it.\nAnd yet here you are. I was told to kill anyone who made it across, but the Leader has gone too far!\n I will help you.", "Soldier", JOptionPane.PLAIN_MESSAGE);
				JOptionPane.showMessageDialog(rootPane, "Take this shovel. The entrance to the Leader's fortress is locked. To get in you need the blue key.\nIt is buried somewhere on this side of the river. It was buried recently so the grass hasn't had time to grow back.", "Soldier", JOptionPane.PLAIN_MESSAGE);
				game.hasShovel = true;
				dialogArea.append("\nShovel obtained.");
				inventoryArea.append("\nShovel");
				itemArea.append("\nShovel");
				addToItems();
				if(game.hasBlueKey)
				{
					JOptionPane.showMessageDialog(rootPane, "Oh! You already have the blue key! How did you manage that.\nI'd shake your hands... but, I think I know where they have been.", "Soldier", JOptionPane.PLAIN_MESSAGE);
					JOptionPane.showMessageDialog(rootPane, "Still take the shovel. It may be useful", "Soldier", JOptionPane.PLAIN_MESSAGE);
				}
			}
			else if (game.hasShovel && !game.hasBlueKey)
			{
				JOptionPane.showMessageDialog(rootPane, "To use the shovel, stand over the tile you want to dig, select it in the drop down menu, and press \'Use Item\'", "Soldier", JOptionPane.PLAIN_MESSAGE);
			}
			else if (game.hasBlueKey)
			{
				JOptionPane.showMessageDialog(rootPane, "That soldier standing at the gate is still loyal. he won't let you pass. You will have to fight your way thru. His armour is hard, don't try to attack him with your bare hands.", "Soldier", JOptionPane.PLAIN_MESSAGE);
			}
		}
		else if (game.playerX == 15 && game.playerY == 27 && game.countDown != -1 && game.level == 1)
		{
			if(game.hasBlueKey)
			{
				showGameScreen(false);
				game.getTiles()[15][28].setType(Tile.DOOR_OPEN);
				terrains[15][28].setIcon(game.getTiles()[15][28].getImageIcon());
				showGameScreen(true);
				dialogArea.append("\nThe door opened.");
			}
			else
			{
				dialogArea.append("\nThe door is locked.");
			}
		}
		else if (game.playerX == 15 && game.playerY == 30 && game.countDown != -1 && game.level == 1)
		{
			if(pacifist == 0)
			{
				JOptionPane.showMessageDialog(rootPane, "What are you doing her. The Leader has ordered that this area is off limits.\nWhat do you mean\"Then why are you here?\". Oh! I'll get you!", "Soldier", JOptionPane.PLAIN_MESSAGE);
				pacifist++;
			}
			else if(pacifist == 1)
			{
				JOptionPane.showMessageDialog(rootPane, "I'm warning you!", "Soldier", JOptionPane.PLAIN_MESSAGE);
				pacifist++;
			}
			else if(pacifist > 1 && pacifist < 10)
			{
				JOptionPane.showMessageDialog(rootPane, "This is your last chance!", "Soldier", JOptionPane.PLAIN_MESSAGE);
				pacifist++;
			}
			else if (pacifist >= 10)
			{
				JOptionPane.showMessageDialog(rootPane, "Pacifist", "Achievement Get", JOptionPane.INFORMATION_MESSAGE);
				JOptionPane.showMessageDialog(rootPane, "Fine you got me. I talk much, but I could never bring myself to actually harm anyone.\nI just need to seem loyal to appease the Leader. I will let you through, but don't tell anyone.", "Soldier", JOptionPane.PLAIN_MESSAGE);
				game.goToNextLevel();
			}
		}
		else if (game.playerX == 12 && game.playerY == 3 && game.countUp != -1)
		{
			JOptionPane.showMessageDialog(rootPane, "I guess you made it through. Sigh. Funny thing power. What you got through to get it might be even greater than what you do with it.\nIf you were expecting an epic final battle... My only ability is deception. See you don't need to be strong to rule. You just need people to think you are.\n I got the soldeirs to think I was mighty and they joined me. Soon enough I actualy was powerful with all my soldiers.\n But the power was too much. I went mad. The soldiers deserted and my power waned. Until the only thing I has left was fear.\nI will go quitely...\n...\n...","Leader", JOptionPane.PLAIN_MESSAGE);
			JOptionPane.showMessageDialog(rootPane, "Congratulations! You win!","Leader", JOptionPane.PLAIN_MESSAGE);
			runQuit();
		}
		else
		{
		
		}
	}//end run A
	int pacifist = 0; //variabel used to determine what the final soldier will say.
	/**
	 * edits the item select menu whenever a new item is obtained
	 */
	public void addToItems()
	{
		String text = itemArea.getText();
		Tools.removeWord(text); // removes the word "items"
		int size = 1;
		if(game.hasRedKey)
			size++;
		if(game.hasGreenKey)
			size++;
		if(game.hasBlueKey)
			size++;
		if(game.hasBridge)
			size++;
		if(game.hasShovel)
			size++;
		String[] words = new String[size];	
		words[0] = "Selected Item";
		int on = 0;
		if(game.hasRedKey)
		{
			on++;
			words[on] = "Red Key";
		}
		if(game.hasGreenKey)
		{
			on++;
			words[on] = "Green Key";
		}
		if(game.hasBlueKey)
		{
			on++;
			words[on] = "Blue Key";
		}
		if(game.hasBridge)
		{
			on++;
			words[on] = "Bridge";
		}
		if(game.hasShovel)
		{
			on++;
			words[on] = "Shovel";
		}
		
		c.remove(selectedItemBox);
		selectedItemBox = new JComboBox(words);
		selectedItemBox.setBounds(4, RES_Y - 56 + MENU_HEIGHT, 256, 24);
		c.add(selectedItemBox);
	}
	/**
	 * B is used to attack things. These code the special events that occur when b is pressed on a special tile.
	 */
	public void runB()
	{
		if ((game.playerX == 15 && game.playerY == 3 && game.countUp != -1)|| (game.playerX == 14 && game.playerY == 2 && game.countRight != -1)|| (game.playerX == 16 && game.playerY == 2 && game.countLeft != -1) && game.level == 1)
		{
			JOptionPane.showMessageDialog(rootPane,"OK! Ouch! I'll tell you the answer!\nThe quizzer doesn't know about the difference between african and european swallows.\nAsk him whether he means african or european and you will beat him!", "Silly Man", JOptionPane.PLAIN_MESSAGE);
		}
		else if (game.playerX == 15 && game.playerY == 30 && game.countDown != -1 && game.level == 1)
		{
			JOptionPane.showMessageDialog(rootPane, "It is not advisable to attack a soldier wearing armour with your bare hands", "Not Good Idea", JOptionPane.INFORMATION_MESSAGE);
		}
		else
		{
			
		}
	}
	/**
	 * Is run whenever the player presses the select or use item button.
	 * It checks to see if first the player is at the right loaction.
	 * Then if the item is correct. 
	 * If it is the wrong item the game will tell the player.
	 */
	public void useItem()
	{
		if (game.playerX == 5 && game.playerY == 9 && game.countDown != -1 && game.level == 1)
		{
			if(selectedItemBox.getSelectedItem().equals("Red Key"))
			{
				showGameScreen(false);
				game.getTiles()[5][10].setType(Tile.DOOR_OPEN);
				terrains[5][10].setIcon(game.getTiles()[5][10].getImageIcon());
				showGameScreen(true);
				dialogArea.append("\nThe door opened.");
			}
		}
		else if (game.playerX == 27 && game.playerY == 13 && game.countDown != -1 && game.level == 1)
		{
			if(selectedItemBox.getSelectedItem().equals("Green Key"))
			{
				showGameScreen(false);
				game.getTiles()[27][14].setType(Tile.DOOR_OPEN);
				terrains[27][14].setIcon(game.getTiles()[27][14].getImageIcon());
				showGameScreen(true);
				dialogArea.append("\nThe door opened.");
			}
		}
		else if (game.playerX == 15 && game.playerY == 19 && game.countDown != -1 && game.level == 1)
		{
			if(game.hasBridge)
			{
				if(selectedItemBox.getSelectedItem().equals("Bridge"))
				{
					showGameScreen(false);
					game.getTiles()[15][20].setType(Tile.WOOD);
					terrains[15][20].setIcon(game.getTiles()[15][20].getImageIcon());
					showGameScreen(true);
					dialogArea.append("\nYou placed a bridge");
				}
				else
				{
					dialogArea.append("\nYou need to place a bridge.");
				}
			}
			else
			{
				JOptionPane.showMessageDialog(rootPane, "Michael Phelps", "Achievement Get", JOptionPane.INFORMATION_MESSAGE);
				showGameScreen(false);
				game.playerY += 2;
				showGameScreen(true);
				dialogArea.append("\nYou placed a bridge");
			}
		}
		else if (game.playerX == 18 && game.playerY == 27 && game.level == 1)
		{
			if(game.hasShovel)
			{
				if(selectedItemBox.getSelectedItem().equals("Shovel"))
				{
					game.hasBlueKey = true;
					dialogArea.append("\nYou dug up the Blue Key.");
					inventoryArea.append("\nBlue Key");
					itemArea.append("\nBlue Key");
					addToItems();
				}
				else
				{
					dialogArea.append("\nYou need to use the shovel to dig.");
				}
			}
			else
			{
				JOptionPane.showMessageDialog(rootPane, "Dirty Hands", "Achievement Get", JOptionPane.INFORMATION_MESSAGE);
				game.hasBlueKey = true;
				dialogArea.append("\nYou dug up the Blue Key.");
				inventoryArea.append("\nBlue Key");
				itemArea.append("\nBlue Key");
				addToItems();
			}
		}
		else if (game.playerX == 15 && game.playerY == 27 && game.countDown != -1 && game.level == 1)
		{
			if(selectedItemBox.getSelectedItem().equals("Blue Key"))
			{
				showGameScreen(false);
				game.getTiles()[15][28].setType(Tile.DOOR_OPEN);
				terrains[15][28].setIcon(game.getTiles()[15][28].getImageIcon());
				showGameScreen(true);
				dialogArea.append("\nThe door opened.");
			}
		}
		else if (game.playerX == 15 && game.playerY == 30 && game.countDown != -1 && game.level == 1)
		{
			if(selectedItemBox.getSelectedItem().equals("Shovel"))
			{
				JOptionPane.showMessageDialog(rootPane, "What are you going to do? Shovel me?", "Soldier", JOptionPane.PLAIN_MESSAGE);
				JOptionPane.showMessageDialog(rootPane, "Famous Last Words", "Achievement Get", JOptionPane.INFORMATION_MESSAGE);
				game.goToNextLevel();
			}
		}
		else
		{
			dialogArea.append("\nNow is not the time to use that.");
		}
	}
	
	
	public void goToBlankScreen()
	{
		screen = BLANK;
		hideAll();
	}
	public void goToWelcomeScreen()
	{
		screen = WELCOME;
		hideAll();
		showWelcomeScreen(true);
	}
	public void goToScreen()
	{
		if(screen == BLANK)
		{
			goToBlankScreen();
		}
		else if(screen == WELCOME)
		{
			goToWelcomeScreen();
		}
		else if(screen == GAME)
		{
			goToGameScreen();
		}
		else if(screen == STATS)
		{
			goToStatsScreen();
		}
		else if(screen == INVENTORY)
		{
			goToInventoryScreen();
		}
		else if(screen == MAP)
		{
			goToMapScreen();
		}
		else if(screen == HIGHSCORE)
		{
			goToHighscoreScreen();
		}
		else if(screen == VERSION)
		{
			goToVersionScreen();
		}
		else if(screen == CREDITS)
		{
			goToCreditsScreen();
		}
		else if(screen == HELP)
		{
			goToHelpScreen();
		}
	}
	public void goToNextScreen()
	{

		if(screen == GAME)
		{
			goToStatsScreen();
		}
		else if(screen == STATS)
		{
			goToInventoryScreen();
		}
		else if(screen == INVENTORY)
		{
			goToMapScreen();
		}
		else if(screen == MAP)
		{
			goToHighscoreScreen();
		}
		else if(screen == HIGHSCORE)
		{
			goToVersionScreen();
		}
		else if(screen == VERSION)
		{
			goToCreditsScreen();
		}
		else if(screen == CREDITS)
		{
			goToHelpScreen();
		}
		else if(screen == HELP)
		{
			goToGameScreen();
		}
	}
	public void goToGameScreen()
	{
		screen = GAME;
		hideAll();
		showGameScreen(true);
		showActionButtons(true);
	}
	public void goToStatsScreen()
	{
		screen = STATS;
		hideAll();
		showStatsScreen(true);
		showActionButtons(true);
	}
	public void goToInventoryScreen()
	{
		screen = INVENTORY;
		hideAll();
		showInventoryScreen(true);
		showActionButtons(true);
	}
	public void goToMapScreen()
	{
		screen = MAP;
		hideAll();
		showMapScreen(true);
		showActionButtons(true);
	}
	public void goToHighscoreScreen()
	{
		screen = HIGHSCORE;
		hideAll();
		showHighscoreScreen(true);
		showActionButtons(true);
	}
	public void goToVersionScreen()
	{
		screen = VERSION;
		hideAll();
		showVersionScreen(true);
		showActionButtons(true);
	}
	public void goToCreditsScreen()
	{
		screen = CREDITS;
		hideAll();
		showCreditsScreen(true);
		showActionButtons(true);
	}
	public void goToHelpScreen()
	{
		screen = HELP;
		hideAll();
		showHelpScreen(true);
		showActionButtons(true);
	}
	public void goToPreviousScreen()
	{
		if(screen == GAME)
		{
			goToHelpScreen();
		}
		else if(screen == STATS)
		{
			goToGameScreen();
		}
		else if(screen == INVENTORY)
		{
			goToStatsScreen();
		}
		else if(screen == MAP)
		{
			goToInventoryScreen();
		}
		else if(screen == HIGHSCORE)
		{
			goToMapScreen();
		}
		else if(screen == VERSION)
		{
			goToHighscoreScreen();
		}
		else if(screen == CREDITS)
		{
			goToVersionScreen();
		}
		else if(screen == HELP)
		{
			goToCreditsScreen();
		}
	}
	public void goToMenuButtons(boolean b)
	{
		if(b)
		{
			hideScreens();
		}
		else
		{
			goToScreen();
		}
		showMenuButtons(b);
	}
	/**
	 * creates new game
	 */
	public void runNew()
	{
		if(!gameLoaded)
		{
			game = new Game();
			createGameScreen();
			createStatsScreen();
			createInventoryScreen();
			createMapScreen();
			createHighscoreScreen();
			createVersionScreen();
			createCreditsScreen();
			createHelpScreen();
			createActionButtons();
			createMenuButtons();
			hideAll();
			goToHelpScreen();
		}
	}
	/**
	 * Loading does work. However there is not conditions to prevetn errors from occuring when it is done at the wrong time
	 */
	public void runLoad()
	{
		JOptionPane.showMessageDialog(rootPane, "Loading not enabled", "Load", JOptionPane.PLAIN_MESSAGE);
		/*
		String file = JOptionPane.showInputDialog(rootPane, "Enter name of save file", "Load", JOptionPane.PLAIN_MESSAGE);
		game = new Game(file);
		createGameScreen();
		createStatsScreen();
		createInventoryScreen();
		createMapScreen();
		createHighscoreScreen();
		createVersionScreen();
		createCreditsScreen();
		createHelpScreen();
		createActionButtons();
		createMenuButtons();
		hideAll();
		goToHelpScreen();
		*/
	}
	
	/**
	 * savign works but it might CASUE ERRORS when it is done at the wrong time.
	 */
	public void runSave()
	{
		JOptionPane.showMessageDialog(rootPane, "Saving not enabled", "Save", JOptionPane.PLAIN_MESSAGE);
		/*
		if(JOptionPane.showConfirmDialog(rootPane, "Would you like to write over the default save file?", "Save", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION)
		{
			game.saveGame("default");
		}
		*/
	}
	public void runSaveAs()
	{
		JOptionPane.showMessageDialog(rootPane, "Saving not enabled", "Save as", JOptionPane.PLAIN_MESSAGE);
		/*
		String save = JOptionPane.showInputDialog(rootPane, "What would you like tto save this as?", "Save as", JOptionPane.QUESTION_MESSAGE);
		game.saveGame(save);
		*/
	}
	/**
	 * closes the gui
	 */
	public void runQuit()
	{
		if(JOptionPane.showConfirmDialog(rootPane, "Are you sure you would like to quit?", "Quit", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION)
		{
			System.exit(EXIT_ON_CLOSE);
		}
	}
	
	
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==lButton)
			goToPreviousScreen();
		if(e.getSource()==rButton)
			goToNextScreen();
		if(e.getSource()==upButton)
		{
			if(screen == GAME)
			{
				runMove(Game.UP);
			}
		}
		if(e.getSource()==downButton)
		{
			if(screen == GAME)
			{
				runMove(Game.DOWN);
			}
		}
		if(e.getSource()==leftButton)
		{
			if(screen == GAME)
			{
				runMove(Game.LEFT);
			}
		}
		if(e.getSource()==rightButton)
		{
			if(screen == GAME)
			{
				runMove(Game.RIGHT);
			}
		}
		if(e.getSource()==aButton)
			runA();
		if(e.getSource()==bButton)
			runB();
		if(e.getSource()==startButton)
			goToMenuButtons(true);
		if(e.getSource()==selectButton)
			useItem();
		if(e.getSource()==useItemButton)
			useItem();
		if(e.getSource()==levelButton)
			goToStatsScreen();
		if(e.getSource()==mapButton)
		{
 			if(screen == GAME)
 				goToMapScreen();
 			else
 				goToGameScreen();
		}//end if

		if(e.getSource()==newButton)
			runNew();
		if(e.getSource()==loadButton)
			runLoad();
		if(e.getSource()==saveButton)
			runSave();
		if(e.getSource()==saveAsButton)
			runSaveAs();
		if(e.getSource()==highscoreButton)
			goToHighscoreScreen();
		if(e.getSource()==versionButton)
			goToVersionScreen();
		if(e.getSource()==creditButton)
			goToCreditsScreen();
		if(e.getSource()==quitButton)
			runQuit();
		if(e.getSource()==xButton)
			goToMenuButtons(false);
		if(e.getSource()==newItem)
			runNew();
		if(e.getSource()==loadItem)
			runLoad();
		if(e.getSource()==saveItem)
			runSave();
		if(e.getSource()==saveAsItem)
			runSaveAs();
		if(e.getSource()==quitItem)
			runQuit();
		if(e.getSource()==gameItem)
		{
			if(gameLoaded)
				goToGameScreen();
		}
		if(e.getSource()==statsItem)
		{
			if(gameLoaded)
				goToStatsScreen();
		}
		if(e.getSource()==inventoryItem)
		{
			if(gameLoaded)
				goToInventoryScreen();
		}
		if(e.getSource()==mapItem)
		{
			if(gameLoaded)
				goToMapScreen();
		}
		if(e.getSource()==highscoreItem)
		{
			if(gameLoaded)
				goToHighscoreScreen();
		}
		if(e.getSource()==versionItem)
		{
			if(gameLoaded)
				goToVersionScreen();
		}
		if(e.getSource()==creditsItem)
		{
			if(gameLoaded)
				goToCreditsScreen();
		}
		if(e.getSource()==helpItem)
		{
			if(gameLoaded)
				goToHelpScreen();
		}
		
	}//end action performed method

	/**
	 * The key listener works as long as no graphical buttons are pressed.
	 * The keyboard has been left enabled to make testing the game easier, 
	 * but is kept secret to the user as suddenly having the keyboard not work would frustrate them
	 */
	public void keyPressed(KeyEvent e) 
	{
		System.out.println(e.getKeyCode());
		if (e.getKeyCode() == 85)
		{
			System.out.println(e.getKeyCode());
			useItem();
		}
		if (e.getKeyCode() == 82)
		{
			System.out.println(e.getKeyCode());
			goToNextScreen();
		}
		else if (e.getKeyCode() == 76)
		{
			System.out.println(e.getKeyCode());
			goToPreviousScreen();
		}
		else if (e.getKeyCode() == 37)
		{
			System.out.println(e.getKeyCode());
			runMove(Game.LEFT);
		}
		else if (e.getKeyCode() == 38)
		{
			System.out.println(e.getKeyCode());
			runMove(Game.UP);
		}
		else if (e.getKeyCode() == 39)
		{
			System.out.println(e.getKeyCode());
			runMove(Game.RIGHT);
		}
		else if (e.getKeyCode() == 40)
		{
			System.out.println(e.getKeyCode());
			runMove(Game.DOWN);
		}
		else if (e.getKeyCode() == 65)
		{
			System.out.println(e.getKeyCode());
			runA();
		}
		else if (e.getKeyCode() == 66)
		{
			System.out.println(e.getKeyCode());
			runB();
		}
	}

	public void keyReleased(KeyEvent e) 
	{
		
	}

	public void keyTyped(KeyEvent e) 
	{
		
	}
}
