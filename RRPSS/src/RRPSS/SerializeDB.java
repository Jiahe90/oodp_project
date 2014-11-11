package RRPSS;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;

public class SerializeDB {
	public static ArrayList readSerializedObject(String filename) {
		ArrayList objects = null;
		FileInputStream fis = null;
		ObjectInputStream in = null;
		try {
			fis = new FileInputStream(filename);
			//check whether it is a empty file
			if (fis.available() == 0) {
				fis.close();
				return objects;
			}
			in = new ObjectInputStream(fis);
			objects = (ArrayList) in.readObject();
			in.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		return objects;
	}

	public static void writeSerializedObject(String filename, Collection list) {
		FileOutputStream fos = null;
		ObjectOutputStream out = null;
		try {
			fos = new FileOutputStream(filename);
			out = new ObjectOutputStream(fos);
			out.writeObject(list);
			out.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public static void updateFile(String filename, Collection list) {
		writeSerializedObject(filename, null);
		writeSerializedObject(filename, list);
	}
}
