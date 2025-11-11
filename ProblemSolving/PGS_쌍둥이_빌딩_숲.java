
public class PGS_쌍둥이_빌딩_숲 {

	class Solution {
		public int solution(int n, int count) {
			final int MOD = 1_000_000_007;
			long[][] dp = new long [n + 1][count + 1];
			dp[1][1] = 1;

			for (int i = 2; i < n + 1; i++) {
				for (int j = 1; j < count + 1; j++) {
					dp[i][j] = (dp[i - 1][j] * (i - 1) * 2 + dp[i - 1][j - 1]) % MOD;
				}
			}
			return (int) dp[n][count];
		}
	}
	
}
