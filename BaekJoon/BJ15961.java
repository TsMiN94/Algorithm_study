package BackJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BJ15961 {
    static int N, d, k, c;
    static int arr[];
    static int kindArr[];
    static int answer = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        kindArr = new int[d + 1];
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int kindCnt = 0;
        for (int i = 0; i < k; i++) {
            //새로운거만 먹었을때 카운트
            if (kindArr[arr[i]] == 0)
                kindCnt++;
            kindArr[arr[i]]++;
        }
        int s = 1;
        int e = k;
        answer = kindCnt;
        for (int i = s; s < N; s++) {

            if (answer <= kindCnt) {
                if (kindArr[c] == 0) answer = kindCnt+1;
                else
                    answer = kindCnt;
            }
            //앞에꺼 빼보기
            kindArr[arr[s - 1]]--;

            ///뺏는데 한번도 안먹은거였다면 종류 -1
            if (kindArr[arr[s - 1]] == 0) kindCnt--;

            // 다시 k 앞에꺼 종류를 먹었는지 체크
            if (kindArr[arr[(s + e - 1) % N]] == 0) kindCnt++;
            // 먹었다는걸 체크
            kindArr[arr[(s + e - 1) % N]]++;
        }
        System.out.println(answer);

    }


}
