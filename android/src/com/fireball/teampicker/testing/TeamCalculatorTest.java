package com.fireball.teampicker.testing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Dictionary;

import com.fireball.teampicker.Player;
import com.fireball.teampicker.Team;
import com.fireball.teampicker.TeamCalculator;

import junit.framework.TestCase;

/**
 * Tests the TeamCalculator class functionality
 */
public class TeamCalculatorTest extends TestCase {

	/**
	 * Tests adding just one player to one team
	 */
	public void testOnePlayerTeam() {
		Player p = new Player("Loner", -1);
		String[] teamNames = { "Only Team" };
		Player[] players = { p };
		Team[] teams = TeamCalculator.Randomize(teamNames, players);

		assertEquals(1, teams.length);
		assertEquals(1, teams[0].getPlayers().size());
		assertEquals(p, teams[0].getPlayers().get(0));
	}

	/**
	 * Tests distributing 50 players to two teams
	 */
	public void testNormalTeams() {
		String[] teamNames = { "TeamOne", "TeamTwo" };

		final int players = 50;
		Player[] playerArray = new Player[players];
		for (int index = 0; index < players; index++) {
			playerArray[index] = new Player("Player"
					+ String.format("%02d", index), index);
		}
		
		
		TeamCalculator.setSeed(55);
		Team[] teams = TeamCalculator.Randomize(teamNames, playerArray);

		assertEquals(2, teams.length);
		assertEquals(25, teams[0].getPlayers().size());
		assertEquals(25, teams[1].getPlayers().size());

		ArrayList<String> resultTeam1Names = new ArrayList<String>();
		ArrayList<String> resultTeam2Names = new ArrayList<String>();

		// team 1
		for (Player p : teams[0].getPlayers()) {
			resultTeam1Names.add(p.getName());
		}
		Collections.sort(resultTeam1Names);

		assertEquals("Player03", resultTeam1Names.get(0));
		assertEquals("Player07", resultTeam1Names.get(1));
		assertEquals("Player08", resultTeam1Names.get(2));
		assertEquals("Player09", resultTeam1Names.get(3));
		assertEquals("Player10", resultTeam1Names.get(4));
		assertEquals("Player14", resultTeam1Names.get(5));
		assertEquals("Player17", resultTeam1Names.get(6));
		assertEquals("Player18", resultTeam1Names.get(7));
		assertEquals("Player20", resultTeam1Names.get(8));
		assertEquals("Player22", resultTeam1Names.get(9));
		assertEquals("Player23", resultTeam1Names.get(10));
		assertEquals("Player24", resultTeam1Names.get(11));
		assertEquals("Player25", resultTeam1Names.get(12));
		assertEquals("Player28", resultTeam1Names.get(13));
		assertEquals("Player32", resultTeam1Names.get(14));
		assertEquals("Player33", resultTeam1Names.get(15));
		assertEquals("Player35", resultTeam1Names.get(16));
		assertEquals("Player36", resultTeam1Names.get(17));
		assertEquals("Player37", resultTeam1Names.get(18));
		assertEquals("Player38", resultTeam1Names.get(19));
		assertEquals("Player40", resultTeam1Names.get(20));
		assertEquals("Player41", resultTeam1Names.get(21));
		assertEquals("Player42", resultTeam1Names.get(22));
		assertEquals("Player45", resultTeam1Names.get(23));
		assertEquals("Player49", resultTeam1Names.get(24));

		// team 2
		for (Player p : teams[1].getPlayers()) {
			resultTeam2Names.add(p.getName());
		}
		Collections.sort(resultTeam2Names);

		assertEquals("Player00", resultTeam2Names.get(0));
		assertEquals("Player01", resultTeam2Names.get(1));
		assertEquals("Player02", resultTeam2Names.get(2));
		assertEquals("Player04", resultTeam2Names.get(3));
		assertEquals("Player05", resultTeam2Names.get(4));
		assertEquals("Player06", resultTeam2Names.get(5));
		assertEquals("Player11", resultTeam2Names.get(6));
		assertEquals("Player12", resultTeam2Names.get(7));
		assertEquals("Player13", resultTeam2Names.get(8));
		assertEquals("Player15", resultTeam2Names.get(9));
		assertEquals("Player16", resultTeam2Names.get(10));
		assertEquals("Player19", resultTeam2Names.get(11));
		assertEquals("Player21", resultTeam2Names.get(12));
		assertEquals("Player26", resultTeam2Names.get(13));
		assertEquals("Player27", resultTeam2Names.get(14));
		assertEquals("Player29", resultTeam2Names.get(15));
		assertEquals("Player30", resultTeam2Names.get(16));
		assertEquals("Player31", resultTeam2Names.get(17));
		assertEquals("Player34", resultTeam2Names.get(18));
		assertEquals("Player39", resultTeam2Names.get(19));
		assertEquals("Player43", resultTeam2Names.get(20));
		assertEquals("Player44", resultTeam2Names.get(21));
		assertEquals("Player46", resultTeam2Names.get(22));
		assertEquals("Player47", resultTeam2Names.get(23));
		assertEquals("Player48", resultTeam2Names.get(24));
	}
	
	/**
	 * Test that the Player to Team dictionary will container the correct values
	 * The key is a player object, and the value will be the team object.
	 * 
	 */
	public void testPlayerToTeamDict() {
		String[] teamNames = { "TeamOne", "TeamTwo" };

		final int players = 50;
		Player[] playerArray = new Player[players];
		for (int index = 0; index < players; index++) {
			playerArray[index] = new Player("Player"
					+ String.format("%02d", index), index);
		}
		
		TeamCalculator.setSeed(70);
		
		//The player_to_team_dict is set within this method!
		Team[] teams = TeamCalculator.Randomize(teamNames, playerArray);
		
		//Declare the dictionary so we have access to it
		Dictionary<Player, Team> player_dict = TeamCalculator.player_to_team_dict;
		assertEquals(2, teams.length);
		assertEquals(25, teams[0].getPlayers().size());
		assertEquals(25, teams[1].getPlayers().size());

		ArrayList<String> resultTeam1Names = new ArrayList<String>();
		ArrayList<String> resultTeam2Names = new ArrayList<String>();

		// team 1
		for (Player p : teams[0].getPlayers()) {
			//The return value of the dictionary is the team object, get the name to see what team it was.
			assertEquals("TeamOne", player_dict.get(p).getName());
		}
		Collections.sort(resultTeam1Names);
		
		// team 2
		for (Player p : teams[1].getPlayers()) {
			assertEquals("TeamTwo", player_dict.get(p).getName());
		}
		Collections.sort(resultTeam2Names);
		
		//Check to make sure that the dictionary is the same size as all the teams.
		assertEquals(50,player_dict.size());
		
	}
}
