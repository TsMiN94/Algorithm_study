import java.util.HashMap;

public class Main {
	public static void main(String[] args) {
		String words[] = { "frodo", "front", "frost", "frozen", "frame", "kakao" };
		String queries[] = { "fro??", "????o", "fr???", "fro???", "pro?" };

		int[] answer = Solution.solution(words, queries);
		for (int i = 0; i < queries.length; i++) {
			System.out.println(answer[i]);
		}
	}

	public static class Solution {
		public static int[] solution(String[] words, String[] queries) {
			int[] answer = {};

			HashMap<String, Integer> h = new HashMap<>();

			answer = new int[queries.length];
			int qIndex = 0;
			int cnt = 0;
			for (int i = 0; i < queries.length; i++) {

			
				for (int j = 0; j < queries[i].length(); j++)
					if (queries[i].charAt(j) != '?') {
						qIndex = j;
						break;
					}

				String tmp = queries[i].replace("?", "");


				for (int j = 0; j < words.length; j++) {
					if (words[j].length() == queries[i].length() && words[j].contains(tmp)) {

						if (queries[i].charAt(qIndex) == words[j].charAt(qIndex)) {
							cnt++;

						}
					}
				}
				h.put(tmp, cnt);
				answer[i] = cnt;
				cnt = 0;
			}

			return answer;
		}
	}
}
