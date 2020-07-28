import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class Main {
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {

		int n = Integer.parseInt(reader.readLine());

		String command[] = new String[n];
		for (int i = 0; i < n; i++) {
			command[i] = reader.readLine();
		}

		solution(command);

		writer.flush();
		writer.close();
	}

	public static void solution(String[] command) throws IOException {

		String userCommand = "";
		String fileType = "";
		int cnt = 0;
	

		String str = null;
		for (int j = 0; j < command[0].length(); j++) {
			cnt = 0;
			str = command[0].charAt(j) + "";
			for (int i = 1; i < command.length; i++) {
				if (!(command[i].charAt(j) + "").equals(str)) {
					userCommand += "?";
					break;
				}
				cnt++;
			}
			if(cnt == command.length-1) {
				userCommand += str;
			}
		}

		writer.write(userCommand);
		writer.newLine();
	}

}
