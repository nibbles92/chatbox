package chat.view;

import javax.swing.JPanel;

import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpringLayout;
import javax.swing.SwingUtilities;
import javax.swing.JTextArea;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import chat.controller.ChatController;

import java.awt.Color;
/**
 * calls the buttons and sets
 * @author droc6148
 *
 */
public class ChatPanel extends JPanel
{
	private ChatController baseController;
	private JScrollPane textPane;
	private SpringLayout baseLayout;
	private JButton submitButton;
	private JTextArea chatArea;
	private JTextField typingField;
	private JLabel promptLabel;
	private JButton tweetButton;
	private JButton analyzeTwitterButton;
	
	
	/**
	 * sets the layout
	 * @param baseController
	 */
	public ChatPanel(ChatController baseController)
	{
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		chatArea = new JTextArea(10,30);
		typingField= new JTextField(30);
		promptLabel = new JLabel("");
		submitButton = new JButton("Enter");
		analyzeTwitterButton = new JButton("");
		tweetButton = new JButton("Tweet");
	
		
		setupChatPane();
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupChatPane()
	{
		chatArea.setLineWrap(true);
		chatArea.setWrapStyleWord(true);
		chatArea.setEnabled(false);
		chatArea.setEditable(false);
		textPane = new JScrollPane(chatArea);
	

		
	}
	/**
	 * this sets up the panel
	 */
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setBackground(Color.GREEN);
		//this.add(chatArea);
		this.add(textPane);
		this.add(typingField);
		this.add(submitButton);
		this.add(promptLabel);
		this.add(tweetButton);
		this.add(analyzeTwitterButton);
		typingField.setToolTipText("Type here");
		chatArea.setEnabled(false);
	}
	/**
	 * code that was added when moving buttons around
	 */
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.SOUTH, chatArea, -5, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, chatArea, 10, SpringLayout.NORTH, promptLabel);
		baseLayout.putConstraint(SpringLayout.WEST, chatArea, 10, SpringLayout.WEST, promptLabel);
		baseLayout.putConstraint(SpringLayout.EAST, chatArea, -6, SpringLayout.WEST, typingField);
		baseLayout.putConstraint(SpringLayout.NORTH, textPane, 20, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, textPane, 20, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, textPane, -200, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, textPane, -20, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, tweetButton, -10, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, submitButton, 6, SpringLayout.SOUTH, tweetButton);
		baseLayout.putConstraint(SpringLayout.EAST, submitButton, 0, SpringLayout.EAST, tweetButton);
		baseLayout.putConstraint(SpringLayout.NORTH, tweetButton, 65, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, typingField, 6, SpringLayout.EAST, textPane);
		baseLayout.putConstraint(SpringLayout.WEST, tweetButton, 17, SpringLayout.EAST, textPane);
		baseLayout.putConstraint(SpringLayout.WEST, submitButton, 17, SpringLayout.EAST, textPane);
		textPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	    textPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
	    baseLayout.putConstraint(SpringLayout.NORTH, typingField, 6, SpringLayout.SOUTH, submitButton);
		baseLayout.putConstraint(SpringLayout.EAST, typingField, 0, SpringLayout.EAST, this);
	}
	/**
	 * sets listener
	 */
	private void setupListeners()
	{
		submitButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				//get chatbots answer
				//display answer
				//clear user field
				String userText = typingField.getText(); //Grab user text
				String response = baseController.fromUserToChatbot(userText);//send the text to the controller
				chatArea.append("\nUser:" + userText);//display users text
				chatArea.append("\nChatbot:" + response);
				typingField.setText("");
			}
		});
		
		tweetButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				baseController.sendTweet("YAY");
			}
		});
		
		analyzeTwitterButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent click)
				{
					String user = typingField.getText();
					String results = baseController.analyze(user);
					chatArea.setText(results);
				}
			});
	}
	
	
	
	/**
	 * 
 	 * @returns text field
 	 */
	public JTextField getTextField()
	{
		return typingField;
	}
	
}


