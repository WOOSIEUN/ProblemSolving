import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_9252 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		char[] firstSequence = br.readLine().toCharArray();
		char[] secondSequence = br.readLine().toCharArray();
		int[][] dp = new int [firstSequence.length + 1][secondSequence.length + 1];
		
		for (int i = 1; i < firstSequence.length + 1; i++) {
			for (int j = 1; j < secondSequence.length + 1; j++) {
				if (firstSequence[i - 1] == secondSequence[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		
		int x = firstSequence.length;
		int y = secondSequence.length;
		while (dp[x][y] != 0) {
			if (firstSequence[x - 1] == secondSequence[y - 1]) {
				sb.append(firstSequence[x - 1]);
				x = x - 1;
				y = y - 1;
			} else {
				if (dp[x - 1][y] < dp[x][y - 1]) {
					y = y - 1;			
				} else {
					x = x - 1;		
				}
			}
		}
		sb.append("\n");
		
		bw.write(String.valueOf(dp[firstSequence.length][secondSequence.length]));
		bw.write(sb.reverse().toString());
		br.close();
		bw.close();
	}
}
