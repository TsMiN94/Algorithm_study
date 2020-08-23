package BackJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ11724 {
    static int N, size;
    static int arr[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        size = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];
        //배열값 모두 본인의 인덱스값으로 갱신
        makeSet();

        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            // 각각의 간선을 union
            union(from, to);
        }

        //최종 부모의 값으로 갱신이 되지 않은 정점을 위해서 업데이트를 위한 작업
        for (int i = 1; i <= N; i++) {
            arr[i] = findSet(arr[i]);
        }

        int answer = 0;
        // 배열의 값이 자기 자신의 인덱스일경우 독립적인 그룹이 있다는것이므로 answer++
        for (int i = 1; i <= N; i++) {
            if (i == arr[i]) answer++;
        }

        System.out.println(answer);
    }


    public static int findSet(int x) {
        if (arr[x] == x) return x;
        else {
            return arr[x] = findSet(arr[x]);
        }
    }

    public static void makeSet() {
        for (int i = 1; i <= N; i++)
            arr[i] = i;
    }


    public static void union(int x, int y) {
        x = findSet(x);
        y = findSet(y);

        if (x != y) {
            arr[y] = x;
        }
    }

}
