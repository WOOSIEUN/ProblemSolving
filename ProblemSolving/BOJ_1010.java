import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_1010 {
	
	static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());		
		dp = new int[30][30];
		
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			sb.append(combi(M, N)).append("\n");
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
	
	public static int combi(int N, int R) {
		 if (dp[N][R] > 0) {
			 return dp[N][R];
		 }

		 if (N == R || R == 0) {
			return dp[N][R] = 1;
		 }
		 
		 return dp[N][R] = combi(N - 1, R - 1) + combi(N - 1, R);
	}
}
