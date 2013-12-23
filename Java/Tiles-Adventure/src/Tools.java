import java.awt.*;

import javax.swing.JOptionPane;


public class Tools
{
	/*
	 * Colors
	 * These constants are here so that the assignment of certain colors can be consistent
	 * throughout the project.
	 * 
	 */
	//Mono-chromatic
	final static Color WHITE = new Color(255,255,255); //White has 255 red, 255 blue, 255 green, which our eyes see as white since it contains most of the spectrum
	final static Color LIGHT_GRAY = new Color(192,192,192); //lower numbers gives less intense amounts of light, which grays as the intensity lowers
	final static Color GRAY = new Color(128,128,128); 
	final static Color DARK_GRAY = new Color(64,64,64);
	final static Color BLACK = new Color(0,0,0);// No light of any color is produced, this results in the screen looking like it is off.
	//primary
	final static Color RED = new Color(255,0,0); // First Value is Red
	final static Color GREEN = new Color(0,255,0);// Second Value is Green
	final static Color BLUE = new Color(0,0,255); // Third Value is Blue
	//secondary
	final static Color YELLOW = new Color(255,255,0);//mixing red and green make yellow
	final static Color CYAN = new Color(0,255,255);//blue and green make cyan
	final static Color MAGENTA = new Color(255,0,255);//red and blue make magenta


