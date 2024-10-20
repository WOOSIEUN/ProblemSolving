import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BOJ_3687 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		final int MAX_MATCHES = 101;
		long[] dp = makeMinMatchesDp(MAX_MATCHES);
				
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			sb.append(dp[N]).append(" ");
			
            if (N % 2 == 0) {
                sb.append(addOneString(N / 2)).append("\n");
            } else {
                sb.append("7").append(addOneString((N - 3) / 2)).append("\n");
            }
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
	
	private static String addOneString(int N) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append("1");
        }
        return sb.toString();
    }

	private static long[] makeMinMatchesDp(int MAX_MATCHES) {
		long[] dp = new long [MAX_MATCHES];
		
		Arrays.fill(dp, Long.MAX_VALUE);
		dp[2] = 1;
		dp[3] = 7;
		dp[4] = 4;
		dp[5] = 2;
		dp[6] = 6;
		dp[7] = 8;
		dp[8] = 10;
		
		for (int i = 9; i < MAX_MATCHES; i++) {
		    for (int j = 2; j <= 7; j++) {
		        String num = String.valueOf(dp[i - j]) + String.valueOf(j == 6 ? "0" : dp[j]);
		        dp[i] = Math.min(Long.parseLong(num), dp[i]);
		    }
		}
		
		return dp;
	}
}
