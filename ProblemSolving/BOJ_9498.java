import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_9498 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int score = Integer.parseInt(br.readLine());
		char ans = 'F';
		if (score >= 90) {
			ans = 'A';
		} else if (score >= 80) {
			ans = 'B';
		} else if (score >= 70) {
			ans = 'C';
		} else if (score >= 60) {
			ans = 'D';
		}
		bw.write(ans);
		br.close();
		bw.close();
	}
}
