package chat.controller;

/**
 * Starts the ChatBot program.
 * @author droc6148
 *@version 1.0 10/21/15
 */
public class ChatBotRunner 
{
	public static void main (String[] arg)
	{
		ChatBotController myController = new ChatBotController();
		myController.start();
	}
}
