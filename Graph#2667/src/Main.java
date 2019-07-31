import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	private static ArrayList<Integer> solArr = new ArrayList<>();
	private static int apartArray[][];
	private static int size;
	private static int homeCnt = 0;
	private static boolean visited[][];
	private final static int[] goX = { -1, 0, 1, 0 };
	private final static int[] goY = { 0, 1, 0, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

		size = Integer.parseInt(reader.readLine());

		apartArray = new int[size][size];

		for (int i = 0; i < size; i++) {
			String info = reader.readLine();
			for (int j = 0; j < size; j++)
				apartArray[i][j] = Integer.parseInt(info.charAt(j) + "");
		}

		solution(writer);

		writer.flush();
		writer.close();
	}

	public static void solution(BufferedWriter writer) throws IOException {

		visited = new boolean[size][size];

		for (int i = 0; i < size; i++) {

			for (int j = 0; j < size; j++) {

				if (apartArray[i][j] == 1 && visited[i][j] != true) {
					dfs(i, j, visited);
					solArr.add(homeCnt);
					homeCnt = 0;
					System.out.println("새로운단지가 추가되었습니다.");
				}
			}

		}

		writer.write("size = " + Integer.toString(solArr.size()));
		writer.newLine();
		for (int a = 0; a < solArr.size(); a++) {
			System.out.println(solArr.get(a));
		
		}
	}

	public static void dfs(int i, int j, boolean visited[][]) { // [y][x] i = y , j =x

		visited[i][j] = true;
		homeCnt++;
		System.out.println("i =" + i + " , j =" + j + " , homeCnt = " + homeCnt);

		for (int k = 0; k < 4; k++) {

			int dx = i + goX[k];
			int dy = j + goY[k];

			System.out.println("k = " + k);
			if ((-1 < dx && dx < size) && (-1 < dy && dy < size) && apartArray[dx][dy] == 1
					&& visited[dx][dy] != true) {
				System.out.println("dfs들어간다");
				dfs(dx, dy, visited);
			}

		}
		System.out.println("for문 끝");
	}

}
