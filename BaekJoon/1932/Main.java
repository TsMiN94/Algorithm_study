import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {

	private static int n, max = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();

		int arr[][] = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				arr[i][j] = sc.nextInt();
				if (j == 1)
					arr[i][j] = arr[i - 1][j] + arr[i][j];
				else if (j == 1)
					arr[i][j] = arr[i][j] + arr[i - 1][j];
				else
					arr[i][j] = Math.max(arr[i - 1][j - 1], arr[i - 1][j]) + arr[i][j];
				if (max < arr[i][j])
					max = arr[i][j];
			}
		}

		System.out.println(max);

	}

}
