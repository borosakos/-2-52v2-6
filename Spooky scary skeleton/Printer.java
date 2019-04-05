package skeleton;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Printer {
	
	private static boolean printToFile = false;
	private static PrintWriter fPrint;

	public static void printName(String str) {
		if (printToFile) {
			fPrint.println(str + ":");
		} else {
			System.out.println(str + ":");
		}
	}

	public static void print(String str) {
		if (printToFile) {
			fPrint.println("\t" + str);
		} else {
			System.out.println("\t" + str);
		}
	}
	
	public static void setFile(String outputFile) {
		try {
			printToFile = true;
			fPrint = new PrintWriter("output.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void setStandardOutput() {
		printToFile = false;
	}
}
