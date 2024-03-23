import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_11050 {
	
	static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());		
		dp = new int [N + 1][K + 1];
		
		bw.write(String.valueOf(getBinomialCofficient(N, K)));
		br.close();
		bw.close();
	}

	private static int getBinomialCofficient(int N, int K) {
		if (dp[N][K] > 0) {
			return dp[N][K];
		}
		
		if (N == K || K == 0) {
			return dp[N][K] = 1;
		}
		
		return dp[N][K] = getBinomialCofficient(N - 1, K - 1) + getBinomialCofficient(N - 1, K);
	}
}
