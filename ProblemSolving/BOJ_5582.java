import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_5582 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		char[] firstStr = br.readLine().toCharArray();
		char[] secondStr = br.readLine().toCharArray();
		
		int ans = 0;
		int[][] dp = new int [firstStr.length + 1][secondStr.length + 1];
		for (int i = 1; i < firstStr.length + 1; i++) {
			for (int j = 1; j < secondStr.length + 1; j++) {
				if (firstStr[i - 1] == secondStr[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
					ans = Math.max(ans, dp[i][j]);
				}
			}
		}
		
		bw.write(String.valueOf(ans));
		br.close();
		bw.close();
	}
}
