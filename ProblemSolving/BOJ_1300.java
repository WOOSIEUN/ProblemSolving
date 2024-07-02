import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_1300 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		
		long ans = 0, left = 1, right = K;
        while (left <= right) {
            long mid = (left + right) / 2;
            long cnt = 0;
            
            for (int i = 1; i <= N; i++) {
                cnt += Math.min(mid / i, N);
            }
 
            if (cnt < K) {
                left = mid + 1;
            } else {
                right = mid - 1;
                ans = mid;
            }
        }
		
		bw.write(String.valueOf(ans));
		br.close();
		bw.close();
	}
}
