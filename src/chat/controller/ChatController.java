package chat.controller;

import chat.model.Chatbot;
import chat.view.ChatView;
import chat.view.ChatFrame;
/**
 * Controller for the chatbot project.
 * @author droc6148
 * @Version 1.3 10/23/15 keeps popuping up.
 */
public class ChatController 
{
	private Chatbot simpleBot;
	private ChatView display;
	private ChatFrame baseFrame;
	private Chatbot chatBot;

	
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
		String textFromUser = display.collectUserText("What do you want to talk about?");
		while(simpleBot.lengthChecker(textFromUser))
		{
			if(simpleBot.contentChecker(textFromUser))
			{
				display.displayText("Wow, I had no idea you loved " + simpleBot.getContent());
			}	
			else if(simpleBot.memeChecker(textFromUser))
			{
				display.displayText("Who knew you liked dank memes!!!!");
			} 
			
			textFromUser = display.collectUserText(textFromUser);
		}
	}
	
	public ChatView getChatView()
	{
		return display;
	}
	
	public ChatFrame getBaseFrame()
	{
		return baseFrame;
	}
	
	public Chatbot getChatbot()
	{
		return chatBot;
	}
	
	
}
