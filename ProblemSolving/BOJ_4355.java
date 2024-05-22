import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_4355 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) {
            	break;
            }
            
            sb.append(N == 1 ? "0" : eulerPhi(N)).append("\n");
        }
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}

	private static long eulerPhi(long n) {
		long euler = n;

		for (long p = 2; p * p <= n; p++) {
			if (n % p == 0) {
				euler = euler / p * (p - 1);
			}
			while (n % p == 0) {
				n /= p;
			}
		}

		return (n == 1 ? euler : euler / n * (n - 1));
	}
}