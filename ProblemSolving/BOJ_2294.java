import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_2294 {
	static int N, tmp;
	static int [] coin;
	static int [] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		coin = new int [N];
		dp = new int [K+1];
		for (int i = 1; i <= K; i++) dp[i] = 10001;
		for (int i = 0; i < N; i++) coin[i] = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++)
			for (int j = coin[i]; j <= K; j++)
				dp[j] = Math.min(dp[j], dp[j - coin[i]] + 1);

	    bw.write(""+(dp[K] == 10001 ? -1 : dp[K]));
		br.close();
		bw.close();
	}
}