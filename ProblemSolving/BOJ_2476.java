import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_2476 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int ans = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			int score = 0;
			if (A == B && B == C) {
				score = 10000 + A * 1000;
			} else if (A == B || B == C || C == A) {
				score = 1000 + (A == B ? A : C) * 100;		
			} else {
				score = Math.max(A, Math.max(B, C)) * 100;
			}
			
			ans = Math.max(ans, score);
		}
		
		bw.write(String.valueOf(ans));
		br.close();
		bw.close();
	}
}
