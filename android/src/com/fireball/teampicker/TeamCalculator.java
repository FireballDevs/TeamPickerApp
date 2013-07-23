/**
 * 
 */
package com.fireball.teampicker;

import java.util.ArrayList;
import java.util.Random;

/**
 * Team Calculator contains methods for manipulating the Team Object (an array
 * of players)
 */
public class TeamCalculator {

	private static Random m_rand = new Random(System.currentTimeMillis());

	/**
	 * Randomly creates teams with the names specified by placing an array of
	 * players into teams by name
	 * 
	 * @param teamNames
	 *            array of team names
	 * @param players
	 *            array of player objects
	 * @return array of two or more randomized teams
	 */
	public static Team[] Randomize(String[] teamNames, Player[] players) {

		// turn the array of players into a list so we can do efficient
		// randomization without lots of reallocation
		ArrayList<Player> playerList = new ArrayList<Player>(players.length);
		for (Player p : players) {
			playerList.add(p);
		}
		
		final int numTeams = teamNames.length;
		int teamIndex = 0;
		
		//create the array of teams from the array of names
		Team[] randomizedTeams = new Team[numTeams];
		for(; teamIndex < numTeams; teamIndex++)
		{
			randomizedTeams[teamIndex] = new Team(teamNames[teamIndex], teamIndex);
		}
		
		//reset team index
		teamIndex = 0;
		
		//distribute all players in the list
		while (playerList.size() > 0)
		{
			//get a random index in the list
			int randomIndex = m_rand.nextInt(playerList.size());
			Player p = playerList.remove(randomIndex);
			randomizedTeams[teamIndex++%numTeams].addPlayer(p);
		}

		return randomizedTeams;
	}
	
	/**
	 * Creates a new random number generator with the specified seed.
	 * Mainly to be used for testing.
	 * @param seed
	 */
	public static void setSeed(int seed)
	{
		m_rand = new Random(seed);
	}
}
