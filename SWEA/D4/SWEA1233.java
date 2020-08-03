package SWEA_D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D41233 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, answer;
    static Node[] nodes;

    public static void main(String[] args) throws IOException {
        for (int t = 1; t <= 10; t++) {
            answer = 1;
            int N = Integer.parseInt(br.readLine());
            nodes = new Node[N + 1];
            for (int i = 1; i <= N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken();
                String value = st.nextToken();
                Integer left = null, right = null;
                if (st.hasMoreTokens())
                    left = Integer.parseInt(st.nextToken());
                if (st.hasMoreTokens())
                    right = Integer.parseInt(st.nextToken());

                nodes[i] = new Node(left, right, value);
            }
            DFS(1);
            System.out.println("#"+t+" "+answer);
        }
    }

    static String oper = "*/-+";

    private static void DFS(Integer i) {
        if (i != null && answer == 1) {
            Node curNode = nodes[i];
            DFS(curNode.left);
            DFS(curNode.right);
            if (oper.contains(curNode.value)) {
                if (curNode.left == null || curNode.right == null) {
                    answer = 0;
                } else {
                    Node left = nodes[curNode.left];
                    Node right = nodes[curNode.right];
                    if (oper.contains(left.value) || oper.contains(right.value)) {
                        answer = 0;
                        return;
                    }
                    curNode.value = "0";
                }
            } else {
                if (curNode.left != null || curNode.right != null) {
                    answer = 0;
                    return;
                }
            }
        }
    }

    static class Node {
        Integer left, right;
        String value;

        public Node(Integer left, Integer right, String value) {
            this.left = left;
            this.right = right;
            this.value = value;
        }
    }
}
