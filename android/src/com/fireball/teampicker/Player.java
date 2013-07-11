package com.fireball.teampicker;

public class Player {
	
	private String name;
	private int position;
	
	
	
	public Player(String new_name, int new_position) {
		name = new_name;
		position = new_position;
		
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
	 * @return the position
	 */
	public int getPosition() {
		return position;
	}

	/**
	 * @param position the position to set
	 */
	public void setPosition(int position) {
		this.position = position;
	}
}
