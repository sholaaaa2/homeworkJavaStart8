package com.gmail.kukaruka52;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		File file = new File("c.txt");
		int[][] array = loadArrFromFile(file);
		System.out.println(Arrays.deepToString(array));

	}

	public static int[][] loadArrFromFile(File file) {

		int[][] arr;
		int n = 0;

		try (Scanner sc = new Scanner(file)) {
			for (; sc.hasNextLine();) {
				sc.nextLine();
				n++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		arr = new int[n][];

		try (Scanner sc = new Scanner(file)) {

			for (int i = 0; i < n; i++) {

				String[] tempArr = sc.nextLine().split("; ");

				arr[i] = new int[tempArr.length];
				
				for (int j = 0; j < arr[i].length; j++) {
					arr[i][j] = Integer.valueOf(tempArr[j]);
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println(e);
		}

		return arr;
	}
}
