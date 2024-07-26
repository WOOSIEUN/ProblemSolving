import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_6359 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());
			boolean[] open = new boolean [n + 1];
			for (int i = 1; i <= n; i++) {
				for (int j = i; j <= n; j += i) {
					open[j] = !open[j];
				}
			}
			
			int cnt = 0;
			for (int i = 1; i <= n; i++) {
				if (open[i]) {
					cnt++;
				}
			}
			sb.append(cnt).append("\n");
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}
