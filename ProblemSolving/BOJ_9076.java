import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_9076 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int[] scores = new int [5];
			for (int i = 0; i < scores.length; i++) {
				scores[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(scores);
			sb.append(scores[3] - scores[1] < 4 ? scores[1] + scores[2] + scores[3] : "KIN").append("\n");
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}
