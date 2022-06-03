package com.gmail.kukaruka52;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {

	public static void main(String[] args) {
		int[][] arr = {{1,2,3},{4,5,6},{7,8,9}};
		String text = arrToString(arr);
		File file = new File("c.txt");
		saveText(file, text);
	}

	public static void saveText(File file, String text) {
		try (PrintWriter pw = new PrintWriter(file)) {
			pw.println(text);
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	public static String arrToString(int[][] arr) {
		StringBuilder sb = new StringBuilder();
		for (int[] row : arr) {
			for (int col : row) {
				sb.append(String.format("%-6.6s\t", "" + col));
			}
			sb.append(System.lineSeparator());
		}
		return sb.toString();
	}

}
