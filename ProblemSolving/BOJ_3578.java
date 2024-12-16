import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_3578 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		if (N == 0) {
			sb.append("1");
		} else if (N == 1) {
			sb.append("0");
		} else {
			if (N % 2 != 0) {
				sb.append("4");
			}
			
			for (int i = 0; i < N / 2; i++) {
				sb.append("8");
			}
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}
