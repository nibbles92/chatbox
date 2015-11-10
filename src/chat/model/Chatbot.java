package chat.model;

import java.util.ArrayList;

/**
 * Base version of the 2015 Chatbot class. Only stub methods are provided. Students will complete methods as part
 * of the project.
 * @author Dylan Rockne
 * @version 1.4 11/3/15 Built and called buildMemesList. Repaired the getCotent method completed the content checker method
 */
public class Chatbot 
{
	private ArrayList<String> memesList;
	private ArrayList<String> politicalTopicList;
	private String userName;
	private String content;
	
	/**
	 * Creates an instance of the Chatbot with the supplied username.
	 * @param userName The username for the chatbot.
	 */
	public Chatbot(String userName)
	{
		this.memesList = new ArrayList<String>();
		this.politicalTopicList = new ArrayList<String>();
		this.userName = userName;
		this.content = "video games";
		
	}
	
	private void buildMemesList()
	{
		this.memesList.add("Done with life kermit");
		this.memesList.add("Doge");
		this.memesList.add("Grumpy Cat");
		this.memesList.add("Black guy on phone");
		this.memesList.add("Bad luck brian");
		this.memesList.add("90s spiderman");
		this.memesList.add("success kid");
		this.memesList.add("evil girl");
		this.memesList.add("Drunk baby");
		this.memesList.add("Tis but a scratch");
		
	}  
	
	private void buildPoliticalTopicsList()
	{
		
	}
	
	/**
	 * Checks the length of the supplied string. Returns false if the supplied String is empty or null,
	 * otherwise returns true. 
	 * @param currentInput
	 * @return A true or false based on the length of the supplied String.
	 */
	public boolean lengthChecker(String currentInput)
	{
		boolean hasLength = false;
		if(currentInput != null)
		{
			if(currentInput.length() > 0)
			{
				return true;
			}
		}
		
		return hasLength;
	}
	
	/**
	 * Checks if the supplied String matches the content area for this Chatbot instance.
	 * @param currentInput The supplied String to be checked.
	 * @return Whether it matches the content area.
	 */
	public boolean contentChecker(String currentInput)
	{
		boolean hasContent = false;
		
		if(currentInput.toLowerCase().contains(content.toLowerCase()))
		{
			hasContent= true;
		}
		
		return hasContent;
	}
	
	/**
	 * Checks if supplied String matches ANY of the topics in the politicalTopicsList. Returns
	 * true if it does find a match and false if it does not match.
	 * @param currentInput The supplied String to be checked.
	 * @return Whether the String is contained in the ArrayList.
	 */
	public boolean politicalTopicChecker(String currentInput)
	{
		String nextConversation = "Now politics";
		int randomtopic = (int) (Math.random() * 5);
		
		switch(randomtopic)
		{
		case 0:
			if(politicalTopicChecker(currentInput))
			{
				nextConversation = "Who do you want for president? Trump, Clinton, Biden, Carson, Rubio, Fiorina, or Sanders";
			}
			break;
		case 1:
			if(politicalTopicChecker(currentInput))
			{
				nextConversation = "oh yes. Why did you choose that person?";
			}break;
		case 2:
			if(politicalTopicChecker(currentInput))
			{
				nextConversation = "That is intresting that you that person for that reason. What do you like about them";
			}break;
		case 3:
			if(politicalTopicChecker(currentInput))
			{
				nextConversation = "That is not a reason to like them. Are you for democrat, republican, liberal, conservative";
			}break;
		case 4:
			if(politicalTopicChecker(currentInput))
			{
				nextConversation = "That is it for political stuff.";
			}
			default:
			{
				nextConversation = "Thats all folks!";
			}break;
			
		}
		return false;
	}
	
	
	/**
	 * Checks to see that the supplied String value is in the current memesList variable.
	 * @param currentInput The supplied String to be checked.
	 * @return Whether the supplied String is a recognized meme.
	 */
	public boolean memeChecker(String currentInput)
	{
		boolean hasMemesList = false;
		
		for(String meme : memesList)
		{
			if(currentInput.toLowerCase().contains(content.toLowerCase()))
			{
				hasMemesList = true;
			}
		}
		return hasMemesList;
	
	}
	
	public boolean quitChecker(String currentInput)
	{
		boolean quitCheck = false;
		
		return quitCheck;
	}

	public String processConversation(String currentInput)
	{
		String nextConversation = "what else would you like to talk about";
		int randomTopic = (int) (Math.random() * 5);
		
		switch (randomTopic)
		{
		case 0:
			if(contentChecker(currentInput))
			{
				nextConversation = "You talked about video games! That is cool. What else do you like?";
			}
			break;
		case 1:
			if(memeChecker(currentInput))
			{
				nextConversation = "That is a funny meme i like it alot! What food do you like?";
			}
			break;
		case 2:
			//Choose your own topic
			if(politicalTopicChecker(currentInput))
			{
				nextConversation = "Do you like StarBucks? You white girl";
			}
			break;
		case 3:
			//Random topic for chat here
			if(currentInput.length() > 23)
			{
				nextConversation = "Classic white girl. How old are you?";
			}
			break;
		case 4:
			nextConversation = "that is neat. Are you a boy or a girl?";
			break;
		default:
			nextConversation = "ahhhh. goodbye.";
				break;
		}
		
		return nextConversation;
	}
	/**
	 * Returns the username of this Chatbot instance.
	 * @return The username of the Chatbot.
	 */
	public String getUserName()
	{
		return userName;
	}
	
	/**
	 * Returns the content area for this Chatbot instance.
	 * @return The content area for this Chatbot instance.
	 */
	public String getContent()
	{
		return content;
	}
	
	/**
	 * Getter method for the memesList object.
	 * @return The reference to the meme list.
	 */
	public ArrayList<String> getMemesList()
	{
		return null;
	}
	
	/**
	 * Getter method for the politicalTopicList object.
	 * @return The reference to the political topic list.
	 */
	public ArrayList<String> getPoliticalTopicList()
	{
		return politicalTopicList;
	}
	
	/**
	 * Updates the content area for this Chatbot instance.
	 * @param content The updated value for the content area.
	 */
	public void setContent(String content)
	{
		
	}
}
