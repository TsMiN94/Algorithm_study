package com.ssafy.algo.swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BattleField {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			int startX = 0, startY = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());

			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());

			char map[][] = new char[H][W];
			for (int i = 0; i < H; i++) {
				String line = br.readLine();

				for (int j = 0; j < line.length(); j++) {
					if (line.charAt(j) == '<' || line.charAt(j) == '>' || line.charAt(j) == 'v'
							|| line.charAt(j) == '^') {
						startX = i;
						startY = j;
					}
					map[i][j] = line.charAt(j);
				}
			}
			int userInput = Integer.parseInt(br.readLine());

			String userStr = br.readLine();
			for (int i = 0; i < userInput; i++) {
				char order = userStr.charAt(i);

				switch (order) {
				case 'U':
					map[startX][startY] = '^';
					if (startX - 1 >= 0 && map[startX - 1][startY] == '.') {
						char temp = map[startX][startY];
						map[startX][startY] = map[startX - 1][startY];
						map[startX - 1][startY] = temp;
						startX -= 1;
					}
					break;
				case 'D':
					map[startX][startY] = 'v';
					if (startX + 1 < H && map[startX + 1][startY] == '.') {
						char temp = map[startX][startY];
						map[startX][startY] = map[startX + 1][startY];
						map[startX + 1][startY] = temp;
						startX += 1;
					}
					break;
				case 'L':
					map[startX][startY] = '<';
					if (startY - 1 >= 0 && map[startX][startY - 1] == '.') {
						char temp = map[startX][startY];
						map[startX][startY] = map[startX][startY - 1];
						map[startX][startY - 1] = temp;
						startY -= 1;
					}
					break;
				case 'R':
					map[startX][startY] = '>';
					if (startY + 1 < W && map[startX][startY + 1] == '.') {
						char temp = map[startX][startY];
						map[startX][startY] = map[startX][startY + 1];
						map[startX][startY + 1] = temp;
						startY += 1;
					}
					break;
				case 'S':
					char curDir = map[startX][startY];

					if (curDir == '<') {
						for (int y = startY - 1; y >= 0; y--) {
							if (map[startX][y] == '#')
								break;
							else if (map[startX][y] == '*') {
								map[startX][y] = '.';
								break;
							}
						}
					} else if (curDir == '>') {
						for (int y = startY + 1; y < W; y++) {
							if (map[startX][y] == '#')
								break;
							else if (map[startX][y] == '*') {
								map[startX][y] = '.';
								break;
							}
						}
					} else if (curDir == 'v') {
						for (int x = startX + 1; x < H; x++) {
							if (map[x][startY] == '#')
								break;
							else if (map[x][startY] == '*') {
								map[x][startY] = '.';
								break;
							}
						}
					} else if (curDir == '^') {

						for (int x = startX - 1; x >= 0; x--) {
							if (map[x][startY] == '#')
								break;
							else if (map[x][startY] == '*') {
								map[x][startY] = '.';
								break;
							}
						}
					}

					break;
				default:
					break;
				}
			}

			System.out.print("#" + test_case + " ");
			for (int t = 0; t < map.length; t++) {
				for (int q = 0; q < map[t].length; q++) {
					System.out.print(map[t][q]);
				}
				System.out.println();
			}
		}
	}
}
