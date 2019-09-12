
public class Main {
	public static void main(String[] args) {

		int weak[] = { 1, 5, 6, 10 };
		int dist[] = { 1, 2, 3, 4 };

		Solution.solution(12, weak, dist);

	}

	public static class Solution {
		public static int solution(int n, int[] weak, int[] dist) {
			int answer = 0;
			int tmp = 0;
			int startIndex =0;
			
			boolean repair[] = new boolean[dist.length];
			
			for (int i = dist.length - 1; i > 0; i--) {
				for(int j = 0 ; j<weak.length;j++) {
					int res =weak[j]+dist[dist.length-1];
				}
			}

			return answer;
		}
	}
}
