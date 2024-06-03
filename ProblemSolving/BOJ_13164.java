import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_13164 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] kids = new int [N];
		int [] diff = new int [N - 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			kids[i] = Integer.parseInt(st.nextToken());
			
			if (i != 0) {
				diff[i - 1] = kids[i] - kids[i - 1];
			}
		}
		
		Arrays.sort(diff);
		
		int ans = 0;
		for (int i = 0; i < N - K; i++) {
			ans += diff[i];
		}
		
		bw.write(String.valueOf(ans));
		br.close();
		bw.close();
	}
}
