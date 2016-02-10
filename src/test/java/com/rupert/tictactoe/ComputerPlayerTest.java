package com.rupert.tictactoe;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ComputerPlayerTest {
    
	//		The Board	
	//		[0] [1] [2]
	//  	[3] [4] [5]
	//  	[6] [7] [8]
	
	
	@Rule
    public ExpectedException thrown= ExpectedException.none();
	
	ComputerPlayer cpu = new ComputerPlayer();
	
	@Test
	public void computerPlayerFirstMoveOnEmptyBoard() {
		//		The Board	
		//		[-] [-] [-]
		//  	[-] [-] [-]
		//  	[-] [-] [-]
	    int[] testBoard = new int[9];
	    assertEquals(0, cpu.move(testBoard)); 
	}

	@Test
	public void computerPlayerWinningMove() {
		//		The Board	
		//		[0] [0] [-]
		//  	[x] [x] [-]
		//  	[-] [-] [-]
		int[] testBoard = new int[9];
		testBoard[0] = 2; testBoard[1] = 2; 
		testBoard[3] = 1; testBoard[4] = 1;
		assertEquals(2, cpu.move(testBoard));
	}
	
}




















