package com.rupert.tictactoe;

// Setup and & UI

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TicTacToe {
	
	public JButton[] grid = new JButton[9];
	public ImageIcon xIcon, oIcon;
	
	public void play(int id) {
		
		System.out.println("Playing square " + id);
	}
	
	public void init_components() {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(3);
		frame.setVisible(true);
		frame.setResizable(true);
		frame.setSize(450,450);
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
	
		//frame.setSize(450,450);
		
	}
	
	public void init_icons() {
		
	}
	
    public static void main( String[] args ) {
    	TicTacToe t3 = new TicTacToe();
    	t3.init_components();
    	t3.init_icons();
    }
    
}
