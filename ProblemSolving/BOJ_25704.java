import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_25704 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int P = Integer.parseInt(br.readLine());

		int ans = P;
		if (N >= 20) {
			ans = Math.min((int) (P * 0.75), ans);
		}

		if (N >= 15) {
			ans = Math.min((P - 2000), ans);
		}

		if (N >= 10) {
			ans = Math.min((int) (P * 0.9), ans);
		}

		if (N >= 5) {
			ans = Math.min((P - 500), ans);
		}
		
		bw.write(String.valueOf(ans < 0 ? 0 : ans));
		br.close();
		bw.close();
	}
}
