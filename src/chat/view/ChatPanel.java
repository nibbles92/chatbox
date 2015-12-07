package chat.view;

import javax.swing.JPanel;

import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingUtilities;
import javax.swing.JTextArea;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import chat.controller.ChatController;

import java.awt.Color;

public class ChatPanel extends JPanel
{
	private ChatController baseController;
	private SpringLayout baseLayout;
	private JButton submitButton;
	private JTextArea chatArea;
	private JTextField typingField;
	private JLabel promptLabel;
	
	
	public ChatPanel(ChatController baseController)
	{
		this.baseController = baseController;
		baseLayout = new SpringLayout();
		chatArea = new JTextArea(10,30);
		typingField= new JTextField(30);
		promptLabel = new JLabel("");
		submitButton = new JButton("Enter");
		
		
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setBackground(Color.GREEN);
		this.add(chatArea);
		this.add(typingField);
		this.add(submitButton);
		this.add(promptLabel);
		typingField.setToolTipText("Type here");
		chatArea.setEnabled(false);
	}
	
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.WEST, submitButton, 6, SpringLayout.EAST, chatArea);
		baseLayout.putConstraint(SpringLayout.SOUTH, submitButton, -6, SpringLayout.NORTH, typingField);
		baseLayout.putConstraint(SpringLayout.EAST, submitButton, 0, SpringLayout.EAST, typingField);
		baseLayout.putConstraint(SpringLayout.WEST, chatArea, 0, SpringLayout.WEST, promptLabel);
		baseLayout.putConstraint(SpringLayout.EAST, chatArea, 305, SpringLayout.WEST, promptLabel);
		baseLayout.putConstraint(SpringLayout.NORTH, typingField, 195, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, typingField, 6, SpringLayout.EAST, chatArea);
		baseLayout.putConstraint(SpringLayout.EAST, typingField, 0, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, chatArea, 10, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatArea, -5, SpringLayout.SOUTH, this);
	}
	
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
	}

	public JTextField getTextField()
	{
		return typingField;
	}
	
}


