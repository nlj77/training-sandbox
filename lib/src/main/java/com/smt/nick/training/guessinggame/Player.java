/**
 * JDK 17
 */
package com.smt.nick.training.guessinggame;

import lombok.Data;

/****************************************************************************
 * <b>Title:</b> Player.java<br>
 * <b>Project:</b> Training Sandbox-lib<br>
 * <b>Description:</b>This is my Player class. The player class needs to be able to hold a nickname, and I found it useful to include a totalScore attribute
 * for expansion <br>
 * <b>Copyright:</b> Copyright (c) 2023<br>
 * <b>Company:</b> Silicon Mountain Technologies<br>
 * 
 * @author Nick Jones
 * @version 1.0
 * @since Jan 04 2023
 * @updates:
 ****************************************************************************/
@Data
public class Player {
	/**
	 *  creates a private String name attribute
	 */
	private String name;
	
	/**
	 *  creates a private String language attribute
	 */
	private String language;
	
	/**
	 *  creates a private int totalScore attribute
	 */
	private int totalScore;

	/**
	 * @param nickname is a String passed in by a Game method request, this sets the
	 * player object's name.
	 */
	public Player(String nickname) {
		this.name = nickname;
	}
	
	/**
	 * @param languageCode this refers to the two character string representing a language pack Map
	 * Sets the player's current language
	 */
	public void setLanguage(String languageCode) {
		this.language = languageCode;
	}
	/**
	 * 
	 * @return the player object's current set language
	 */
	public String getLanguage() {
		return this.language;
	}
}
