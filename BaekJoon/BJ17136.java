package BackJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class BJ17136 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int answer = Integer.MAX_VALUE;
    static int arr[][] = new int[10][10];
    static int colorPaper[] = new int[6];
    static boolean visited[][] = new boolean[10][10];
    static int N, M;


    public static void main(String[] args) throws IOException {

        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            int len = st.countTokens();
            for (int j = 0; j < len; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for (int i = 1; i <= 5; i++) {
            colorPaper[i] = 5;
        }


        DFS(0, 0,0);

        if(answer == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(answer);



    }

    private static void DFS(int x, int y, int cnt) {
        if (x == 9 && y == 10) {
            answer = Math.min(answer, cnt);
            return;
        }

        if (cnt >= answer) {
            return;
        }
        if (y > 9) {
            DFS(x + 1, 0, cnt);
            return;
        }

        if (arr[x][y] == 1) {
            for(int i =5 ; i>0 ; i--){
                if(colorPaper[i] >0&&check(x,y,i) ){
                    colorPaper[i] --;
                    contactPaper(x,y,i,0);
                    DFS(x,y+1,cnt+1 );
                    colorPaper[i]++;
                    contactPaper(x,y,i,1);

                }
            }
        }else{
            DFS(x,y+1,cnt);
        }

    }

    private static boolean contactPaper(int x, int y, int sizeX, int value) {

        for (int i = x; i < x + sizeX; i++) {
            for (int j = y; j < y + sizeX; j++) {
                arr[i][j] = value;
            }
        }
        return true;

    }

    private static boolean check(int x, int y, int sizeX) {

        for (int i = x; i < x + sizeX; i++) {
            for (int j = y; j < y + sizeX; j++) {
                if (i >= 10 || j >= 10 || arr[i][j] != 1) return false;
            }
        }
        return true;

    }

}
