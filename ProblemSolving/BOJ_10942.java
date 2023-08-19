import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_10942 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] sequence = new int [N];
		boolean[][] dp = new boolean [N][N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			sequence[i] = Integer.parseInt(st.nextToken());
			dp[i][i] = true;
			if (i != 0 && sequence[i - 1] == sequence[i]) {
				dp[i - 1][i] = true;
			}
		}
		
		for (int i = N - 3; i >= 0; i--) {
			for (int j = i + 2; j < N; j++) {
				if (dp[i + 1][j - 1] && sequence[i] == sequence[j]) {
					dp[i][j] = true;
				}
			}
		}
		
		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			sb.append(dp[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] ? 1 : 0).append("\n");
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}
