package BackJun;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ14002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];
        int LIS[] = new int[N];
        List graph[] = new List[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            graph[i] = new ArrayList<Integer>();
        }

        //앞에서부터 증가하는 부분수열 LIS 배열 값 갱신
        for (int i = 0; i < N; i++) {
            LIS[i] = 1;

            graph[i].add(arr[i]);
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && LIS[i] < LIS[j] + 1) {
                    LIS[i] = LIS[j] + 1;
                    graph[i] = new ArrayList<Integer>();
                    for (int k = 0; k < graph[j].size(); k++) {
                        graph[i].add(graph[j].get(k));
                    }
                    graph[i].add(arr[i]);
                }

            }
        }
        int idx = 0;
        int max = 0;
        for (int i = 0; i < N; i++) {
            if (max < LIS[i]) {
                idx = i;
                max = LIS[i];
            }
        }
        List<Integer> list = graph[idx];
        System.out.println(LIS[idx]);
        for (int i = 0; i < list.size(); i++)
            System.out.print(list.get(i) + " ");
    }
}
