package eu.atronix.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

import org.json.JSONObject;

/**
 * Needs original org.json package to work
 * <br>provides several functions to interact with json files
 * @author Atronix
 * @version 1.0
 *
 */
public class JSONFile {
	/*
	 * IDEAS:
	 * creating functions for objects of JSONFile like blablaFile.readJson()
	 */
	
	private String path = ""; //Path of the File
	private String content = ""; //Content of the File
	
	
	
	/**
	 * Reads the JsonFile of it's input and converts it to JSONObj
	 * @author Atronix
	 * @param file File - The file that should be read and converted to JSONObject 
	 * @throws JSONException If there is a syntax error in the source string or a duplicated key.
	 * @throws IOException If an I/O error occurs
	 * @throws InvalidPathException if a Path object cannot be constructed from the abstractpath (see FileSystem.getPath)
	 * @throws SecurityException In the case of the default provider, and a security manager isinstalled, the checkReadmethod is invoked to check read access to the file.
	 * @return JSONObject The JSONObj the file contained
	 */
	public JSONObject readJsonFile(File file) {
		JSONObject Obj  = new JSONObject(); //Object to save the finished 
		
		try {
			String line = ""; //Single line of file
			String complete = ""; //Complete file content as String
			
			BufferedReader br = Files.newBufferedReader(file.toPath()); //reader for reading the file
			
			//as long there is still a char left
			while((line = br.readLine())!=null) {	
				complete += line; //appending the current line 
			}
			
			br.close(); //closes the connection to file
			
			Obj = new JSONObject(complete.trim()); //initialises Obj with content of complete file
			
		} catch (Exception e) {
		e.printStackTrace(); //prints error if error occurs
		}
		
		return Obj; //returns finished Object
	}
	
	
	
	
	
	/**
	 * Writes JSONObject into File by getting the File and the JsonObject as input
	 * @author Atronix
	 * @warning deletes already existing files
	 * @param file File - the File that should be written
	 * @param what JSONObject - the JSONObj that should be written into file
	 * @throws IOException If an I/O error occurredSecurityException 
	 * @throws SecurityException If a security manager exists and its SecurityManager.checkWrite(java.lang.String)method denies write access to the file
	 * @throws UnsupportedOperationException if an unsupported option is specified
	 * @throws InvalidPathException - if a Path object cannot be constructed from the abstract path (see FileSystem.getPath)
	 */
	public void writeJsonFile(File file, JSONObject what) {
		//checks if the file exists
		if(file.exists()) {
			file.delete(); //deletes the file
			
			try {
				file.createNewFile(); //creates new file	
			} catch (Exception e) { 
				e.printStackTrace(); //prints error if error occurs
			}
		}
		
		BufferedWriter bw; //new writer to connect to file
		
		try {
			bw = Files.newBufferedWriter(file.toPath(), StandardOpenOption.CREATE); //initializes the writer
			bw.write(what.toString()); //writes content into file
			bw.flush(); //clears input of writer
			bw.close(); //closes connection to writer
		} catch (Exception e) {
			e.printStackTrace(); //prints error if error occurs
		}
	}
}
