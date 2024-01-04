import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1026 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		int[] A = new int [N];
		int[] B = new int [N];
		StringTokenizer stA = new StringTokenizer(br.readLine());	
		StringTokenizer stB = new StringTokenizer(br.readLine());		
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(stA.nextToken());
			B[i] = Integer.parseInt(stB.nextToken());
		}

		Arrays.sort(A);
		Arrays.sort(B);
		
		int ans = 0;
		for (int i = 0; i < N; i++) {
			ans += A[i] * B[N - i - 1];
		}
		
		bw.write(String.valueOf(ans));
		br.close();
		bw.close();
	}
}
