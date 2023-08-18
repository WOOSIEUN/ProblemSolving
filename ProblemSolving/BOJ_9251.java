import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_9251 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String firstSequence = br.readLine();
		String secondSequence = br.readLine();
		int[][] dp = new int [firstSequence.length() + 1][secondSequence.length() + 1];
		
		for (int i = 1; i < firstSequence.length() + 1; i++) {
			for (int j = 1; j < secondSequence.length() + 1; j++) {
				if (firstSequence.charAt(i - 1) == secondSequence.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		
		bw.write(String.valueOf(dp[firstSequence.length()][secondSequence.length()]));
		br.close();
		bw.close();
	}
}
