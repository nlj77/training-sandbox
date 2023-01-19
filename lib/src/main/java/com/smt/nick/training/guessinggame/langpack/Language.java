/**
 * JDK 17
 */
package com.smt.nick.training.guessinggame.langpack;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;

/****************************************************************************
 * <b>Title:</b> Language.java<br>
 * <b>Project:</b> Training Sandbox-lib<br>
 * <b>Description:</b> This is my language class, intended to create and store responses based
 * on player selected language, that the game can then call and use.  <br>
 * <b>Copyright:</b> Copyright (c) 2023<br>
 * <b>Company:</b> Silicon Mountain Technologies<br>
 * 
 * @author Nick Jones
 * @version 1.0
 * @since Jan 04 2023
 * @updates:
 ****************************************************************************/
@Data
public class Language {
	/**
	 * Creates a string variable for a currentLanguage setting, a method can access this
	 */
	String currentLanguage;
	/**
	 * These are final Strings set as default responses for the use in this game and for the sake of this exercises
	 */
	public static final String ENGLISH = "En";
	public static final String DEFAULT_LANG = ENGLISH;
	public static final String GREETING = "greeting";
	public static final String PLAYERNAME = "name request";
	public static final String TOOLOW = "too low";
	public static final String TOOHIGH = "too high";
	public static final String CORRECTGUESS = "correct answer";
	public static final String NUMBEROFTRIES = "# of tries";
	public static final String PLAYAGAINPROMPT = "play again";
	public static final String CURRENTLANGUAGE = "outputs current language selection";



	/**
	 * Creates a english HashMap for use in the langPack map of maps.
	 * This Map holds options for default greetings, win conditions, player names, and playing again questions
	 */
	public static final Map<String, String> englishPack = new HashMap<>();
	static {
		englishPack.put(GREETING, "Hello and welcome to the Guessing Game!!");
		englishPack.put(PLAYERNAME, "What is your name?");
		englishPack.put(TOOLOW, "Your guess was too low! Try again: ");
		englishPack.put(TOOHIGH, "Your guess was too high! Try again: ");
		englishPack.put(CORRECTGUESS, "You got the answer!");
		englishPack.put(NUMBEROFTRIES,  "Number of tries needed to guess correctly: ");
		englishPack.put(PLAYAGAINPROMPT,  "Do you want to play again?");
		englishPack.put(CURRENTLANGUAGE, "You current language code selection is: ");
	}
	/**
	 * Creates a langPack HashMap to hold other languages. 
	 * The intent is the game can set a user's default language, 'En' for example, then cycle through the English map
	 * for usable responses. This is intended to be expandable. 
	 */
	public static final Map<String,Map<String, String>> langPack=new HashMap<>();
	static {
		langPack.put(ENGLISH, englishPack);
		langPack.put("Es", englishPack);
	}
	/**
	 * This constructor method sets the currentLanguage attribute to the default language which is English for this exercise
	 */
	public Language() {
		currentLanguage = DEFAULT_LANG;
	}
	/**
	 * @param lang takes a lang argument and checks it against my langPack collection
	 */
	public Language(String lang) {
		if(langPack.containsKey(lang)) {
			currentLanguage = lang;
		} else {
			currentLanguage = DEFAULT_LANG;
		}
	}
	
	/**
	 * This is a test method, written to verify default methods, and assigning a new language
	 */
	public void test()	{
		Language l = new Language();
		Language ll = new Language("Es");
		Language lll = new Language(Language.ENGLISH);
		langPack.keySet();
	}
	
}
