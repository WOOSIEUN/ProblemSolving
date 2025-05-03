import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_5533 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[][] cards = new int[N][3];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				cards[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] scores = new int[N];
		for (int turn = 0; turn < 3; turn++) {
			for (int i = 0; i < N; i++) {
				boolean isSame = false;
				for (int j = 0; j < N; j++) {
					if (i == j) {
						continue;
					}
					
					if (cards[i][turn] == cards[j][turn]) {
						isSame = true;
						break;
					}
				}
				
				if (!isSame) {
					scores[i] += cards[i][turn];
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(scores[i]).append("\n");
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}
