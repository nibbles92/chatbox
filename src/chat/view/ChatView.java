package chat.view;

import javax.swing.JOptionPane;

/**
 * 
 * @author droc6148
 *@version 1.0
 */
public class ChatView 
{
	
	    /**
	    * Popups the display and show the user input.
	    * @param displayText The text the user put in.
	    * @return
	    */
		public String collectUserText(String displayText)
		{
			String userInput = "";
			
			userInput = JOptionPane.showInputDialog(null, displayText);
			
			return userInput;
		}
		
	/**
	 * 	shows the input what user wrote.
	 * @param displayText
	 */
	public void displayText(String displayText)
	{
		JOptionPane.showMessageDialog(null, displayText);
	}
}
