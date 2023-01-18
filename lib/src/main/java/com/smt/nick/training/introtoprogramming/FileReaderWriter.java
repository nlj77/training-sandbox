
package com.smt.nick.training.introtoprogramming;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import lombok.Data;

/****************************************************************************
 * <b>Title:</b> ReaderWriterExercise1.java<br>
 * <b>Project:</b> lib<br>
 * <b>Description:</b> <br>
 * <b>Copyright:</b> Copyright (c) 2023<br>
 * <b>Company:</b> Silicon Mountain Technologies<br>
 * 
 * @author Nick Jones
 * @version 1.0
 * @since Jan 13 2023
 * @updates:
 ****************************************************************************/
@Data
public class FileReaderWriter {
	/**
	 * Declares a private string fileNameInput, and Output with getters
	 */
	protected String fileNameInput;
	protected String fileNameOutput;

	/**
	 * 
	 * @return a bufferedReader object for manipulation later
	 * @throws FileNotFoundException
	 */
	public BufferedReader readFile() throws FileNotFoundException {
		FileReader fileReader = new FileReader(fileNameInput);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		return bufferedReader;
	}

	/**
	 * @param chars any input string for testing writing
	 * @throws IOException logs to trace, just for practice
	 */
	public void writeFile(char[] chars) throws IOException {
		FileWriter writer = new FileWriter(fileNameOutput);
		BufferedWriter buffer = new BufferedWriter(writer);
		try {
			buffer.write(chars);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		buffer.close();
	}

}
