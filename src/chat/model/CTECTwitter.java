package chat.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import twitter4j.*;
import chat.controller.ChatController;

import java.util.*;

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
						chatBotTwitter
								.updateStatus("Dylan Rockne #APCSRocks @CTECNow Thanks @cscheerleader & @codyhenrichsen!");
					} catch (TwitterException error)
					{
						baseController.handleErrors(error.getErrorMessage());
					}

			}

		public void loadTweets(String twitterHandle) throws TwitterException
			{
				statusList.clear();
				wordsList.clear();
				Paging statusPage = new Paging(1, 200);
				int page = 1;
				while (page <= 10)
					{
						statusPage.setPage(page);
						statusList.addAll(chatBotTwitter.getUserTimeline(
								twitterHandle, statusPage));
						page++;
					}
				for (Status currentStatus : statusList)
					{
						String[] tweetText = currentStatus.getText().split("");
						for (String word : tweetText)
							{
								wordsList.add(removePunctuation(word)
										.toLowerCase());
							}

					}
				removeCommonEnglishWords(wordsList);
				removeEmptyText();
			}

		private void removeCommonEnglishWords(List<String> wordsList)
			{
				String[] boringWords = importWordsToArray();

				for (int count = 0; count < wordsList.size(); count++)
					{
							{
								for (int removeSpot = 0; removeSpot < boringWords.length; removeSpot++)
									{
										if (wordsList
												.get(count)
												.equalsIgnoreCase(
														boringWords[removeSpot]))
											{
												wordsList.remove(count);
												count--;
												removeSpot = boringWords.length;
											}
									}
							}
					}
			}

		private void removeTwitterUsernamesFromList(List<String> wordList)
			{
				for (int wordCount = 0; wordCount < wordList.size(); wordCount++)
					{
						if (wordList.get(wordCount).length() >= 1
								& wordList.get(wordCount).charAt(0) == '@')
							{
								wordList.remove(wordCount);
								wordCount--;
							}
					}
			}

		public String topResults()
		{

				String tweetResults = "";
				int topWordLocation = 0;
				int topCount = 0;

				for (int index = 0; index < wordsList.size(); index++)
				{
					int wordUseCount = 1;
					for (int spot = index + 1; spot < wordsList.size(); index++)
						{
							if (wordsList.get(index).equals(wordsList.get(spot)))
								{
									wordUseCount++;
								}

								if (wordUseCount > topCount)
								{
									topCount = wordUseCount;
									topWordLocation = index;
								}
						}
				}
				tweetResults = "The top word in the tweets was "+ wordsList.get(topWordLocation) + " and it was used "+ topCount + " times!";
				return tweetResults;
		}

		private String[] importWordsToArray()
			{
				String[] boringWords;
				int wordCount = 0;
				try
					{
						Scanner wordFile = new Scanner(new File("commonWords.txt"));
						while (wordFile.hasNext())
							{
								wordCount++;
								wordFile.next();
							}
						wordFile.reset();
						boringWords = new String[wordCount];
						int boringWordCount = 0;
						while (wordFile.hasNext())
							{
								boringWords[boringWordCount] = wordFile.next();
								boringWordCount++;
							}
						wordFile.close();
					} catch (FileNotFoundException e)
					{
						baseController.handleErrors(e.getMessage());
						return new String[0];
					}
				return boringWords;
			}

		private void removeEmptyText()
			{
				for (int spot = 0; spot < wordsList.size(); spot++)
					{
						if (wordsList.get(spot).equals(""))
							{
								wordsList.remove(spot);
								spot--;
							}
					}
			}

		private String removePunctuation(String currentString)
			{
				String punctuation = ".,'/!:;\"(){}^<>-";

				String scrubbedString = "";
				for (int i = 0; i < currentString.length(); i++)
					{
						if (punctuation.indexOf(currentString.charAt(i)) == -1)
							{
								scrubbedString += currentString.charAt(i);
							}
					}
				return scrubbedString;

			}
		
		public String sampleInvestigation(String currentString)
		{
			String results = "";
			
			Query query = new Query("Dark Souls 3");
			query.setCount(100);
			query.setGeoCode(new GeoLocation(40.587521, -111.869178), 5, Query.MILES);
			query.setSince("2016-1-1");
			try
			{
				QueryResult result = chatBotTwitter.search(query);
				results += "Count : " + results.getTweets().size() + "\n";
				for(Status tweet : result.getTweets())
					{
						results.concat("@" + tweet.getUser().getName() + ": " + tweet.getText() + "\n");
					}
			}	
			catch(TwitterException error)
				{
					error.printStackTrace();
				}
				return results;

			}
	}
