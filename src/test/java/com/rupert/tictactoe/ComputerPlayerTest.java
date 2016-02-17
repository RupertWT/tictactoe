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
	public void computerPlayerMiddleIfAvailable() {
//			The Board	
//			[-] [-] [-]
//		  	[-] [-] [-]
//		  	[-] [-] [-]
	    int[] testBoard = new int[9];
	    assertEquals(4, cpu.move(testBoard)); 
	}
	
	@Test
	public void computerPlayerNextFreeSlot() {
//			The Board	
//			[x] [-] [-]
//		  	[-] [o] [x]
//		  	[-] [-] [-]
	    int[] testBoard = new int[9];
	    testBoard[0] = 1;
	    testBoard[4] = 2; testBoard[5] = 1;
	    assertEquals(1, cpu.move(testBoard)); 
	}	

	@Test
	public void computerPlayerWinningMove1() {
//			The Board	
//			[o] [o] [-]
//		  	[x] [x] [-]
//		  	[x] [-] [-]
		int[] testBoard = new int[9];
		testBoard[0] = 2; testBoard[1] = 2; 
		testBoard[3] = 1; testBoard[4] = 1;
		testBoard[6] = 1;
		assertEquals(2, cpu.move(testBoard));
	}
	
	@Test
	public void computerPlayerWinningMove2() {
//			The Board	
//			[o] [x] [-]
//		  	[o] [x] [x]
//		  	[-] [-] [-]
		int[] testBoard = new int[9];
		testBoard[0] = 2; testBoard[1] = 1; 
		testBoard[3] = 2; testBoard[4] = 1; testBoard[5] = 1;
		assertEquals(6, cpu.move(testBoard));
	}

	@Test
	public void computerPlayerBlocksLosingMove() {
//			The Board	
//			[o] [x] [-]
//		  	[-] [x] [o]
//		  	[-] [-] [-]
		int[] testBoard = new int[9];
		testBoard[0] = 2; testBoard[1] = 1; 
		testBoard[4] = 1; testBoard[5] = 2;
		assertEquals(7, cpu.move(testBoard));
	}
		
}




















