/**
 * JRE Java[SE-17]
 */
package com.smt.nick.training.sockets;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.smt.nick.training.introtoprogramming.FileReaderWriter;

/****************************************************************************
 * <b>Title:</b> PracticeWebSocket.java<br>
 * <b>Project:</b> Practice WebSocket <br>
 * <b>Description:</b> This is the exercise for the intro to programming websocket power point <br>
 * <b>Copyright:</b> Copyright (c) 2023<br>
 * <b>Company:</b> Silicon Mountain Technologies<br>
 * 
 * @author Nick Jones
 * @version 1.0
 * @since Jan 31 2023
 * @updates:
 ****************************************************************************/
/**
 * 
 * @author nickjones
 *
 */
public class PracticeWebSocket {
	//Declares a logger object. For scaling purposes, being able to log successes and errors will be useful if I add functionality to my lang pack
	final Logger logger = Logger.getLogger(StringBuilder.class.getName());
	//Gets the working directory from the user, if this is cloned and pulled to a different user's local repo
	static final String DIR = System.getProperty("user.dir");
	//This sets the output variable to the user's directory plus 
	static final String OUTPUTLOCATION = DIR + "/src/main/resources/practicewebsocket.html";


	public static void main(String[] args) {
//		//instantiates a new wSock object
		PracticeWebSocket wSock = new PracticeWebSocket();
		//calls the getwebpage action on localhost for apache default port 80
		wSock.writeHTMLToFile(OUTPUTLOCATION, wSock.getWebPage("127.0.0.1", 81));
	}
	/**
	 * I wrote this method just to test getting the correct working directory
	 */
	 private static void printCurrentWorkingDirectory1() {
	        String userDirectory = System.getProperty("user.dir");
	        System.out.println(userDirectory);
	    }
	 /**
	  * 
	  * @param host this takes a host as a string object
	  * @param portNumber takes a listening port from apache as a int
	  * @return an html StringBuilder object
	  */
		public StringBuilder getWebPage(String host, int portNumber) {
			
			//instantiates a new Stringbuilder object called html
			StringBuilder html = new StringBuilder();
			//try with resources creates a new socket object from the fed in portNumber and host
			try (Socket echoSocket = new Socket(host, portNumber)) {
				//logs to logger an info level note
				logger.log(Level.INFO, "Socket Created");
				
				DataOutputStream out = new DataOutputStream(echoSocket.getOutputStream());
				BufferedReader in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
				logger.log(Level.INFO, "Streams Created");
				out.writeBytes("GET /HTTP/1.1 \r\n");
				out.writeBytes("\r\n");
				out.flush();
				String inData = null;
				while ((inData = in.readLine()) != null) {
					html.append(inData + "\n");
				}
			} catch (Exception e) {
				logger.log(Level.INFO, "Unable to connect to Server", e);
			}

			return html;
		}

	public void writeHTMLToFile(String OUTPUTLOCATION, StringBuilder htmlDoc) {
		FileReaderWriter myFRW = new FileReaderWriter();
		myFRW.setFileNameOutput(OUTPUTLOCATION);
		try {
			myFRW.writeFile(htmlDoc, OUTPUTLOCATION);
		} catch (IOException e) {
			logger.log(Level.INFO, "Unable to connect to Server", e);
		}

	}
}
