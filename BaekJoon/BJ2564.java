package BackJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ2564 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        List<Store> list = new ArrayList<>();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            list.add(new Store(dir, dist));
        }
        st = new StringTokenizer(br.readLine());
        int sDir = Integer.parseInt(st.nextToken());
        int sDist = Integer.parseInt(st.nextToken());

        switch (sDir) {
            case 2:
                sDist = x + y + (y - sDist);
                break;
            case 3:
                sDist = x + y + y + (x - sDist);
                break;
            case 4:
                sDist = y +  sDist;
                break;
        }

        for (int i = 0; i < list.size(); i++) {
            Store s = list.get(i);
            int storeDist = s.dist;

            switch (s.dir) {
                case 2:
                    storeDist = x + y + (y- s.dist);
                    break;
                case 3:
                    storeDist = y + x +y + (x- s.dist);
                    break;
                case 4:
                    storeDist = y + s.dist;
                    break;
            }
            int path1 = Math.abs(storeDist - sDist);
            int path2 = ((2 * x) + (2 * y)) - path1;
            int min = path1 < path2 ? path1 : path2;
            answer += min;

        }
        System.out.println(answer);
    }


    static class Store {
        int dir, dist;

        public Store(int dir, int dist) {
            this.dir = dir;
            this.dist = dist;
        }

        @Override
        public String toString() {
            return "Store{" +
                    "dir=" + dir +
                    ", dist=" + dist +
                    '}';
        }
    }
}

