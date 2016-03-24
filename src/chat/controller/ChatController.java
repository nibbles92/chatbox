package chat.controller;

import twitter4j.TwitterException;
import chat.model.Chatbot;
import chat.view.ChatView;
import chat.view.ChatFrame;
import chat.model.CTECTwitter;
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
	private CTECTwitter myTwitter;

	/**
	 * shows the display
	 */
	public ChatController()
	{
		myTwitter = new CTECTwitter(this);
		display = new ChatView();
		String userName = display.collectUserText("What is your name?");
		simpleBot = new Chatbot(userName);
		baseFrame = new ChatFrame(this);
			
	}
	/**
	 * shows the users name and says hello
	 */
	public void start()
	{
		display.displayText("Hello " + simpleBot.getUserName());
		//chat();
	}
	/**
	 * collects user answer and displays message
	 */
	private void chat()
	{
		String textFromUser = display.collectUserText("What do you want to talk about?");
		while(simpleBot.lengthChecker(textFromUser))
		{
			textFromUser = simpleBot.processConversation(textFromUser);
			textFromUser = display.collectUserText(textFromUser);
		}
	}
	/**
	 * shows botResposnse and has a shutdown
	 * @param conversation
	 * @return
	 */
	public String fromUserToChatbot(String conversation)
	{
		String botResponse = "";
		
		if(simpleBot.quitChecker(conversation))
		{
			shutDown();
		}
		
		botResponse = simpleBot.processConversation(conversation);
		
		return botResponse;
	}
	/**
	 * shuts down the program
	 */
	private void shutDown()
	{
		display.displayText("Goodbye, " + simpleBot.getUserName() + " it has been fun talking to you");
		System.exit(0);
	}
	
	public void sendTweet(String tweet)
	{
		myTwitter.sendTweet(tweet);
	}
	
	public String analyze(String userName)
	{
		String userAnalysis = "The Twitter user " + userName + "has...";
		try
		{
				myTwitter.loadTweets(userName);
		}
		catch(TwitterException error)
		{
			handleErrors(error.getErrorMessage());
		}
		userAnalysis += myTwitter.topResults();
		return userAnalysis;
	}
	
	public void handleErrors(String error)
	{
		display.displayText(error);
	}
	
	/**
	 * getters and setters
	 * @return
	 */
	public ChatView getChatView()
	{
		return display;
	}
	/**
	 * getters and setters
	 * @return
	 */
	public ChatFrame getBaseFrame()
	{
		return baseFrame;
	}
	/**
	 * getters and setters
	 * @return
	 */
	public Chatbot getChatbot()
	{
		return chatBot;
	}
	
	
	
	
}
