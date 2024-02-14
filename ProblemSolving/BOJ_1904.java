import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_1904 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] fibo = new int [N + 1];
		
		fibo[1] = 1;
		if (N > 1) {
			fibo[2] = 2;
		}
		
		for (int i = 3; i < N + 1; i++) {
			fibo[i] = (fibo[i - 2] + fibo[i - 1]) % 15746;
		}
		
		bw.write(String.valueOf(fibo[N]));
		br.close();
		bw.close();
	}
}
