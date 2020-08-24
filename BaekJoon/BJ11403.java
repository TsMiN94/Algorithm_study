package BackJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ11403 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int arr[][];
    static List<Integer> graph[];

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        graph = new List[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            graph[i] = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                arr[j][i] = arr[i][j];
                if (arr[i][j] == 1) {
                    graph[i].add(j);
                    graph[j].add(i);
                }
            }
        }


        for (int i = 0; i < N; i++) {
            List<Integer> childs = graph[i];
            for (int j = 0; j < childs.size(); j++) {

            }
        }

    }


}
