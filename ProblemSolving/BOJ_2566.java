import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_2566 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int ans = -1, x = -1, y = -1;
		for (int i = 1; i < 10; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < 10; j++) {
				int cur = Integer.parseInt(st.nextToken());
				if (cur > ans) {
					ans = cur;
					x = i;
					y = j;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(ans).append("\n").append(x).append(" ").append(y);
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}
