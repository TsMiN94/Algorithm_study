package BackJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

import java.util.StringTokenizer;

public class BJ12015 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];
        int LIS[] = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int size = 0;
        for (int i = 0; i < N; i++) {
            int index = Arrays.binarySearch(LIS, 0, size, arr[i]);
            index = Math.abs(index) - 1;
            if (index < 0) {
                LIS[0] = arr[i];

            } else {
                if (LIS[index]!=0 && arr[i] == LIS[index + 1])
                    LIS[index + 1] = arr[i];
                else
                    LIS[index] = arr[i];
            }
            if (index == size)
                size++;

        }

        System.out.println(size);
    }
}