	/**
	 * Checks if a character is an integer
	 * @param c
	 * @return true/false
	 */
	public static boolean isInteger(char c)
	{
		if(c == '0' || c == '1' || c == '2' || c == '3' ||c == '4' || c == '5' || c == '6' || c == '7' ||c == '8' || c == '9' )
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	/**
	 * checks if a string is an integer by checking if each individual char is an integer
	 * @param str
	 * @return
	 */
	public static boolean isInteger(String str)
	{
		for(int i = 0; i < str.length(); i++)
		{
			if(!isInteger(str.charAt(i)))
			{
				return false;
			}
		}
		return true;
	}
	/**
	 * UNUSED AS IT DID NOT WORK PROPERLY
	 * Returns the first word in a string
	 * @param edt the string
	 * @return first word in string
	 */
	public static String getWord(String edt)
	{
		edt = edt.toLowerCase();
		String edited = "";
		/*
		 * Finds first char then stops removing junk
		 */
		for(int i = 0; i < edt.length(); i++)
		{
			if(!edt.equals(null))
			{
				System.out.println(edt.charAt(i));
				if(edt.charAt(i) < 'a' || edt.charAt(i) > 'z')
				{
					edited = edt.substring(i+1);
				}
				else
				{
					break;
				}
			}
			else
			{
				break;
			}
		}//end for
		String word = "";
		/*
		 * keeps remvoing good chars from the word, then stops once junk char is reached
		 */
		for(int i = 0; i < edited.length(); i++)
		{
			System.out.println(edited.charAt(i));
			if(edited.charAt(i) > 'a' && edited.charAt(i) < 'z' )
			{
				word = word + edited.charAt(i);
			}
			else // when junk is reached
			{
				break;
			}
		}//end for
		return word;
	}//end getWord
	/**
	 * UNUSED AS THIS DID NOT WORK
	 * removes the first word in a string
	 * @param edt
	 * @return string with out the first word
	 */
	public static String removeWord(String edt)
	{
		edt = edt.toLowerCase();
		String edited = "";
		/*
		 * Finds first char then stops removing junk
		 */
		for(int i = 0; i < edt.length(); i++)
		{
			if((edt.charAt(i) < 'a' || edt.charAt(i) > 'z' ) && !edt.equals(null))
			{
				edited = edt.substring(i+1);
			}
			else
			{
				break;
			}
		}//end for
		String wordLess = "";
		/*
		 * keeps removing good chars from the word, then stops once junk char is reached
		 */
		for(int i = 0; i < edited.length(); i++)
		{
			if(!edited.equals(null))
			{
				if((edited.charAt(i) > 'a' && edited.charAt(i) < 'z' ))
				{
					wordLess = edited.substring(i+1);
				}
				else // when junk is reached
				{
					break;
				}
			}
			else
			{
				break;
			}
		}//end for
		return wordLess;
	}
	
	/**
	 * This method is used.
	 * This method removes any none char character from the beginning of a string,
	 * and then it removes the first word it finds.
	 * @param line
	 * @return string without its first word
	 */
	public static String deleteWord(String line)
	{
		line = line.toLowerCase();
		int count = 0;
		int least = -1;
		int most = -1;
		for(int i = 'a'; i <= 'z'; i++)
		{
			if(least > line.indexOf(i) || least == -1)
			{
				if(line.indexOf(i) > -1)
				{
					least = line.indexOf(i);
				}
			}
		}
		if(least < 0)
		{
			return null;
		}
		else
		{
			line = line.substring(least);
		}
		for(int i = 0; i < line.length(); i++)
		{
			if((line.charAt(i)< 'a' || line.charAt(i)> 'z') && line.charAt(i) != '_')
			{
				return line.substring(i);
			}
		}
		return null;
	}
	
	/**
	 * This method is used.
	 * This removes the non-char characters,
	 * and then removes the rest of a string
	 * once it finds a word
	 * @param line
	 * @return the first word in a line
	 */
	public static String findWord(String line)
	{
		if(line.equals(null))
		{
			return null;
		}
		line = line.toLowerCase();
		int count = 0;
		int least = -1;
		int most = -1;
		for(int i = 'a'; i <= 'z'; i++)
		{
			if(least > line.indexOf(i) || least == -1)
			{
				if(line.indexOf(i) > -1)
				{
					least = line.indexOf(i);
				}
			}
		}
		if(least < 0)
		{
			return null;
		}
		else
		{
			line = line.substring(least);
		}
		for(int i = 0; i < line.length(); i++)
		{
			if((line.charAt(i)< 'a' || line.charAt(i)> 'z') && line.charAt(i) != '_')
			{
				return line.substring(0, i);
			}
		}
		return line;
	}
	/*
	 * Extra code:
	 * 
	 * Just code that did not work that I might have wanted later.
	 */
	/*
	JOptionPane.showMessageDialog(rootPane, "Sure I could give you the green key. \nBut first you must answer these questions three!" ,"Quizzer", JOptionPane.PLAIN_MESSAGE);
			String answer1 = JOptionPane.showInputDialog(rootPane, "What is your name?" ,"Quizzer", JOptionPane.QUESTION_MESSAGE);
			boolean correct = false;
			for(int i = 0; i < 32; i++)
			{
				if (Tools.getWord(answer1).equalsIgnoreCase(game.player.getName()))
				{
					correct = true;
					break;
				}//end if
				answer1 = Tools.removeWord(answer1);
				if(Tools.getWord(answer1).equals(null))
				{
					correct = false;
					break;
				}//end if
			}//end if
			if(correct)
			{
				String answer2 = JOptionPane.showInputDialog(rootPane, "What is your favourite colour?" ,"Quizzer", JOptionPane.QUESTION_MESSAGE);
				correct = false;
				for(int i = 0; i < 32; i++)
				{
					if (Tools.getWord(answer2).equalsIgnoreCase(game.player.getFaveColor()))
					{
						correct = true;
						break;
					}//end if
					answer2 = Tools.removeWord(answer2);
					if(Tools.getWord(answer2).equals(null))
					{
						correct = false;
						break;
					}//end if
				}//end for
				if (correct)
				{
					String answer3 = JOptionPane.showInputDialog(rootPane, "What is the average flight speed of an unleadden swallow?" ,"Quizzer", JOptionPane.QUESTION_MESSAGE);
					correct = false;
					for(int i = 0; i < 32; i++)
					{
						if (Tools.getWord(answer3).equalsIgnoreCase("african"))
						{
							answer3 = Tools.removeWord(answer3);
							for(int j = 0; j < 32; j++)
							{
								if (Tools.getWord(answer3).equalsIgnoreCase("or"))
								{
									answer3 = Tools.removeWord(answer3);
									for(int k = 0; k < 32; k++)
									{
										if (Tools.getWord(answer3).equalsIgnoreCase("european"))
										{
											correct = true;
											break;
										}//end if
										answer3 = Tools.removeWord(answer3);
										if(Tools.getWord(answer3).equalsIgnoreCase(null))
										{
											correct = false;
											break;
										}//end if
									}//end for
								}//end if
								answer3 = Tools.removeWord(answer3);
								if(Tools.getWord(answer3).equalsIgnoreCase(null))
								{
									correct = false;
									break;
								}//end if
							}//end for
						}//end if
						answer1 = Tools.removeWord(answer3);
						if(Tools.getWord(answer3).equalsIgnoreCase(null))
						{
							correct = false;
							break;
						}//end if
					}//end for
				}//end if swallow
				else
				{
						JOptionPane.showInputDialog(rootPane, "Go talk to that silly fellow up north. He might give you the answer" ,"Quizzer", JOptionPane.PLAIN_MESSAGE);
				}//end else
			}//end if color
			else
			{
				JOptionPane.showInputDialog(rootPane, "Come back when you know your favourite colour?" ,"Quizzer", JOptionPane.PLAIN_MESSAGE);
			}
		}//end if name
		else
		{
			JOptionPane.showInputDialog(rootPane, "Come back when you know your name?" ,"Quizzer", JOptionPane.PLAIN_MESSAGE);
		}
		*/

}
