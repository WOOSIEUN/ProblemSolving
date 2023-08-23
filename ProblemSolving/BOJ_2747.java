import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_2747 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int [N + 1];
		dp[0] = 0;
		dp[1] = 1;
		for (int i = 2; i < N + 1; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		bw.write(String.valueOf(dp[N]));
		br.close();
		bw.close();
	}
}
