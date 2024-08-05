import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_28417 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int winnerScore = 0;
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int runScore = Math.max(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			
			int[] trickScore = new int [5];
			for (int j = 0; j < 5; j++) {
				trickScore[j] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(trickScore);
			
			winnerScore = Math.max(winnerScore, runScore + trickScore[4] + trickScore[3]);
		}
		
		bw.write(String.valueOf(winnerScore));
		br.close();
		bw.close();
	}
}
