import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_2231 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int ans = 0;
		int N = Integer.parseInt(br.readLine());
		for (int i = 1; i < N; i++) {
			int decompositionSum = i, num = i;
			while (num > 0) {
				decompositionSum += num % 10;
				num /= 10;
			}
			
			if (decompositionSum == N) {
				ans = i;
				break;
			}
		}
		
		bw.write(String.valueOf(ans));
		br.close();
		bw.close();
	}
}
