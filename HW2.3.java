package com.gmail.kukaruka52;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Main {

	public static void main(String[] args) {
		File file = new File("c.txt");
		printAscii(file);
	}

	public static void printAscii(File file) {
		try (PrintWriter a = new PrintWriter(file)) {
			for (int i = 0; i < 40; i++) {
				for (int j = 0; j < 20; j++) {
					if (i % 2 == 0) {
						if (j % 2 == 0) {
							a.print("**");
						} else {
							a.print("++");
						}
					} else {
						if (j % 2 == 0) {
							a.print("++");
						} else {
							a.print("**");
						}
					}
				}
				a.print(System.lineSeparator());
			}
		} catch (FileNotFoundException e) {
			System.out.println(e);
		}
	}
}
