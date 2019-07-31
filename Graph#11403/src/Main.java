import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

		String info[] = reader.readLine().split(" ");
		int vertaxSize = Integer.parseInt(info[0]);

		Graph graph = new Graph(vertaxSize);

		for (int i = 0; i < vertaxSize; i++) {
			String edgeInfo[] = reader.readLine().split(" ");
			for (int j = 0; j < edgeInfo.length; j++) {
				if (Integer.parseInt(edgeInfo[j]) == 1) {
					graph.addEdge(i, j);
					System.out.println("add");
				}
			}
		}

		graph.show(writer);

	}

}
