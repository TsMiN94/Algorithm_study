import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

		Scanner sc = new Scanner(System.in);

		String info[] = reader.readLine().split(" ");

		int maxSize = Integer.parseInt(info[0]);// 정점의 갯수
		int edge = Integer.parseInt(info[1]);// 간선의 갯수
		int startV = Integer.parseInt(info[2]);// 시작 점

		Graph g = new Graph(maxSize);

		for (int i = 0; i < edge; i++) {
			info = reader.readLine().split(" ");
			int v = Integer.parseInt(info[0]);
			int w = Integer.parseInt(info[1]);

			g.addEdge(v - 1, w - 1);
			g.addEdge(w - 1, v - 1);

		}
		LinkedList list[] = g.getVertaxList();
		for (int i = 0; i < list.length; i++)
			Collections.sort(list[i]);

		g.dfs(startV - 1, writer);
		writer.newLine();
		g.bfs(startV - 1, writer);

		writer.flush();
		writer.close();
	}

}
