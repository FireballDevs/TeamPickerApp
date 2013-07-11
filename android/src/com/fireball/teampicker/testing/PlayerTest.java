package com.fireball.teampicker.testing;

import com.fireball.teampicker.Player;

import junit.framework.TestCase;

public class PlayerTest extends TestCase {
	
	public void testPlayer(){
		Player t = new Player("Tom", 2);
		Player p = new Player("Patty", 1);
		
		assertEquals(p.getName(), "Patty");
		assertEquals(t.getPosition(), 2);
		
	}
	
	
	
	
}
