import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Graph {

	private int vertaxSize;
	private BufferedWriter writer;
	private int verTaxG[][];

	public Graph(int vertaxSize) {
		this.vertaxSize = vertaxSize;
		verTaxG = new int[vertaxSize][vertaxSize];
	}

	public void addEdge(int v, int w) {
		verTaxG[v][w] = 1;
		verTaxG[w][v] = 1;
	}

	public void show(BufferedWriter writer) throws IOException {
		this.writer = writer;
		for (int i = 0; i < vertaxSize; i++) {
			for (int j = 0; j < vertaxSize; j++) {
				if (verTaxG[i][j] == 1)
					System.out.print("1 ");
				else {
					System.out.print("0 ");
				}
			}
			System.out.println();
		}
	}
}
