import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_10431 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int P = Integer.parseInt(br.readLine());
		for (int p = 0; p < P; p++) {
			st = new StringTokenizer(br.readLine());
			int T = Integer.parseInt(st.nextToken());
			int[] students = new int [20];
			int backwardCnt = 0;
			for (int i = 0; i < students.length; i++) {
				students[i] = Integer.parseInt(st.nextToken());
				for (int j = 0; j < i; j++) {
					if (students[i] < students[j]) {
						backwardCnt++;
					}
				}
			}
			
			sb.append(T).append(" ").append(backwardCnt).append("\n");
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}
