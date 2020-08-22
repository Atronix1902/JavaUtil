package eu.atronix.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

import org.json.JSONObject;

public class JSONFile {
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
		JSONObject Obj  = new JSONObject();
		
		try {
			String line = "";	
			String complete = "";
			
			BufferedReader br = Files.newBufferedReader(file.toPath());
			
			while((line = br.readLine())!=null) {	
				complete += line;
			}
			
			br.close();
			
			Obj = new JSONObject(complete.trim());
			
		} catch (Exception e) {
		e.printStackTrace();
		}
		
		return Obj;
	}
	
	/**
	 * Writes JSONObject into File by getting the File and the JsonObject as input
	 * @author Atronix
	 * @param file File - the File that should be written
	 * @param what JSONObject - the JSONObj that should be written into file
	 * @throws IOException If an I/O error occurredSecurityException 
	 * @throws SecurityException If a security manager exists and its SecurityManager.checkWrite(java.lang.String)method denies write access to the file
	 * @throws UnsupportedOperationException if an unsupported option is specified
	 * @throws InvalidPathException - if a Path object cannot be constructed from the abstract path (see FileSystem.getPath)
	 */
	public void writeJsonFile(File file, JSONObject what) {
		
		if(file.exists()) {
			file.delete();
			
			try {
				file.createNewFile();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		BufferedWriter bw;
		
		try {
			bw = Files.newBufferedWriter(file.toPath(), StandardOpenOption.CREATE);
			bw.write(what.toString());
			bw.flush();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
