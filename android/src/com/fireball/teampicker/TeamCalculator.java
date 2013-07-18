/**
 * 
 */
package com.fireball.teampicker;

import com.fireball.teampicker.Team;
import com.fireball.teampicker.Player;

/**
 * Team Calculator contains methods for manipulating the Team Object (an array of players)
 * 
 */
public class TeamCalculator {

	/**
	 * Randomize
	 * @author test test
	 * 
	 * @param  List<Player> - list of all players
	 * @param numberOfTeams
	 * @return RandomizedTeams[] - array of two or more randomized teams
	 */
	public Team[] Randomize(String[] teamNames, Player[] players) {		
		
		// Assuming teamNames.length = number of teams and players.length = number of players
		Team randomizedTeams = new Team[teamNames.length];			
		int maxPerTeam = (players.length + teamNames.length - 1) / teamNames.length;
				
		// Randomize players array
		for( int i = 0; i < players.length; i++ ){
			// code: swap player with another random player (between 0 and (players.length-1))
		}

		// create playerGroups
		Player playerGroup = new Player[teamNames.length][maxPerTeam];			
		
		// fill in player groups horizontally (alternating groups) with randomized array
		int k = 0;
		for(int i = 0; i < maxPerTeam; i++){
			for (int j = 0; j < randomizedTeams.length; j++){
				playerGroup[j][i] = players[k];
				k++;
			}
		}
		
		//create teams
		for(int i = 0; i < randomizedTeams.length; i++){
			randomizedTeams[i] = new Team(teamNames[i], i, playerGroup[i]);
		}
		
		return randomizedTeams;
	}
	
}
