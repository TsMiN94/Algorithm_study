package BackJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ17143 {
    static Shark map[][];
    static int R, C;
    static Shark[] sharks;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int size = Integer.parseInt(st.nextToken());

        sharks = new Shark[size];
        map = new Shark[R][C];
        int test[][] = new int[R][C];
        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            sharks[i] = new Shark(r, c, s, d, z);
            map[r][c] = sharks[i];
            test[r][c] = 1;
        }
        int time = 0;
        int answer = 0;
        int test2[][] = new int[R][C];
        while (time < C) {
            System.out.println("time is " + (time + 1));

            for (int t[] : test) System.out.println(Arrays.toString(t));

            for (int i = 0; i < R; i++) {
                if (map[i][time] != null) {
                    answer += map[i][time].z;
                    map[i][time] = null;
                    break;
                }
            }
            Shark tempMoveArr[][] = new Shark[R][C];
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (map[i][j] != null) {
                        Shark nextShark = moveShark(map[i][j]);
                        int r = nextShark.x;
                        int c = nextShark.y;
                        int s = nextShark.s;
                        int d = nextShark.d;
                        int z = nextShark.z;
                        nextShark = new Shark(r, c, s, d, z);
                        System.out.println(map[i][j].x + " , " + map[i][j].y + " ->" + nextShark.x + " , " + nextShark.y);
                        if (tempMoveArr[r][c] != null) {
                            if (tempMoveArr[r][c].z < nextShark.z) {
                                tempMoveArr[r][c] = nextShark;
                                test[r][c] = 1;
                                continue;
                            }
                        }
                        else {
                            tempMoveArr[r][c] = new Shark(r, c, s, d, z);
                            test2[r][c] = 1;
                        }
                    }
                }
            }
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (tempMoveArr[i][j] != null) {
                        System.out.println(i + "," + j);
                    }
                }
            }

            System.out.println("next Shark ");
            for (int t[] : test2) System.out.println(Arrays.toString(t));
            test = new int[R][C];
            map = new Shark[R][C];
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (tempMoveArr[i][j] != null) {
                        Shark shark = tempMoveArr[i][j];
                        int r = shark.x;
                        int c = shark.y;
                        int s = shark.s;
                        int d = shark.d;
                        int z = shark.z;
                        map[i][j] = new Shark(r, c, s, d, z);
                        test[i][j] = 1;
                    }
                }
            }

            time++;
            System.out.println(answer);
        }

        System.out.println(answer);

    }

    private static Shark moveShark(Shark shark) {
        Shark next = null;
        int r = shark.x;
        int c = shark.y;
        int s = shark.s;
        int d = shark.d;
        int z = shark.z;
        if (d == 1 || d == 2) {
            s = s % (R * 2 - 2);
        } else {
            s = s % (C * 2 - 2);
        }
        while (s > 0) {
            if (d == 1) {
                if (r - 1 < 0) {
                    r = 1;
                    d = 2;
                } else {
                    r--;
                }
            } else if (d == 2) {
                if (r + 1 >= R) {
                    r = r - 1;
                    d = 1;
                } else {
                    r++;
                }
            } else if (d == 3) {
                if (c + 1 >= C) {
                    c = c-1;
                    d = 4;
                } else {
                    c++;
                }
            } else if (d == 4) {
                if (c -1 < 0) {
                    c =  1;
                    d = 3;
                } else {
                    c--;
                }
            }
            s--;
        }

        next = new Shark(r, c, shark.s, d, z);
        System.out.println(next);
        return next;
    }

    public static class Shark {
        int x, y, s, d, z;

        public Shark(int x, int y, int s, int d, int z) {
            this.x = x;
            this.y = y;
            this.s = s;
            this.d = d;
            this.z = z;
        }

        @Override
        public String toString() {
            return "Shark{" +
                    "x=" + x +
                    ", y=" + y +
                    ", z = " + z +
                    '}';
        }
    }
}
