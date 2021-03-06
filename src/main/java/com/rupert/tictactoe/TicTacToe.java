package com.rupert.tictactoe;

// Start new game and initialise board

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class TicTacToe {
		
	public JButton[] grid = new JButton[9];
	public ImageIcon xIcon, oIcon;
	public int[] board = new int[9];
	public boolean won = false;
	public int currentPlayer = 1;
	public static boolean cpu = true;
		
	
	
//	Starts new game
	public static void main( String[] args ) {
    	TicTacToe t3 = new TicTacToe();   	
    	t3.cpuCheck();
    	t3.init_components();
    	t3.init_icons();  	
    }
   
    
    
//	Ask if player wants to play against the computer
	public void cpuCheck() {
    	if(JOptionPane.showConfirmDialog(new JFrame("Play the computer?"), "Would you like to play against the computer?") == JOptionPane.YES_OPTION) {
			cpu = true;
		} else {
			cpu = false;
		}
    }
    
    
    
//	Initialise frame & buttons, listen for button clicks
	public void init_components() {
 		JFrame frame = new JFrame();
 		frame.setDefaultCloseOperation(3);
 		frame.setVisible(true);
 		frame.setResizable(true);
// 		frame.setSize(450,450);
 		JPanel panel = new JPanel();
 		frame.setContentPane(panel);
 		panel.setLayout(new GridLayout(3,3,0,0));
 				
 		panel.addComponentListener(new ComponentListener() {
 			public void componentResized(ComponentEvent e) {
 				
 				init_icons();
 			}
 			public void componentMoved(ComponentEvent e) {	
 			}
 			public void componentShown(ComponentEvent e) {	
 			}
 			public void componentHidden(ComponentEvent e) {
 			}		
 		});
 		
 		for (int i = 0; i < 9; i++){
 			final int pos = i;
 			
 			grid[i] = new JButton();
 			grid[i].addActionListener(new ActionListener() {
 				int id = pos;
 				
 				public void actionPerformed(ActionEvent e) {
 					play(id);
 				}
 				
 			});	
 			
 			panel.add(grid[i]);		
 		}	
 		frame.setSize(450,450);		
 	}
    
 	
 	
//	Initialise Icons, images in res file, images scaled to button size
	public void init_icons() {
		
		try{
			Image x = ImageIO.read(TicTacToe.class.getResource("/x.png"));
			Image o = ImageIO.read(TicTacToe.class.getResource("/o.png"));
			
			xIcon = new ImageIcon(x.getScaledInstance(grid[0].getWidth(), grid[0].getHeight(),Image.SCALE_SMOOTH));
			oIcon = new ImageIcon(o.getScaledInstance(grid[0].getWidth(), grid[0].getHeight(),Image.SCALE_SMOOTH));
			
			for(int i=0; i<9; i++) {
				if (grid[i].getIcon() != null) 
						grid[i].setIcon(board[i] == 1 ? xIcon : oIcon);
			}
			
		}catch(IOException ex) {
			ex.printStackTrace();
		}
	}
    
    	
	
//	Play action, initiates attemptChange, checks for winning move then updates player
	public void play(int square) {
		
		if(attemptChange(square)) {
			System.out.println("Player " + currentPlayer + " playing square " + square);
			board[square] = currentPlayer;
			grid[square].setIcon(currentPlayer==1? xIcon : oIcon);
			currentPlayer = (currentPlayer == 1) ? 2 : 1;
			checkWin(square);
		} 
		
		if(cpu == true && currentPlayer == 2) {
			computerPlay(board);
		}	
	}
	
	
	
//	If CPU == true & it's player 2's turn then use AI to find O's move
	public void computerPlay(int[] cpuBoard) {
		
		ComputerPlayer cpuPlayer = new ComputerPlayer();
		int square = cpuPlayer.move(cpuBoard);
		
		System.out.println("Computer playing square " + square);	
		board[square] = 2;
		grid[square].setIcon(oIcon);
		checkWin(square);
		currentPlayer = 1;		
	}
	
	
	
//	Checks if position already full, and if not it fills position with current player's icon
	public boolean attemptChange(int square) {
		if (board[square] != 0) {
			return false;
		}
		return true;
	}
	
	
	
//	Checks for a win, if no win and spaces left then continue, else draw
	public void checkWin(int square) {
		
		GameEngine engine = new GameEngine();
		
		if (engine.winCheck(board) == true) {
			win(square);
		}		
		
		for (int i = 0; i < board.length; i++) {
			if (board[i] == 0) {
				return;
			}
		}
		
		draw();		
	}
	
	
	
//	Win scenario
	public void win(int square) {
		won = true;
		
		String winner = board[square] == 1 ? "X" : "O";
		
		if(JOptionPane.showConfirmDialog(new JFrame("Winner! Congratulations " + winner), "Player " + winner + " has won! Would you like to play again?") == JOptionPane.YES_OPTION) {
			reset();
		} else {
			System.exit(0);
		}
	}

	
	
//	Draw scenario
	public void draw() {
		if(JOptionPane.showConfirmDialog(new JFrame("It's a Draw!"), "It's a draw! Would you like to play again?") == JOptionPane.YES_OPTION) {
			reset();
		} else {
			System.exit(0);
		}
	}

	
	
//	Reset board
	public void reset() {
		won = false;
		currentPlayer = 1;
		
		for (int i = 0; i < 9; i++) {
			board[i] = 0;
			grid[i].setIcon(null);
		}
		
		cpuCheck();
	}
	

}
