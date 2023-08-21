import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_7579 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int ans = 0;
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] memoryBytes = new int [N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N + 1; i++) {
			memoryBytes[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] costs = new int [N + 1];
		int costSum = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N + 1; i++) {
			costs[i] = Integer.parseInt(st.nextToken());
			costSum += costs[i];
		}
		
		int[][] dp = new int [N + 1][costSum + 1];
		for (int i = 1; i < N + 1; i++) {
			for (int j = 0; j <= costSum; j++) {
				if (costs[i] <= j) {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - costs[i]] + memoryBytes[i]);
				} else {
					dp[i][j] = dp[i - 1][j];					
				}
			}
		}
		
		for (int i = 0; i <= costSum; i++) {
			if (dp[N][i] >= M) {
				ans = i;
				break;
			}
		}
		
		bw.write(String.valueOf(ans));
		br.close();
		bw.close();
	}
}
