import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_7568 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] weights = new int [N];
		int[] heights = new int [N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			weights[i] = Integer.parseInt(st.nextToken());
			heights[i] = Integer.parseInt(st.nextToken());
		}
		
		StringBuilder sb = new StringBuilder();
		for (int cur = 0; cur < N; cur++) {
			int rank = 1;
			for (int i = 0; i < N; i++) {
				if (weights[cur] < weights[i] && heights[cur] < heights[i]) {
					rank++;
				}
			}
			sb.append(rank).append(" ");
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}
