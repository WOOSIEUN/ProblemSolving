import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_28702 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int num = -1, idx = -1;
		for (int i = 0; i < 3; i++) {
			String input = br.readLine();
			if ('0' <= input.charAt(0) && input.charAt(0) <= '9') {
				num = Integer.parseInt(input);
				idx = i;
			}
		}
		
		int ans = num + 3 - idx;
		StringBuilder sb = new StringBuilder();
		if (ans % 15 == 0) {
			sb.append("FizzBuzz");
		} else if (ans % 3 == 0) {
			sb.append("Fizz");
		} else if (ans % 5 == 0) {
			sb.append("Buzz");
		} else {
			sb.append(ans);
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}
