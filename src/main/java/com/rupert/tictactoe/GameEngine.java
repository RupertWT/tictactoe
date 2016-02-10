package com.rupert.tictactoe;

public class GameEngine {

	public boolean winCheck(int[] board) {
		
		//		The Board		
		//		[0] [1] [2]
		//		[3] [4] [5]
		//		[6] [7] [8]
		
		// Horizontal Wins
		if ( board[0] == board[1]  &&  board[1]  ==  board[2] && board[2] != 0) {
			return true;
		}
		if ( board[3] == board[4]  &&  board[4]  ==  board[5] && board[5] != 0) {
			return true;
		}
		if ( board[6] == board[7]  &&  board[7]  ==  board[8] && board[8] != 0) {
			return true;
		}
		
		// Vertical Wins
		if ( board[0] == board[3]  &&  board[3]  ==  board[6] && board[6] != 0) {
			return true;
		}
		if ( board[1] == board[4]  &&  board[4]  ==  board[7] && board[7] != 0) {
			return true;
		}
		if ( board[2] == board[5]  &&  board[5]  ==  board[8] && board[8] != 0) {
			return true;
		}
		
		// Diagonal Wins
		if ( board[0] == board[4]  &&  board[4]  ==  board[8] && board[8] != 0) {
			return true;
		}
		if ( board[2] == board[4]  &&  board[4]  ==  board[6] && board[6] != 0) {
			return true;
		}
				
		return false;
	}

}
	

