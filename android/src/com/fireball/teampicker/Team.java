package com.fireball.teampicker;

import java.util.Arrays;



/**
 * Team object which has a ArrayList of Player objects
 * @author Evan Boucher
 *
 */
public class Team {

	private int team_number;
	private String name;
	private Player[] players;
	
	

	public Team( String name, int team_number, Player[] players) {
		super();
		this.team_number = team_number;
		this.name = name;
		this.players = players;
	}
	
	public Team( String name, int team_number, Player player) {
		super();
		this.team_number = team_number;
		this.name = name;
		this.players = new Player[] {player};
	}
	

	/**
	 * @return the team_number Get the team number
	 */
	public int getTeam_number() {
		return team_number;
	}



	/**
	 * @param team_number the team_number to set
	 */
	public void setTeam_number(int team_number) {
		this.team_number = team_number;
	}



	/**
	 * @return the name current name of the team
	 */
	public String getName() {
		return name;
	}



	/**
<<<<<<< Updated upstream
	 * @param name the name to set
=======
	 * @param name the new name of the team
>>>>>>> Stashed changes
	 */
	public void setName(String name) {
		this.name = name;
	}



	/**
	 * @return the players as an ArrayList
	 */
	public Player[] getPlayers() {
		return players;
	}



	/**
<<<<<<< Updated upstream
	 * @param players the players to set
=======
	 * @param players Array List of players to set
>>>>>>> Stashed changes
	 */
	public void setPlayers(Player[] players) {
		this.players = players;
	}
	
<<<<<<< Updated upstream
=======
	/**
	 * Adds a player to the team.
	 * @param p
	 */
	public void addPlayer(Player p) {
		this.players.add(p);
	}
	
	/**
	 * Method for finding a player by name (this will probably be replaced by a
	 * method for finding a player by a player object since names are not unique.
	 * @param player_name String consisting of the players name
	 * @return The player object if it was found, null otherwise.
	 */
	public Player findPlayerByName(String player_name) {
		
		for (Player p : this.getPlayers()) {
			//If this is the player we are looking for (same name)
			if (p.getName() == player_name) {
				return p;
			}
		}
		//Player not found
		return null;
	}
	
	/**
	 * Method for searching for a player using a player object (better than searching by name)
	 * @param player A player object to search the team for.
	 * @return The player object that was found, otherwise null.
	 */
	public Player findPlayer(Player player) {
		
		for (Player p : this.getPlayers()) {
			//If this is the player we are looking for (same name)
			if (p.equals(player)) {
				return p;
			}
		}
		//Player not found
		return null;
	}
>>>>>>> Stashed changes
}
