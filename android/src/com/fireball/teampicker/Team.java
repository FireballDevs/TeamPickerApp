package com.fireball.teampicker;

import java.util.ArrayList;

public class Team {

	private int teamNumber;
	private String name;
	private ArrayList<Player> players;

	/**
	 * Team constructor
	 * @param teamName
	 * @param teamNumber
	 */
	public Team(String teamName, int teamNumber) {
		super();
		this.teamNumber = teamNumber;
		this.name = teamName;
		this.players = new ArrayList<Player>();
	}
	
	/**
	 * Team constructor
	 * @param teamName
	 * @param teamNumber
	 * @param players
	 */
	public Team(String teamName, int teamNumber, ArrayList<Player> players) {
		this(teamName, teamNumber);
		this.players = players;
	}

	/**
	 * Team constructor
	 * @param teamName
	 * @param teamNumber
	 * @param player
	 */
	public Team(String teamName, int teamNumber, Player player) {
		this(teamName, teamNumber);
		this.players = new ArrayList<Player>(1);
		this.players.add(player);
	}

	/**
	 * @return the team_number
	 */
	public int getTeamNumber() {
		return teamNumber;
	}

	/**
	 * @param team_number
	 *            the team_number to set
	 */
	public void setTeamNumber(int team_number) {
		this.teamNumber = team_number;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the players
	 */
	public ArrayList<Player> getPlayers() {
		return players;
	}

	/**
	 * @param players
	 *            the players to set
	 */
	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}

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

}
