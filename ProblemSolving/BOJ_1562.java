import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_1562 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		final int MOD = 1000000000;
		long ans = 0;
		
		int N = Integer.parseInt(br.readLine());
		long[][][] dp = new long [N + 1][10][(1 << 10)];
		for (int i = 1; i <= 9; i++) {
			dp[1][i][1 << i] = 1;
		}
		
		for (int i = 2; i < N + 1; i++) {
			for (int curNum = 0; curNum < 10; curNum++) {
				for (int visited = 0; visited < (1 << 10); visited++) {
					if (curNum == 0) {
						dp[i][curNum][visited | (1 << curNum)] += dp[i - 1][curNum + 1][visited] % MOD;
					} else if (curNum == 9) {
						dp[i][curNum][visited | (1 << curNum)] += dp[i - 1][curNum - 1][visited] % MOD;						
					} else {
						dp[i][curNum][visited | (1 << curNum)] += dp[i - 1][curNum - 1][visited] % MOD + dp[i - 1][curNum + 1][visited] % MOD;						
					}
				}
			}
		}
		
		for (int i = 0; i <= 9; i++) {
			ans = (ans + dp[N][i][(1 << 10) - 1]) % MOD;
		}
		
		bw.write(String.valueOf(ans));
		br.close();
		bw.close();
	}
}
