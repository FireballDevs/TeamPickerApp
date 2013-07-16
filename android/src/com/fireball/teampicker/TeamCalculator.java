/**
 * 
 */
package com.fireball.teampicker;

import com.fireball.teampicker.Team;

/**
 * Team Calculator contains methods for manipulating the Team Object (an array of players)
 * 
 */
public class TeamCalculator {

 /**
	 * Randomize
	 * 
	 * @param  List<Player> - list of all players
	 * @param numberOfTeams
	 * @return RandomizedTeams[] - array of two or more randomized teams
	 */
	public Team Randomize(List<Player> list, int numberOfTeams, int totalNumberOfPlayers) {
		
		randomizedTeams = new Team[numberOfTeams];
		
		int maxPerTeam = (totalNumberOfPlayers + numberOfTeams - 1) / numberOfTeams;
		
		for(int i = 0; i < randomizedTeams.length; i++){
			randomizedTeams[i] = new Team(maxPerTeam);
		}
		
		for(Player player : list ){
			// generate random number from 1 to numberOfTeams
			// check if team is full
				// reroll
			// else place player on that team		
		}
		
		// even out teams (i.e. |numberOfPlayersTeam1 - numberOfPlayersTeam2| <= 1)
		
		return randomizedTeams;
	}
	
}
