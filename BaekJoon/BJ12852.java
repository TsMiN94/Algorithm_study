package BackJun;

import java.util.*;

public class BJ12852 {
    static int MAX = 1000001;

    //index로 가는 가장 최소의 값 저장
    static int dp[] = new int[MAX];
    //index로 가는 가장 최소의 인덱스 저장
    static int prev[] = new int[MAX];
    static int start;
    static int answer = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        start = sc.nextInt();
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[start] = 0;

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(start, 0));

        while (!q.isEmpty()) {
            Point cur = q.poll();

            if (cur.x == 1) {
                answer = Math.min(answer, cur.v);
                break;
            }
            if (cur.x % 3 == 0) {
                if (dp[cur.x / 3] > cur.v + 1) {
                    prev[cur.x / 3] = cur.x;
                    dp[cur.x / 3] = cur.v + 1;
                    q.add(new Point(cur.x / 3, cur.v + 1));
                }
            }
            if (cur.x % 2 == 0) {
                if (dp[cur.x / 2] > cur.v + 1) {
                    prev[cur.x / 2] = cur.x;
                    dp[cur.x / 2] = cur.v + 1;
                    q.add(new Point(cur.x / 2, cur.v + 1));
                }
            }
            if (cur.x - 1 >= 0 && dp[cur.x - 1] > cur.v + 1) {
                prev[cur.x - 1] = cur.x;
                dp[cur.x - 1] = cur.v + 1;
                q.add(new Point(cur.x - 1, cur.v + 1));
            }

        }
        System.out.println(dp[1]);
        int t = prev[1];
        List<Integer> list = new ArrayList<>();
        list.add(1);
        while (t != 0) {
            list.add(t);
            t = prev[t];
        }
        Collections.sort(list,Comparator.reverseOrder());
        for(int a : list)
            System.out.print(a + " ");
    }

    public static class Point implements Comparable<Point> {
        int x, v;

        public Point(int x, int v) {
            this.x = x;
            this.v = v;
        }

        @Override
        public int compareTo(Point o) {
            return Integer.compare(this.x, o.x);
        }


    }
}