import java.util.*;

public class PGS_완전범죄 {

	public int solution(int[][] info, int n, int m) {
		final int MAX = 120;
		int[][] dp = new int[info.length + 1][m];
		for(int i = 0; i < dp.length; i++){
			Arrays.fill(dp[i], MAX);
		}

		dp[0][0] = 0;
		for (int i = 1; i < dp.length; i++){
			int a = info[i - 1][0];
			int b = info[i - 1][1];
			for (int j = 0; j < m; j++){
				dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + a);
				if (j + b < m){
					dp[i][j + b] = Math.min(dp[i][j + b], dp[i-1][j]);
				}
			}
		}

		int answer = MAX;
		for (int j = 0; j < m; j++) {
			answer = Math.min(answer, dp[info.length][j]);
		}

		return answer >= n ? -1 : answer;
	}
	
}
