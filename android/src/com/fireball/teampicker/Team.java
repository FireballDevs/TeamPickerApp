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
}
