import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_10798 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int maxLen = 0;
		char[][] words = new char [5][0];
		for (int i = 0; i < 5; i++) {
			words[i] = br.readLine().toCharArray();
			maxLen = Math.max(maxLen, words[i].length);
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < maxLen; i++) {
			for (int j = 0; j < 5; j++) {
				if (words[j].length <= i) {
					continue;
				}
				sb.append(words[j][i]);
			}
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}
 