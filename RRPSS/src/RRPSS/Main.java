package RRPSS;

import java.io.File;
import java.util.ArrayList;
import java.util.*;
public class Main {
	public static void main(String [] args) {
		ArrayList testing = new ArrayList();
		ArrayList after = null;
		
//		Table t = new Table(1, 2, false);
//		Table t1 = new Table(2, 4, false);
//		testing.add(t);
//		testing.add(t1);
//
//		SerializeDB.writeSerializedObject("Tables.dat", testing);
//		File file = new File("Tables.dat");
//		System.out.println(file.length());
		
		try {
			after = SerializeDB.readSerializedObject("Tables.dat");
		} catch (Exception e) {
			System.out.println( "Exception >> " + e.getMessage() );
		}		
		
		if (after != null) {
			for (int i = 0; i < after.size() ; i++) {
				Table wtf = (Table) after.get(i);
				System.out.println(wtf.getTableNo());
				System.out.println(wtf.getCurrentlyOccupied());
				System.out.println(wtf.getNoOfSeats());
			}
		}
		else if (after == null)
			System.out.println("You suck");
		
/*		SerializeDB.writeSerializedObject("Tables.dat", null);
		
		try {
			after = SerializeDB.readSerializedObject("Tables.dat");
		} catch (Exception e) {
			System.out.println( "Exception >> " + e.getMessage() );
		}		
		
		if (after != null) {
			for (int i = 0; i < after.size() ; i++) {
				Table wtf = (Table) after.get(i);
				System.out.println(wtf.getTableNo());
				System.out.println(wtf.getCurrentlyOccupied());
				System.out.println(wtf.getNoOfSeats());
			}
		}
		else if (after == null)
			System.out.println("You suck");
		
		File file = new File("Tables.dat");
		System.out.println(file.length());*/
	}
}
