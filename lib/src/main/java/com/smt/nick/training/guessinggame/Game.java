/**
 * JDK 17
 */
package com.smt.nick.training.guessinggame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.smt.nick.training.guessinggame.langpack.Language;


/****************************************************************************
 * <b>Title:</b> Game.java<br>
 * <b>Project:</b> Training Sandbox-lib<br>
 * <b>Description:</b> This is my Guessing Game revision's main Game class; In this class I have my main entry point, as well as methods directly pertaining to the game
 * function or process. <br>
 * <b>Copyright:</b> Copyright (c) 2023<br>
 * <b>Company:</b> Silicon Mountain Technologies<br>
 * 
 * @author Nick Jones
 * @version 1.0
 * @since Jan 03 2023
 * @updates:
 ****************************************************************************/

public class Game {
	 Language language;
	 Scanner in;
	 int correctNumber;

	public static void main(String[] args) {
		Game game = new Game();
		game.gameProcess();
	}
	/**
	 * Main game process method that runs the game, 
	 * initializes, requests a language, creates a player
	 */
	public void gameProcess() {
		initialize();
		createPlayer();
		close();
	}

	public void initialize() {
		in = new Scanner(System.in);
		Ruleset rules = new Ruleset();
	}
	/**
	 * This method contains any wrapup code I'll need for the game, 
	 * Right now it closes off the scanner initialized in my initialize method. 
	 */
	public void close() {
		in.close();
	}
	/**
	 * This method lists the available options for a language key and sets it to an empty key as default
	 */
	public void requestLanguage() {
		
		for (String lang : Language.langPack.keySet()) {
			System.out.println(lang);
		}
		String chosenLang = "";
		language = new Language(chosenLang);
	}
	/**
	 * prints to the console a greeting, given a language key, iterating through the key's map of statement options
	 */
	public void greeting() {
		System.out.println(retrieveLangpackMessage(Language.GREETING));
	}
	/**
	 * This returns to to the console the current selected language
	 */
	public void languageChoice() {
		System.out.println(retrieveLangpackMessage(Language.CURRENTLANGUAGE));
	}
	/**
	 * 
	 * @return userName as a string for use with the method, createPlayer
	 */
	public String requestName() {
		System.out.println(retrieveLangpackMessage(Language.PLAYERNAME));
		String userName = in.nextLine();
		return userName;
	}
	
	/**
	 * @param nickname this is taken from requestName method
	 * @return player is a created player object with an assigned name
	 */
	public Player createPlayer() {
		requestLanguage();
		Player player = new Player(requestName());
		player.setLanguage(Language.DEFAULT_LANG);
		return player;
	}
	/**
	 * 
	 * @param rules feeds in player count, number range, number of guesses
	 * @return playerset gives the game a playerset to manipulate and use in case of multiplayer
	 */
	public List createPlayerSet(Ruleset rules) {
		List<Player> playerset = new ArrayList<Player>();
		for (int i = 1; i <= (rules.getNumberOfPlayers() + 1); i++) {
		playerset.add(createPlayer());
		}
		return playerset;
	}

	/**
	 * @param message is the intended option to be used at said point in the game
	 * @return Language.langPack.get(language.getCurrentLanguage()).get(message); goes through my Language class
	 * into my langPack map of maps, into a language (english for example) map, and retrieves a message, usually for printing to the console.
	 */
	public String retrieveLangpackMessage(String message) {
		return Language.langPack.get(language.getCurrentLanguage()).get(message);
	}
	
	
	
}
