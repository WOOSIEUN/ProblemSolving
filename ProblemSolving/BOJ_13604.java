import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_13604 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int J = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		int maxScore = 0, maxIdx = -1;
		int[] scores = new int [J];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < J; j++) {
				scores[j] += Integer.parseInt(st.nextToken());
				
				if (scores[j] >= maxScore) {
					maxScore = scores[j];
					maxIdx = j;
	            }
			}
		}
		
		bw.write(String.valueOf(maxIdx + 1));
		br.close();
		bw.close();
	}
}
