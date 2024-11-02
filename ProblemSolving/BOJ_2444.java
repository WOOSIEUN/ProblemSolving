import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_2444 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < N - i; j++) {
				sb.append(" ");
			}
			
			for (int j = 0; j < 2 * i - 1; j++) {
				sb.append("*");
			}
			sb.append("\n");
		}
		
		for (int i = N - 1; i >= 0; i--) {
			for (int j = 0; j < N - i; j++) {
				sb.append(" ");
			}
			
			for (int j = 0; j < 2 * i - 1; j++) {
				sb.append("*");
			}
			sb.append("\n");
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}
