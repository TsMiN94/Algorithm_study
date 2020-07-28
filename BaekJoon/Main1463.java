import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	private static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
	private static int cnt1, cnt2 = 0;
	private static int x, tmp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		x = Integer.parseInt(reader.readLine());
		tmp = x;

		solution();
	}

	private static void solution() throws IOException {

		while (x != 1) {
			if (divide3() || divide2()) {
				cnt1++;
				continue;
			} else {
				sub();
				cnt1++;
			}

		}
		x = tmp;

		sub();
		cnt2++;
		while (x != 1) {
			if (divide3() || divide2()) {
				cnt2++;
				continue;
			} else {
				sub();
				cnt2++;
			}
		}

		if (cnt1 < cnt2)
			System.out.println(cnt1);
		else {
			System.out.println(cnt2);
		}
	}

	private static boolean divide3() {
		if (x % 3 == 0) {
			x = x / 3;
			return true;
		} else
			return false;
	}

	private static boolean divide2() {
		if (x % 2 == 0) {
			x = x / 2;
			return true;
		} else
			return false;
	}

	private static void sub() {
		x = x - 1;

	}
}
