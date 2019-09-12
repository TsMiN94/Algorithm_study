import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
	public static void main(String[] args) {
		Solution s = new Solution();
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		System.out.println(s.solution(str));
	}

	public static class Solution {
		public int solution(String str) {
			int answer = 0;
			answer = str.length();
			int size = 1;
			int cnt = 1;
			String s = "";
			while (str.length() != size) {

				int startIndex, endIndex;

				int len = str.length();

				for (int j = 0; j < len; j += size) {

					startIndex = j;
					endIndex = j + size;
					if (str.length() / 2 < size) {
						s = s + str;
						break;
					}
					if (startIndex + size > len || endIndex + size > len) {
						s = s + cnt + str.substring(startIndex, len);
						break;
					}
					if (str.substring(startIndex, endIndex).equals(str.substring(startIndex + size, endIndex + size))) {

						cnt++;
					} else {
						s = s + cnt + str.substring(startIndex, endIndex);

						cnt = 1;
					}
				}

				cnt = 1;
				s = s.replace("1", "");

				if (s.length() < answer)
					answer = s.length();
				s = "";
				size++;
			}

			return answer;
		}
	}

}
