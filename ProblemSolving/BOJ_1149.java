import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_1149 {
	static int N;
	static int [] house;
	static int [][] dp;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		house = new int[3];
		dp = new int[N+1][3];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) 
				house[j] = Integer.parseInt(st.nextToken());
			dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + house[0]; 
			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + house[1]; 
			dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + house[2]; 
		}
		bw.write(""+Math.min(dp[N][0], Math.min(dp[N][1], dp[N][2])));
		br.close();
		bw.close();
	}
}
