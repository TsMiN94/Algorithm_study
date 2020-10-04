package BackJun;

import java.util.*;


public class BJ13549 {
    static int N, K;
    static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();


        int dp[] = new int[100001];
        Arrays.fill(dp, Integer.MAX_VALUE);
        Queue<Point> q = new PriorityQueue<>();
        q.add(new Point(N, 0));
        while (!q.isEmpty()) {
            Point curPoint = q.poll();
            if (curPoint.time > dp[curPoint.p]) continue;
            if (curPoint.p == K) {
                answer = curPoint.time;
                break;
            }
            if (curPoint.p * 2 < 100001) {
                if (dp[curPoint.p * 2] > curPoint.time) {
                    dp[curPoint.p * 2] = curPoint.time;
                    q.add(new Point(curPoint.p * 2, curPoint.time));
                }
            }
            if (curPoint.p - 1 >= 0) {
                if (dp[curPoint.p - 1] > curPoint.time) {
                    dp[curPoint.p - 1] = curPoint.time+1;
                    q.add(new Point(curPoint.p - 1, curPoint.time + 1));
                }
            }
            if (curPoint.p + 1 < 100001) {
                if (dp[curPoint.p + 1] > curPoint.time) {
                    dp[curPoint.p + 1] = curPoint.time+1;
                    q.add(new Point(curPoint.p + 1, curPoint.time + 1));
                }
            }

        }
        System.out.println(answer);
    }

    public static class Point implements Comparable<Point> {

        int p, time;

        public Point(int p, int time) {
            this.p = p;
            this.time = time;
        }

        @Override
        public int compareTo(Point o) {
            return Integer.compare(this.time, o.time);
        }
    }
}
