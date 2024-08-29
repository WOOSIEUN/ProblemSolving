import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_31090 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			int year = Integer.parseInt(br.readLine());
			int divider = year % 100;
			sb.append((year + 1) % divider == 0 ? "Good\n" : "Bye\n");
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}
