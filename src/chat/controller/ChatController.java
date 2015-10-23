package chat.controller;

import chat.model.Chatbot;
import chat.view.ChatView;
/**
 * Controller for the chatbot project.
 * @author droc6148
 * @Version 1.3 10/23/15 keeps popuping up.
 */
public class ChatController 
{
	private Chatbot simpleBot;
	private ChatView display;
	
	
	public ChatController()
	{
		display = new ChatView();
		String userName = display.collectUserText("What is your name?");
		simpleBot = new Chatbot(userName);
	}
	
	public void start()
	{
		display.displayText("Hello " + simpleBot.getUserName());
		chat();
	}
	
	private void chat()
	{
		String textFromUser = display.collectUserText("Talk to the chatbot");
		while(simpleBot.lengthChecker(textFromUser))
		{
			textFromUser = display.collectUserText("wow " + textFromUser);
		}
	}
}
