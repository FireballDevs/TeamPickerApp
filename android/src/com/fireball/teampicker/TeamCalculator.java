package com.fireball.teampicker;


import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Random;
import com.fireball.teampicker.Team;


/**
 * Team Calculator contains methods for manipulating the Team Object (an array
 * of players)
 */
public class TeamCalculator {
	
	private static Random m_rand = new Random(System.currentTimeMillis());
	
	private static final String NULL_TEAM = "NULL_TEAM";
	
	private static Dictionary<Player, Team> player_to_team_dict = new Hashtable<Player, Team>();
	

	public static Dictionary<Player, Team> getPlayer_to_team_dict() {
		return player_to_team_dict;
	}

	/**
	 * Randomly creates teams with the names specified by placing an array of
	 * players into teams by name. NOTE: This method will remove the older 
	 * players_to_team_dict and replace it with the new team-player setup, 
	 * since each player will be randomized.
	 * 
	 * @param teamNames
	 *            array of team names
	 * @param players
	 *            array of player objects
	 * @return array of two or more randomized teams
	 */
	public static Team[] Randomize(String[] teamNames, Player[] players) {
		
		/*
		 * When we fist call this method, clear out the old dictionary as the values in it
		 * no longer have any meaning. Let the garbage collector pick up the trash (the old dictionary).
		 */
		player_to_team_dict = new Hashtable<Player, Team>();
		
		//HashTable does not like null values when putting objects into a dictionary. Create empty Player.
		Team team_tmp = new Team(NULL_TEAM, -1);
		
		// turn the array of players into a list so we can do efficient
		// randomization without lots of reallocation
		ArrayList<Player> playerList = new ArrayList<Player>(players.length);
		for (Player p : players) {
			playerList.add(p);
			//Initialize the dictionary and add this player entry, with a dummy team object.
			player_to_team_dict.put(p,team_tmp);
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
			randomizedTeams[teamIndex%numTeams].addPlayer(p);
			//Fill the player key with the team the player was added too. Increment the index.
			player_to_team_dict.put(p,randomizedTeams[teamIndex++%numTeams]);
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
