package com.fireball.teampicker.testing;

import java.util.ArrayList;

import com.fireball.teampicker.Team;
import com.fireball.teampicker.Player;

import junit.framework.TestCase;

public class TeamTest extends TestCase {

	public void testTeamCreation() {

		Player tom = new Player("Tom", 1);
		Player patty = new Player("Patty", 1);
		Player john = new Player("John", 2);
		Player ian = new Player("Ian", 3);

		ArrayList<Player> playerList = new ArrayList<Player>();
		playerList.add(patty);
		playerList.add(john);
		playerList.add(ian);

		Team t = new Team("Team t", 1, tom);

		Team p = new Team("Team p", 2, patty);

		Team spec = new Team("Team mul", 3, playerList);

		assertEquals(t.getPlayers().get(0), tom);

		assertEquals(p.getTeamNumber(), 2);

		assertEquals(p.getName(), "Team p");

		assertEquals(spec.getPlayers().get(2).getName(), ian.getName());
	}
}