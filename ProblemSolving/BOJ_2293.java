import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_2293 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());	
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] dp = new int [K + 1];
		
		dp[0] = 1;
		
		for (int i = 0; i < N; i++) {
			int coin = Integer.parseInt(br.readLine());
			for (int j = coin; j < K + 1; j++) {
				dp[j] += dp[j - coin];
			}
		}		
		
		bw.write(String.valueOf(dp[K]));
		br.close();
		bw.close();
	}
}
