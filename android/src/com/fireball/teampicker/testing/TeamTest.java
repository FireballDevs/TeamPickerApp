package com.fireball.teampicker.testing;

import com.fireball.teampicker.Team;
import com.fireball.teampicker.Player;

import junit.framework.TestCase;

public class TeamTest extends TestCase {
	
	
	public void testTeamCreation() {
		
		Player tom = new Player("Tom", 1);
		
		Player patty = new Player("Patty", 1);
		
		Player john = new Player("John", 2);
		
		Player ian = new Player("Ian", 3);
		
		Player[] player_list = new Player[] {patty,john, ian};
		
		Team t = new Team("Team t", 1, tom);
		
		Team p = new Team("Team p", 2, patty);
		
		Team spec = new Team("Team mul", 3, player_list);
		
		assertEquals(t.getPlayers()[0], tom);
		
		assertEquals(p.getTeam_number(), 2);
		
		assertEquals(p.getName(), "Team p");
		
		assertEquals(spec.getPlayers()[2].getName(), ian.getName());
		
	}
	
}
