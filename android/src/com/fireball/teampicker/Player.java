package com.fireball.teampicker;

/**
 * A player object.
 * @author Evan Boucher
 *
 */
public class Player {
	
	private String name;
	private int position;
	
	public Player(String new_name, int new_position) {
		this(new_name);
		position = new_position;
		
	}
	
	/**
	 * Player constructor with just the name.
	 * @param name
	 */
	public Player(String name) {
		
		this.name = name;
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
