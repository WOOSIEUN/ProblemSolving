import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_21921 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		int[] visitor = new int [N + 1];
		int[] sum = new int [N + 1];
		
		int max = -1, cnt = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			visitor[i] = Integer.parseInt(st.nextToken());
			sum[i] = sum[i - 1] + visitor[i];
			
			if (i >= X) {
				sum[i] -= visitor[i - X];
				
				if (max < sum[i]) {
					max = sum[i];
					cnt = 1;
				} else if (max == sum[i]) {
					cnt++;
				}
			}			
		}
		
		StringBuilder sb = new StringBuilder();
		if (max == 0) {
			sb.append("SAD");
		} else {
			sb.append(max).append("\n").append(cnt);
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}
