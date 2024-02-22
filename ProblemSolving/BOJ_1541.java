import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_1541 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), "-");
		int ans = Integer.MAX_VALUE;
		
		while (st.hasMoreTokens()) {
			StringTokenizer nums = new StringTokenizer(st.nextToken(), "+");
			
			int sum = 0;
			while (nums.hasMoreTokens()) {
				sum += Integer.parseInt(nums.nextToken());
			}
			
			if (ans == Integer.MAX_VALUE) {
				ans = sum;
			} else {
				ans -= sum;
			}
		}
		
		bw.write(String.valueOf(ans));
		br.close();
		bw.close();
	}
}
