package phy.exception;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class StackTraceTest {

	public static void main(String[] args) {
		
		File file = new File("/Users/puhongyu/phy/tmp/1.txt");
		try {
			FileInputStream fs = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			StackTraceElement[] sts = e.getStackTrace();
			for(StackTraceElement st : sts) {
				System.out.println(st);
			}
		}
	}
}
