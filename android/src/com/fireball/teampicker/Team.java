package com.fireball.teampicker;

import java.util.Arrays;



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
	 * @return the team_number
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}



	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}



	/**
	 * @return the players
	 */
	public Player[] getPlayers() {
		return players;
	}



	/**
	 * @param players the players to set
	 */
	public void setPlayers(Player[] players) {
		this.players = players;
	}
	
}
