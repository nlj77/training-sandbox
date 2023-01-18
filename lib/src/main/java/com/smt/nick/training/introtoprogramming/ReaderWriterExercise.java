package com.smt.nick.training.introtoprogramming;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/****************************************************************************
 * <b>Title:</b> ReaderWriterExercise.java<br>
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

public class ReaderWriterExercise {

	public static void main(String args[]) {

		String data = "This is the data in the output file";

		try {
			// Creates a FileWriter
			FileWriter file = new FileWriter("output.txt");

			// Creates a BufferedWriter
			BufferedWriter output = new BufferedWriter(file);

			// Writes the string to the file
			output.write(data);

			// Closes the writer
			output.close();
		}

		catch (Exception e) {
			e.getStackTrace();
		}
	}
}