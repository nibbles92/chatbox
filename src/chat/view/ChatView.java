package chat.view;

import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
/**
 * 
 * @author droc6148
 *@version 1.2 Added Icon to the input window.
 */
public class ChatView 
{
	private String windowMessage;
	private ImageIcon chatIcon;
	
	public ChatView()
	{
		windowMessage = "This message brought to you by chatbot ";
		chatIcon = new ImageIcon(getClass().getResource("images/download.jpeg"));
	}
	
	
	    /**
	    * Popups the display and show the user input.
	    * @param displayText The text the user put in.
	    * @return
	    */
		public String collectUserText(String displayText)
		{
			String userInput = "";
			
			userInput = JOptionPane.showInputDialog(null, displayText, windowMessage, JOptionPane.INFORMATION_MESSAGE,chatIcon,null,"type here please").toString();
			
			return userInput;
		}
		
	/**
	 * 	shows the input what user wrote.
	 * @param displayText
	 */
	public void displayText(String displayText)
	{
		JOptionPane.showMessageDialog(null, displayText,windowMessage,JOptionPane.PLAIN_MESSAGE,chatIcon);
	}
}
