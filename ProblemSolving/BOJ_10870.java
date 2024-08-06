import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_10870 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		
		int[] fibo = new int [N + 1];
		fibo[0] = 0;
		if (N > 0) {
			fibo[1] = 1;
		}
		
		for (int i = 2; i <= N; i++) {
			fibo[i] = fibo[i - 1] + fibo[i - 2];
		}
		
		bw.write(String.valueOf(fibo[N]));
		br.close();
		bw.close();
	}
}
