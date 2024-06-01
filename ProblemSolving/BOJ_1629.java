import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_1629 {
	
	static long C;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		C = Long.parseLong(st.nextToken());
		
		bw.write(String.valueOf(pow(A, B)));
		br.close();
		bw.close();
	}
	
	private static long pow(long base, long exponent) {
		if (exponent == 1) {
			return base % C;
		}
		
		long square = pow(base, exponent / 2);
		
	 	if (exponent % 2 == 1) {
			return (square * square % C) * base % C;
		}
	 	
		return square * square % C;
	}
}
