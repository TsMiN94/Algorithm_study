package BackJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ13458 {
    static int N, A, B;
    static double room[];


    public static void main(String[] args) throws IOException {
        long answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        room = new double[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        long totalStudent = 0;
        for (int i = 0; i < N; i++) {
            room[i] = Double.parseDouble(st.nextToken());
            totalStudent += room[i];
        }
        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        for (int i = 0; i < room.length; i++) {
            room[i] -= A;
            answer++;
            if (room[i] <= 0) continue;
            if (room[i] >= B) {
                double temp = room[i] / B;
                answer += Math.ceil(temp);
            }
            else
                answer++;
        }


        System.out.println(answer);


    }
}
