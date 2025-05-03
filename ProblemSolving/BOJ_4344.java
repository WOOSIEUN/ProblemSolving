import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_4344 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int[] scores = new int[N];
			
			int sum = 0;
			for (int i = 0; i < N; i++) {
				scores[i] = Integer.parseInt(st.nextToken());
				sum += scores[i];
			}
			
			int overAverage = 0;
			double avg = (double) sum / N;
			for (int score : scores) {
				if (score > avg) {
					overAverage++;
				}
			}
			
			sb.append(String.format("%.3f", (double) overAverage / N * 100)).append("%\n");
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}
