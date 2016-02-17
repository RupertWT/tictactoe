package com.rupert.tictactoe;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

	public class GameEngineTest {
	    
//		The Board	
//		[0] [1] [2]
//		[3] [4] [5]
//		[6] [7] [8]
		
		
		@Rule
	    public ExpectedException thrown= ExpectedException.none();
		
		GameEngine engine = new GameEngine();
		
		@Test
		public void player1InPositions01DoesntWin() {
		    int[] testBoard = new int[9];
		    testBoard[0] = 1;
		    testBoard[1] = 1;
		    testBoard[2] = 0;
			assertEquals(false, engine.winCheck(testBoard)); 
		}
		
		@Test
		public void player1InPositions012Wins() {
		    int[] testBoard = new int[9];
		    testBoard[0] = 1;
		    testBoard[1] = 1;
		    testBoard[2] = 1;
			assertEquals(true, engine.winCheck(testBoard)); 
		}
	 
		@Test
		public void player1InPositions345Wins() {
		    int[] testBoard = new int[9];
		    testBoard[3] = 2;
		    testBoard[4] = 2;
		    testBoard[5] = 2;
			assertEquals(true, engine.winCheck(testBoard)); 
		}
		
		@Test
		public void player1InPositions678Wins() {
		    int[] testBoard = new int[9];
		    testBoard[6] = 1;
		    testBoard[7] = 1;
		    testBoard[8] = 1;
			assertEquals(true, engine.winCheck(testBoard)); 
		}
		
		@Test
		public void player1InPositions036Wins() {
		    int[] testBoard = new int[9];
		    testBoard[0] = 2;
		    testBoard[3] = 2;
		    testBoard[6] = 2;
			assertEquals(true, engine.winCheck(testBoard)); 
		}
	 
		@Test
		public void player1InPositions147Wins() {
		    int[] testBoard = new int[9];
		    testBoard[1] = 1;
		    testBoard[4] = 1;
		    testBoard[7] = 1;
			assertEquals(true, engine.winCheck(testBoard)); 
		}
		
		@Test
		public void player1InPositions258Wins() {
		    int[] testBoard = new int[9];
		    testBoard[2] = 2;
		    testBoard[5] = 2;
		    testBoard[8] = 2;
			assertEquals(true, engine.winCheck(testBoard)); 
		}
		
		@Test
		public void player1InPositions048Wins() {
		    int[] testBoard = new int[9];
		    testBoard[0] = 1;
		    testBoard[4] = 1;
		    testBoard[8] = 1;
			assertEquals(true, engine.winCheck(testBoard)); 
		}
		
		@Test
		public void player1InPositions246Wins() {
		    int[] testBoard = new int[9];
		    testBoard[2] = 2;
		    testBoard[4] = 2;
		    testBoard[6] = 2;
			assertEquals(true, engine.winCheck(testBoard)); 
		}
	
	}




















