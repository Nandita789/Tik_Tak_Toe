package tic_tac_toe_game;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class TikTakToeGame implements ActionListener
{
	int i;
	JButton[] button;
	JFrame frame;
	JPanel buttonPanel, scorePanel, mainPanel;
	JLabel firstParticipant, secondParticipant, firstScore, secondScore;
	String str, firstName, secondName, fP, sP;
	int count = 0;
	boolean flagWin = false, firstTime = false;
	public void startGame()
	{
		frame = new JFrame("Tik Tak Toe Game");

		mainPanel = new JPanel();
		buttonPanel = new JPanel();
		scorePanel = new JPanel();

		firstParticipant = new JLabel(firstName+"("+fP+")");
		secondParticipant = new JLabel(secondName+"("+sP+")");
		firstScore = new JLabel("0");
		secondScore = new JLabel("0");
		
		if(count == 0) {
			firstParticipant.setForeground(new Color(255, 128, 0));
			secondParticipant.setForeground(Color.BLACK);
		} else if(count == 1) {
			secondParticipant.setForeground(new Color(255, 128, 0));			
			firstParticipant.setForeground(Color.BLACK);
		}
		
		scorePanel.add(firstParticipant);
		scorePanel.add(secondParticipant);
		scorePanel.add(firstScore);
		scorePanel.add(secondScore);		

		secondParticipant.setFont(new Font("Arial", Font.PLAIN, 20));
		secondScore.setFont(new Font("Arial", Font.PLAIN, 20));
		firstParticipant.setFont(new Font("Arial", Font.PLAIN, 20));
		firstScore.setFont(new Font("Arial", Font.PLAIN, 20));
		
		secondParticipant.setHorizontalAlignment(SwingConstants.CENTER);
		secondScore.setHorizontalAlignment(SwingConstants.CENTER);
		firstParticipant.setHorizontalAlignment(SwingConstants.CENTER);
		firstScore.setHorizontalAlignment(SwingConstants.CENTER);
		
		scorePanel.setLayout(new GridLayout(2, 2));
		buttonPanel.setLayout(new GridLayout(3, 3));
		
		scorePanel.setBackground(new Color(213, 247, 242));
		scorePanel.setBounds(0, 400, 495, 70);
		buttonPanel.setBounds(0, 0, 495, 400);
		mainPanel.setLayout(null);
		
		mainPanel.setBackground(Color.WHITE);
		mainPanel.add(scorePanel);
		mainPanel.add(buttonPanel);
		
		frame.add(mainPanel);
		frame.setSize(500, 500);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);

		button = new JButton[9];
		for( i = 0; i<button.length;i++)
		{
			button[i] = new JButton();
			button[i].setFocusable(false);
			button[i].setFont(new Font("Franklin Gothic", Font.PLAIN, 20));
			button[i].addActionListener(this);   
			buttonPanel.add(button[i]);
		}
		
		frame.setVisible(true);
	}
	
	public static void main(String[] args)
	{
		try
		{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e) {e.printStackTrace();}
		new TikTakToeGame().chooseUser();
	}		

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(firstTime == false) {
			count = count+1;
			if(count%2 == 0) {
				str="0";				
			} else {
				str="X";				
			}
		} else {
			if(count == 0) {
				str="0"; firstTime = false;			
			}
			else if(count == 1) {
				str="X"; firstTime = false;										
			}
		}
		
		for(i=0;i<button.length;i++) 
		{
			if(e.getSource()==button[i]) 
			{
				button[i].setText(str);
				button[i].setEnabled(false);	
				if(str == "0") {
					firstParticipant.setForeground(Color.BLACK);
					secondParticipant.setForeground(new Color(255, 128, 0));					
				} else if(str == "X") {
					firstParticipant.setForeground(new Color(255, 128, 0));
					secondParticipant.setForeground(Color.BLACK);
				}
			}
		}
		winningPossibilities();
	}
	
	void winningPossibilities() 
	{
		if( (button[0].getText()=="X" && button[1].getText()=="X" && button[2].getText()=="X") ||
				(button[3].getText()=="X" && button[4].getText()=="X" && button[5].getText()=="X") || (button[6].getText()=="X" && button[7].getText()=="X" && button[8].getText()=="X"))
		{
			flagWin=true;
		}
		else if( (button[0].getText()=="0" && button[1].getText()=="0" && button[2].getText()=="0") || 
					(button[3].getText()=="0" && button[4].getText()=="0" && button[5].getText()=="0") || (button[6].getText()=="0" && button[7].getText()=="0" && button[8].getText()=="0"))
		{
			flagWin=true;
		}
		else if( (button[0].getText()=="X" && button[3].getText()=="X" && button[6].getText()=="X") || 
					(button[1].getText()=="X" && button[4].getText()=="X" && button[7].getText()=="X") || (button[2].getText()=="X" && button[5].getText()=="X" && button[8].getText()=="X"))
		{
			flagWin=true;
		}
		else if( (button[0].getText()=="0" && button[3].getText()=="0" && button[6].getText()=="0") || 
					(button[1].getText()=="0" && button[4].getText()=="0" && button[7].getText()=="0") || (button[2].getText()=="0" && button[5].getText()=="0" && button[8].getText()=="0"))
		{
			flagWin=true;
		}
		else if( (button[0].getText()=="X" && button[4].getText()=="X" && button[8].getText()=="X") || 
					(button[2].getText()=="X" && button[4].getText()=="X" && button[6].getText()=="X"))
		{
			flagWin=true;
		}
		else if( (button[0].getText()=="0" && button[4].getText()=="0" && button[8].getText()=="0") || 
					(button[2].getText()=="0" && button[4].getText()=="0" && button[6].getText()=="0"))
		{
			flagWin=true;
		}
		else
		{
			flagWin=false;
		}
		
		whoWins();
		
	}

	void whoWins() 
	{
		if(flagWin==true)
		{
			JOptionPane.showMessageDialog(frame, str+" wins");
			if(str.equals(fP)) {
				int i = Integer.parseInt(firstScore.getText().toString());
				firstScore.setText(String.valueOf(++i));
			} else if(str.equals(sP)) {
				int i = Integer.parseInt(secondScore.getText().toString());
				secondScore.setText(String.valueOf(++i));
			}
			restartGame();
		}
		else if(flagWin==false && count == 9)
		{ 
			JOptionPane.showMessageDialog(frame, "Game Draw");
			restartGame();
		}	
	}
	
	void restartGame() 
	{
		int j = JOptionPane.showConfirmDialog(frame, "Do you want to play again ?");
		if(j==0) 
		{
			str = "";
			count=0;
			flagWin = false;
			for(int i=0; i<button.length; i++)
			{
				button[i].setText("");
				button[i].setEnabled(true);				
			}
		}
		else if(j==1)
		{
			System.exit(0);
		}
	}
	
	boolean chooseUser()
	{
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		
		JLabel firstParticipant = new JLabel("First Participant");
		JLabel secondParticipant = new JLabel("Second Participant");
		JTextField first = new JTextField(10);
		JTextField second = new JTextField(10);
				
		JButton submit = new JButton("Start");
		JButton cancel = new JButton("Cancel");
		
		JRadioButton xX = new JRadioButton("X");
		xX.setActionCommand("X");
		JRadioButton y0 = new JRadioButton("0");
		y0.setActionCommand("0");
		ButtonGroup group = new ButtonGroup();
		group.add(xX); group.add(y0);
		
		submit.setFocusable(false);
		cancel.setFocusable(false);
		xX.setFocusable(false);
		y0.setFocusable(false);
		
		xX.addActionListener(new ActionListener()  
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				count = 1;
				firstTime = true;
			}
		});
		
		y0.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				count = 0;
				firstTime = true;
			}
		});
				
		submit.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if(first.getText().trim().equals("") || second.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(frame, "Please enter both participant !");
				} else if(!xX.isSelected() && !y0.isSelected()) {
					JOptionPane.showMessageDialog(frame, "Please choose Nought or Cross !");					
				} 
				else
				{	
					frame.dispose();
					String str = group.getSelection().getActionCommand();
					whoChooseXand0(first, second, str);
					firstName = first.getText().trim();
					secondName = second.getText().trim();
					startGame();
				}
			}
		});
		
		cancel.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		firstParticipant.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 17));
		secondParticipant.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 17));
		first.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 17));
		second.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 17));
		xX.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 17));
		y0.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 17));
		
		xX.setVerticalTextPosition(SwingConstants.CENTER);
		y0.setVerticalTextPosition(SwingConstants.CENTER);
		
		firstParticipant.setBounds(40, 39, 120, 25);
		first.setBounds(205, 40, 150, 22);
		secondParticipant.setBounds(40, 70, 140, 25);
		second.setBounds(205, 70, 150, 22);
		
		xX.setBounds(160, 110, 50, 20);
		y0.setBounds(220, 110, 50, 20);
		
		submit.setBounds(80, 145, 100, 25);
		cancel.setBounds(220, 145, 100, 25);
		
		panel.add(firstParticipant);
		panel.add(first);
		panel.add(secondParticipant);
		panel.add(second);
		
		panel.add(submit);
		panel.add(cancel);
		
		panel.add(xX);
		panel.add(y0);
		
		panel.setLayout(null);
		
		frame.add(panel);
		frame.setUndecorated(true);
		frame.setSize(400, 200);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		return false;
	}
	
	private void whoChooseXand0(JTextField first, JTextField second, String str)
	{
		if(first.isFocusOwner() && str.equals("X")) {
			// First Participant choose X and second Participant choose 0
			fP = "X"; sP = "0";
		} else if(first.isFocusOwner() && str.equals("0")) {
			// First Participant choose 0 and second Participant choose X			
			fP = "0"; sP = "X";
		}
	
		else if(second.isFocusOwner() && str.equals("X")) {
			// Second Participant choose X and first Participant choose 0
			sP = "X"; fP = "0";
		} else if(second.isFocusOwner() && str.equals("0")) {
			// Second Participant choose 0 and first Participant choose X	
			sP = "0"; fP = "X";
		}
	}
}