import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_9610 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int Q1 = 0, Q2 = 0, Q3 = 0, Q4 = 0, axis = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			if (x == 0 || y == 0) {
				axis++;
			} else if (y > 0) {
				if (x > 0) {
					Q1++;
				} else {
					Q2++;
				}
			} else {
				if (x > 0) {
					Q4++;
				} else {
					Q3++;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append("Q1: ").append(Q1).append("\n");
		sb.append("Q2: ").append(Q2).append("\n");
		sb.append("Q3: ").append(Q3).append("\n");
		sb.append("Q4: ").append(Q4).append("\n");
		sb.append("AXIS: ").append(axis).append("\n");
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}
