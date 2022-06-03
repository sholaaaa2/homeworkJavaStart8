package com.gmail.kukaruka52;

import java.io.File;


public class Main {

	public static void main(String[] args) {
		File f1 = new File(".");
		printFolder(f1);
	}

	public static void printFolder(File folder) {
		File[] files = folder.listFiles();
		for (File file : files) {
			if (file.isDirectory()) {
				System.out.println(file);
				printFolder(file);
			} 
		}
	}

}
