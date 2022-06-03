package com.gmail.kukaruka52;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder text = new StringBuilder();
		while (true) {
			System.out.println("Write");
			String string = sc.nextLine();
			if (string.equals("exit")) {
				saveFile(text.toString());
				break;
			} else {
				text.append(string).append(System.lineSeparator());
			}

		}
	}

	public static void saveFile(String txt) {
		try (PrintWriter a = new PrintWriter("c.txt")) {
			a.println(txt);
		} catch (FileNotFoundException e) {
			System.out.println(e);
		}
	}

}
