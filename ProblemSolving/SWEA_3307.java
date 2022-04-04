import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA_3307 {
	static int N, result;
	static int[] seq, dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			seq = new int[N];
			dp = new int[N];
			result = 0;
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++)
				seq[i] = Integer.parseInt(st.nextToken());
			for (int i = 0; i < N; i++) {
				dp[i] = 1;
				for (int j = 0; j < i; j++)
					if (seq[i] > seq[j] && dp[i] < dp[j] + 1)
						dp[i] = dp[j] + 1;
				if (result < dp[i])
					result = dp[i];
			}
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}
