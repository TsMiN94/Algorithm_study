import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
	static int money, n;
	static int case1_Cnt = 1, case2_Cnt = 1;

	static String cost[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		n = Integer.parseInt(reader.readLine());
		cost = reader.readLine().split(" ");
		money = Integer.parseInt(reader.readLine());

		calc();

	}

	private static void calc() {

		String case1 = "1";

		int case1_Money = money - Integer.parseInt(cost[1]);
		// 자릿수를 확인
		while (true) {
			if (case1_Money <= 0) {
				break;
			}
			case1_Money -= Integer.parseInt(cost[0]);
			case1 += "0";
			case1_Cnt++;
		}

		//
		int case2_Money = money;
		int i = cost.length - 1;
		String case2 = "";

		while (true) {
			/*
			 * 살수 있는 가장큰수들로만 숫자를 구매했을경우 조건식세우기가 어려움.... 숫자를 사되 가장 큰 수를 차례대로 사면서 돈은 최대한
			 * 써야함... 숫자를 몇개살 수 있는지를 체크해야하고 그 숫자갯수를 조합하여 가장큰수를 만들어야하는 조건식을 세워야함...
			 * 
			 * 
			 */

			if (i < 0 || case2_Money == 0)

				if (case2_Money - Integer.parseInt(cost[i]) > 0) {
					case2_Money -= Integer.parseInt(cost[i]);
					case2 += i;
					case2_Cnt++;
				} else {
					i--;
				}

			if (case1_Cnt > case2_Cnt) { // 자릿수가 더 많다는 증거
				System.out.println("case 1 =" + case1);
			} else {
				System.out.println("case 2 =" + case2);
			}

		}
	}
}
