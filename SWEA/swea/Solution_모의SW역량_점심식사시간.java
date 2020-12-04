package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

public class Solution_모의SW역량_점심식사시간 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int answer = 0;
    static int N, M;
    static int map[][];
    static List<Room> roomList;
    static List<Room> escape;
    static boolean[] selected;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            answer = Integer.MAX_VALUE;
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];

            roomList = new ArrayList<>();
            escape = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] == 1) {
                        roomList.add(new Room(i, j));
                    } else if (map[i][j] > 1) {
                        Room r = new Room(i, j);
                        r.dist = map[i][j];
                        escape.add(r);
                    }
                }
            }
            selected = new boolean[roomList.size()];

            subset(0);

            System.out.println("#" + t + " " + answer);
        }
    }

    private static void subset(int cnt) {
        if (cnt == roomList.size()) {
            Room aExit = escape.get(0);
            Room bExit = escape.get(1);


            Queue<Room> Aescape = new PriorityQueue<>();
            Queue<Room> Bescape = new PriorityQueue<>();
            Queue<Room> Astair = new LinkedList<>();
            Queue<Room> Bstair = new LinkedList<>();


            for (int i = 0; i < roomList.size(); i++) {
                if (selected[i]) {
                    Room r = roomList.get(i);
                    r.dist = Math.abs(r.x - aExit.x) + Math.abs(r.y - aExit.y);
                    Aescape.add(r);
                } else {
                    Room r = roomList.get(i);
                    r.dist = Math.abs(r.x - bExit.x) + Math.abs(r.y - bExit.y);
                    Bescape.add(r);
                }
            }

            int atime = 0;
            while (!Aescape.isEmpty() || !Astair.isEmpty()) {

                while (!Astair.isEmpty()) {
                    if (atime - Astair.peek().dist == aExit.dist) {
                        Astair.poll();
                    } else {
                        break;
                    }
                }

                while (!Aescape.isEmpty() && Aescape.peek().dist <= atime) {
                    if (Astair.size() < 3) {
                        Room r = Aescape.poll();
                        r.dist = atime;
                        Astair.add(r);
                    } else
                        break;
                }
                atime++;
            }
            int btime = 0;
            while (!Bescape.isEmpty() || !Bstair.isEmpty()) {
                while (!Bstair.isEmpty()) {
                    if (btime - Bstair.peek().dist == bExit.dist) {
                        Bstair.poll();
                    } else {
                        break;
                    }
                }
                while (!Bescape.isEmpty() && Bescape.peek().dist <= btime) {
                    if (Bstair.size() < 3) {
                        Room r = Bescape.poll();
                        r.dist = btime;
                        Bstair.add(r);
                    } else break;
                }
                btime++;
            }

            int minimum = Math.max(atime, btime);
            answer = Math.min(answer, minimum);
            return;
        }

        selected[cnt] = true;
        subset(cnt + 1);

        selected[cnt] = false;
        subset(cnt + 1);

    }

    public static class Room implements Comparable<Room> {
        int x, y, dist;

        public Room(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Room o) {
            return Integer.compare(this.dist, o.dist);
        }
    }
}
