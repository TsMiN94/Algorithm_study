package BackJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ11403 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int arr[][], dist[][];
    static List<Integer> graph[];

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        dist = new int[N][N];
        graph = new List[N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }


        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int t = Integer.parseInt(st.nextToken());
                if (t == 1) {
                    arr[i][j] = 1;
                    dist[i][j] = 1;
                }
            }
        }
        //경유지
        for (int k = 0; k < N; k++) {
            //출발지
            for (int i = 0; i < N; i++) {
                if (i == k) continue;
                //도착지
                for (int j = 0; j < N; j++) {
                    if ( j == k) continue;
                    if (arr[i][k] == 1 && arr[k][j] == 1) {
                        arr[i][j] = 1;
                    }
                }

            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(arr[i][j] +" ");
            }
            System.out.println();
        }

    }


    static public class Edge {
        int aNode, bNode;

        public Edge(int aNode, int bNode) {
            this.aNode = aNode;
            this.bNode = bNode;
        }
    }


}
