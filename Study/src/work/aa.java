package work;

import java.io.*;
import java.util.*;

public class aa {
	private static int[] degree(int matrix[][]) {
		int deg[] = new int[matrix.length];

		for (int i = 0; i < matrix.length; i++)
			for (int j = 0; j < matrix.length; j++)
				deg[i] = deg[i] + matrix[i][j];

		return deg;
	}

	private static int del(int k, int matrix[][]) {
		int answer = 0;

		for (int tryy = 0; tryy < matrix.length; tryy++) {
			int deg[] = degree(matrix);

			// break
			int check = 0;
			for (int i = 0; i < matrix.length; i++) {
				check = check + deg[i];
			}
			if (check == 0)
				break;

			//
			for (int i = 0; i < matrix.length; i++) {
				if (deg[i] < k) {
					for (int j = 0; j < matrix.length; j++) {
						matrix[j][i] = 0;
						matrix[i][j] = 0;
					}
				}
			}
		}
		int deg[] = degree(matrix);

		for (int i = 0; i < matrix.length; i++)
			if (deg[i] != 0)
				answer++;

		return answer;

	}

	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(new File("C:\\Users\\Seokam\\Downloads\\project5_input.txt"));
			int T = sc.nextInt();
			long st = System.currentTimeMillis();

			for (int i = 0; i < T; i++) {
				int vertex = sc.nextInt();
				int k = sc.nextInt();
				int edge = sc.nextInt();

				int matrix[][] = new int[vertex][vertex];

				for (int x = 0; x < edge; x++) {
					int a = sc.nextInt() - 1;
					int b = sc.nextInt() - 1;

					matrix[a][b] = 1;
					matrix[b][a] = 1;
				}
				int answer = 0;

				answer = del(k, matrix);
				System.out.println(answer);

			}
			long et = System.currentTimeMillis();
			System.out.println((et - st) + " ms");
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
