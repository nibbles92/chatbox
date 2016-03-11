package chat.model;

import java.util.ArrayList;
import twitter4j.*;
import chat.controller.ChatController;

public class CTECTwitter
	{
		private ArrayList<Status> statusList;
		private ArrayList<String> wordsList;
		private Twitter chatBotTwitter;
		private ChatController baseController;
		
	public CTECTwitter(ChatController baseController)
	{
		this.baseController = baseController;
		statusList = new ArrayList<Status>();
		wordsList = new ArrayList<String>();
		this.chatBotTwitter = TwitterFactory.getSingleton();
	}

	public void sendTweet(String message)
	{	
		try
		{
			chatBotTwitter.updateStatus("Dylan Rockne #APCSRocks @CTECNow Thanks @cscheerleader & @codyhenrichsen!");
		}
		catch(TwitterException error)
		{
			baseController.handleErrors(error.getErrorMessage());
		}
		
	}

}