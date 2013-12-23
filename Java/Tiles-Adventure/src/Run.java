/**
 * This class runs the program.
 * @author Stephen Morvai
 *
 */
public class Run 
{
	private static GUI gui;
	/**
	 * @return The GUI that is being used
	 */
	public static GUI getGui()
	{
		return gui;
	}
	/**
	 * Creates the GUI
	 */
	public static void main (String[] args)
	{
		gui = new GUI();
	}//end main method
}//end class
