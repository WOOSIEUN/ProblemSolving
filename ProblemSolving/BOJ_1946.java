import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1946 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[][] people = new int [N][2];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				people[i][0] = Integer.parseInt(st.nextToken());
				people[i][1] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(people, (a, b) -> a[0] - b[0]);
			
			int pass = 0, criteria = people[0][1];
			for (int[] person : people) {
				if (person[1] > criteria) {
					continue;
				}
				criteria = person[1];
				pass++;
			}
			
			sb.append(pass).append("\n");
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}
