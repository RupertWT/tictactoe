package com.rupert.tictactoe;

public class ComputerPlayer {

	public int move(int[] board) {
		
		if (board[0] == 2 && board[1] == 2) {
			return 2;
		}
		
		return 0;
	}
	
}
