package com.smt.nick.training.introtoprogramming;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

/****************************************************************************
 * <b>Title:</b> ReaderWriterExerciseClass2.java<br>
 * <b>Project:</b> lib<br>
 * <b>Description:</b> This is the second class for my stream homework on the
 * Intro to Programming 3 (4th one done) powerpoint In this class, I take a set
 * of input and output files, and read the text written in the input file. I
 * then capitalize this text after turning it into a String, then I write it to
 * the output file. <br>
 * <b>Copyright:</b> Copyright (c) 2023<br>
 * <b>Company:</b> Silicon Mountain Technologies<br>
 * 
 * @author Nick Jones
 * @version 1.0
 * @since Jan 13 2023
 * @updates:
 ****************************************************************************/

public class FileReaderWriterClass2 {

	static final String INPUT = "src/main/resources/input.txt";
	static final String OUTPUT = "src/main/resources/output.txt";
	static final String TESTDATA = "This is a test.";

	public static void main(String[] args) throws IOException {

		WriteProcess();
	}

	/**
	 * 
	 * @throws IOException as a test if I need to follow an issue Works as my process for main
	 */
	public static void WriteProcess() throws IOException {
		FileReaderWriter myFRW = new FileReaderWriter();

		myFRW.setFileNameInput(INPUT);
		myFRW.setFileNameOutput(OUTPUT);
		fileStringToUpper(TESTDATA, myFRW);

	}

	/**
	 * 
	 * @param outputData this is the written data we're going to take in as a string format, can be read in with FRW readFile
	 * @param frw a frw object to feed in, this is instantiated with WriteProcess
	 * @throws FileNotFoundException incase output.txt, input.txt, or outputdata.txt is missing
	 * @throws IOException,again just as practice to get used to tracking down errors
	 */
	public static void fileStringToUpper(String outputData, FileReaderWriter frw)
			throws FileNotFoundException, IOException {
		FileReaderWriter myFRW = frw;
		try (BufferedReader br = new BufferedReader(new FileReader(INPUT))) {
			String line;

			while ((line = br.readLine()) != null) {
				char[] chars = line.toCharArray();
				for (int r = 0; r < chars.length; r++) {
					/**
					 * capitalize the first character of each string instead of every character
					 */
//			            if (r == 0 || chars[r - 1] == ' ') {
					chars[r] = Character.toUpperCase(chars[r]);
//			            }
				}
				myFRW.writeFile(chars);
			}

		}
	}
}
