import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_8958 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			char[] str = br.readLine().toCharArray();
			int score = 0, totalScore = 0;
			for (int i = 0; i < str.length; i++) {
				if (str[i] == 'O') {
					totalScore += ++score;
				} else {
					score = 0;
				}
			}
			sb.append(totalScore).append("\n");
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}
