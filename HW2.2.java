package com.gmail.kukaruka52;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		File file = new File("c.txt");
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		outStatLetter(countCharsFromFile(file, alphabet));

	}

	public static String[][] countCharsFromFile(File file, String check) {
		String str = "";
		String[][] stat = new String[check.length()][2];

		for (int i = 0; i < stat.length; i++) {
			stat[i][0] = String.valueOf(check.charAt(i));
			stat[i][1] = "0";
		}

		try (Scanner scan = new Scanner(file)) {

			for (; scan.hasNextLine();) {
				str = scan.nextLine().toLowerCase().replaceAll("[^a-z]", "");

				for (int i = 0; i < str.length(); i++) {
					for (int j = 0; j < stat.length; j++) {
						if (stat[j][0].equals(String.valueOf(str.charAt(i)))) {
							stat[j][1] = String.valueOf(Integer.valueOf(stat[j][1]) + 1);
						}
					}
				}

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return stat;
	}

	public static void outStatLetter(String[][] stat) {
		StringBuilder sb = new StringBuilder(0);

		for (int i = 0; i < stat.length; i++) {
			for (int j = i + 1; j < stat.length; j++) {
				if (Integer.valueOf(stat[i][1]) < Integer.valueOf(stat[j][1])) {
					String[] arch = stat[i];
					stat[i] = stat[j];
					stat[j] = arch;
				}
			}
		}

		for (int i = 0; i < stat.length; i++) {
			if (stat[i][1] != "0") {
				String temp = String.format("Letter '%s' is used %s times", stat[i][0], stat[i][1]);
				sb.append(temp + System.lineSeparator());
			}
		}
		System.out.println(sb.toString());
	}

}
