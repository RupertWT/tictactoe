package com.rupert.tictactoe;

public class ComputerPlayer {

	public int move(int[] board) {
	
//		Check for winning moves
		for (int i = 0; i < 9; i++) {
			if (board[i] == 0) {
				board[i] = 2;
				GameEngine engine = new GameEngine();
				if (engine.winCheck(board) == true) {
					return i;
				}	
			board[i] = 0;	
			}
		}
		
// 		Check for losing moves & block
		for (int i = 0; i < 9; i++) {
			if (board[i] == 0) {
				board[i] = 1;
				GameEngine engine = new GameEngine();
				if (engine.winCheck(board) == true) {
					return i;
				}	
			board[i] = 0;	
			}
		}
	
//		Take the middle
		if (board[4] == 0) {
			return 4;
		}
		
//		Move to next available slot
		for (int i = 0; i < 9; i++) {
			if (board[i] == 0) {
				return i;
			}
		}
		return 0;		
	}
	
}
