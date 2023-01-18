
/**
 * JDK 17
 */
package com.smt.nick.training.guessinggame;

import lombok.Data;

/****************************************************************************
 * <b>Title:</b> RuleSet.java<br>
 * <b>Project:</b> Training Sandbox-lib<br>
 * <b>Description:</b>This is my RuleSet class for my GuessingGame, the idea behind this is to create a default set of win and lose conditions, 
 * as well as open the door way for modifiers like limiting guesses, and adding players. <br>
 * <b>Copyright:</b> Copyright (c) 2023<br>
 * <b>Company:</b> Silicon Mountain Technologies<br>
 * 
 * @author Nick Jones
 * @version 1.0
 * @since Jan 12 2023
 * @updates:
 ****************************************************************************/
@Data
public class Ruleset {

	private int numberOfPlayers = 1;

	private int numberOfRounds = 1;

	private String winner;

	private int maxNumber = 100;

	private int minNumber = 1;

	private Boolean isThereAMaxNumberOfGuesses = false;

	private int maxNumberOfGuessesAllowed;

}
