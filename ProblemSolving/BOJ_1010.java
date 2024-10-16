import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_1010 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[][] dp = new int[M + 1][N + 1];
			sb.append(combi(M, N, dp)).append("\n");
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
	
	public static int combi(int N, int R, int[][] dp) {
		 if (dp[N][R] > 0) {
			 return dp[N][R];
		 }

		 if (N == R || R == 0) {
			return dp[N][R] = 1;
		 }
		 
		 return combi(N - 1, R - 1, dp) + combi(N - 1, R, dp);
	}
}
