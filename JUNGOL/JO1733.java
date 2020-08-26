package BackJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class JO1733 {
    static int N = 20;
    static int arr[][] ;
    static int temp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        arr = new int[20][20];
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < N; j++) {
                if (arr[i][j] != 0) {
                    if (dia(i, j) ) {
                        System.out.println(arr[i][j]);
                        System.out.println(i+" "+ j);
                        return ;
                    }
                    else if (rdia(i, j) ) {
                        System.out.println(arr[i][j]);
                        System.out.println((i+4)+" "+ (j-4));
                        return ;
                    }
                    else if (ver(i, j)) {
                        System.out.println(arr[i][j]);
                        System.out.println(i+" "+ j);
                        return ;
                    }
                    else if(hor(i, j)) {
                        System.out.println(arr[i][j]);
                        System.out.println(i+" "+ j);

                        return ;
                    }
                }
            }
        }
        System.out.println(0);

    }

    static public boolean dia(int x, int y) {
        //여기 자꾸 IndexOutOfBounds Exception이 발생하는데
        // 자꾸 arr[20][y] 의 값을 건드리고 있다고 하는데 이해가 안됩니다. ㅠㅠㅠㅠㅠㅠ
        temp = arr[x][y];
        for (int i = 1; i <= 4; i++) {
            if (arr[x + i][y + i] != temp) return false;
        }
        if (arr[x + 5][y + 5] == temp) return false;
        else if (arr[x - 1][y - 1] == temp) return false;
        else return true;
    }

    static public boolean rdia(int x, int y) {
        if (y < 4) return false;
        temp = arr[x][y];
        for (int i = 1; i <= 4; i++) {
            if (arr[x + i][y - i] != temp) return false;
        }
        if (arr[x + 5][y - 5] == temp) return false;
        else if (arr[x - 1][y + 1] == temp) return false;
        else return true;
    }

    static public boolean ver(int x, int y) {
        temp = arr[x][y];
        for (int i = 1; i <= 4; i++) {
            if (arr[x + i][y] != temp) return false;
        }
        if (arr[x + 5][y] == temp) return false;
        else if (arr[x - 1][y] == temp) return false;
        else return true;
    }

    static public boolean hor(int x, int y) {
        temp = arr[x][y];
        for (int i = 1; i <= 4; i++) {
            if (arr[x][y + i] != temp) return false;
        }
        if (arr[x][y + 5] == temp) return false;
        else if (arr[x][y - 1] == temp) return false;
        else return true;
    }

}
