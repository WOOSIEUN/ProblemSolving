import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_14501 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] duration = new int [N];
		int[] pay = new int [N];
		int[] dp = new int [N + 1];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			duration[i] = Integer.parseInt(st.nextToken());
			pay[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = N - 1; i >= 0; i--){
            if (i + duration[i] > N){
                dp[i] = dp[i + 1];
            } else {
                dp[i] = Math.max(pay[i] + dp[i + duration[i]], dp[i + 1]);
            }
        }
		
		bw.write(String.valueOf(dp[0]));
		br.close();
		bw.close();
	}
}
