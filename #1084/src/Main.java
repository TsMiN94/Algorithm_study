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
		// �ڸ����� Ȯ��
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
			 * ��� �ִ� ����ū����θ� ���ڸ� ����������� ���ǽļ���Ⱑ �����.... ���ڸ� ��� ���� ū ���� ���ʴ�� ��鼭 ���� �ִ���
			 * �����... ���ڸ� ��� �� �ִ����� üũ�ؾ��ϰ� �� ���ڰ����� �����Ͽ� ����ū���� �������ϴ� ���ǽ��� ��������...
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

			if (case1_Cnt > case2_Cnt) { // �ڸ����� �� ���ٴ� ����
				System.out.println("case 1 =" + case1);
			} else {
				System.out.println("case 2 =" + case2);
			}

		}
	}
}
