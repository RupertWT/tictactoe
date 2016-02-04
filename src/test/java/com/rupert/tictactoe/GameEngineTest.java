package com.rupert.tictactoe;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.rupert.tictactoe.GameEngine;

public class GameEngineTest {
    
	@Rule
    public ExpectedException thrown= ExpectedException.none();
	
	GameEngine engine = new GameEngine();
	
	@Test
	public void zeroConverts0() {
		assertEquals(0, engine.check(0)); 
	}
	
}
