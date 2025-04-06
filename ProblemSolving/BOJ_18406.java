import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_18406 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		char[] N = br.readLine().toCharArray();
		
		int sumOfLeft = 0, sumOfRight = 0;
		for (int diff = 0; diff < N.length / 2; diff++) {
			sumOfLeft += N[diff];
			sumOfRight += N[N.length - 1 - diff];
		}
		
		bw.write(sumOfLeft == sumOfRight ? "LUCKY" : "READY");
		br.close();
		bw.close();
	}
}
