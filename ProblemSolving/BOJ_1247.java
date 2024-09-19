import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class BOJ_1247 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 3; i++) {
			int N = Integer.parseInt(br.readLine());
			
			BigInteger sum = new BigInteger("0");		
			for (int j = 0; j < N; j++) {
				sum = sum.add(new BigInteger(br.readLine()));
			}
			
			if (sum.compareTo(BigInteger.ZERO) == 1) {
				sb.append("+\n");
			} else if (sum.compareTo(BigInteger.ZERO) == -1) {
				sb.append("-\n");
			} else {
				sb.append(0).append("\n");
			}
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}
