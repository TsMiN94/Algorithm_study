import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.LinkedList;

public class Graph {
	private int vertaxSize;
	private LinkedList vertaxList[];
	BufferedWriter writer;

	public Graph(int size) {
		this.vertaxSize = size;
		vertaxList = new LinkedList[size];
		for (int i = 0; i < size; i++) {
			vertaxList[i] = new LinkedList();
		}
	}

	public void addEdge(int v, int w) {
		vertaxList[v].add(w);
	}

	public void dfsF(int v, boolean visited[]) throws IOException {

		visited[v] = true;

		// System.out.print(v + 1 + " ");
		writer.write(v + 1 + " ");
		Iterator<Integer> i = vertaxList[v].listIterator();
		while (i.hasNext()) {
			int nextV = i.next();
			if (!visited[nextV])
				dfsF(nextV, visited);
		}

	}

	public void dfs(int v, BufferedWriter writer) throws IOException {
		this.writer = writer;
		boolean visited[] = new boolean[vertaxSize];
		dfsF(v, visited);
	}

	public void bfs(int v , BufferedWriter writer) throws IOException {
		boolean visited[] = new boolean[vertaxSize];
		this.writer = writer;
		LinkedList<Integer> queue = new LinkedList<>();

		visited[v] = true;

		queue.add(v);

		while (queue.size() != 0) {
			v = queue.poll();
			// System.out.print(v+1 + " ");
			writer.write(v + 1 + " ");
			Iterator<Integer> i = vertaxList[v].listIterator();
			while (i.hasNext()) {
				int w = i.next();
				if (!visited[w]) {
					visited[w] = true;
					queue.add(w);
				}
			}
		}
	}

	public int getVertaxSize() {
		return vertaxSize;
	}

	public void setVertaxSize(int vertaxSize) {
		this.vertaxSize = vertaxSize;
	}

	public LinkedList[] getVertaxList() {
		return vertaxList;
	}

	public void setVertaxList(LinkedList[] vertaxList) {
		this.vertaxList = vertaxList;
	}

}