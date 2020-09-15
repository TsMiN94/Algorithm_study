import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	private static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
	private static int n, zero_cnt = 0, one_cnt = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		n = Integer.parseInt(reader.readLine());
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(reader.readLine());

		}
		for (int i = 0; i < n; i++) {
			fibo(arr[i]);
			System.out.println(zero_cnt + " " + one_cnt);
			zero_cnt =0;
			one_cnt =0;
		}
	}
	
	

	public static int fibo(int n) {
		if (n == 0) {
			//System.out.println("0");
			zero_cnt++;
			return 0;
		} else if (n == 1) {
			//System.out.println("1");
			one_cnt++;
			return 1;
		} else {
			return fibo(n - 1) + fibo(n - 2);
		}
	}
}
