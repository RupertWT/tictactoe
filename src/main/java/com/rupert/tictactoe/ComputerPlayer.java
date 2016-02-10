package com.rupert.tictactoe;

public class ComputerPlayer {

	public int move(int[] board) {
	
		
		for (int i = 0; i < 9; i++) {
			if (board[i] == 0) {
				return i;
			}
		}
		return 0;
		
//		if (board[0] == 2 && board[1] == 2) {
//			return 2;
//		}
//		
//		return 0;
		
	}
	
}
