import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_14002 {
	static int N, result, resIdx, idx;
	static int[] seq, dp, outputIdx, output;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		seq = new int[N];
		dp = new int[N];
		outputIdx = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			seq[i] = Integer.parseInt(st.nextToken());
		for (int i = 0; i < N; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++)
				if (seq[i] > seq[j] && dp[i] < dp[j] + 1) {
					dp[i] = dp[j] + 1;
					outputIdx[i] = j;
				}
			if (result < dp[i]) {
				result = dp[i];
				resIdx = i;
			}
		}
		sb.append(result).append("\n");
		output = new int[result];
		idx = resIdx;
		for (int i = 0; i < result; i++) {
			output[i] = seq[idx];
			idx = outputIdx[idx];
		}
		for (int i = result - 1; i >= 0; i--)
			sb.append(output[i]).append(" ");
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}
