import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_31821 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[] prices = new int [N];
		for (int i = 0; i < N; i++) {
			prices[i] = Integer.parseInt(br.readLine());
		}

		int M = Integer.parseInt(br.readLine());
		int ans = 0;
		for (int i = 0; i < M; i++) {
			ans += prices[Integer.parseInt(br.readLine()) - 1];
		}
		
		bw.write(String.valueOf(ans));
		br.close();
		bw.close();
	}
}
