import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_9093 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			while (st.hasMoreTokens()) {
				sb.append(reverse(st.nextToken())).append(" ");
			}
			sb.deleteCharAt(sb.length() - 1);
			sb.append("\n");
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}

	private static String reverse(String target) {
		StringBuilder sb = new StringBuilder();
		return sb.append(target).reverse().toString();
	}
}
