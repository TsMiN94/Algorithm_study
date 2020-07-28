package Kakao2020Blind;

public class Wall {
    public static void main(String[] args) {

    }

    static class Solution {
        int distLen ;
        int []dist;
        int []permArr;
        public int solution(int n, int[] weak, int[] dist) {
            int answer = 1;
            boolean min = false;
            int freindArr[];
            distLen = dist.length;
            this.dist = dist;

            for (int i = answer; i < dist.length; i++) {
                freindArr = new int[answer];
                if (check(freindArr, weak, dist)) {
                    return answer;
                }
            }

            return answer;
        }

        private boolean check(int[] freindArr, int[] weak, int[] dist) {
            boolean min = false;


            return min;
        }

        public void permutation(int depth, boolean[] visit) {

            if (depth == distLen) {
                return;
            }
            for (int i = 0; i < dist.length; i++) {
                if (!visit[i]) {
                    permArr[depth] = dist[i];
                    visit[i] = true;
                    permutation(depth + 1, visit);
                    visit[i] = false;
                }
            }
        }


    }
}
