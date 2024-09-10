import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_17484 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] space = new int [N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				space[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][][] consumedFuel = new int [N][M][3];
		for (int j = 0; j < M; j++) {
			consumedFuel[0][j][0] = space[0][j];
			consumedFuel[0][j][1] = space[0][j];
			consumedFuel[0][j][2] = space[0][j];
		}
		
		int[] dirs = {-1, 0, 1};
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < M; j++) {
				Arrays.fill(consumedFuel[i][j], Integer.MAX_VALUE);
				
				if (j == 0) {
					consumedFuel[i][j][0] = Math.min(consumedFuel[i - 1][j + 1][1], consumedFuel[i - 1][j + 1][2]) + space[i][j];
					consumedFuel[i][j][1] = consumedFuel[i - 1][j][0] + space[i][j];
                } else if (j == M - 1) {
                	consumedFuel[i][j][2] = Math.min(consumedFuel[i - 1][j - 1][1], consumedFuel[i - 1][j - 1][0]) + space[i][j];
                	consumedFuel[i][j][1] = consumedFuel[i - 1][j][2] + space[i][j];
                } else {
                	consumedFuel[i][j][0] = Math.min(consumedFuel[i - 1][j + 1][1], consumedFuel[i - 1][j + 1][2]) + space[i][j];
                	consumedFuel[i][j][1] = Math.min(consumedFuel[i - 1][j][0], consumedFuel[i - 1][j][2]) + space[i][j];
                	consumedFuel[i][j][2] = Math.min(consumedFuel[i - 1][j - 1][1], consumedFuel[i - 1][j - 1][0]) + space[i][j];
                }
			}
		}
		
		int ans = Integer.MAX_VALUE;
		for (int j = 0; j < M; j++) {
			for (int dir : dirs) {
				ans = Math.min(ans, consumedFuel[N - 1][j][dir + 1]);
			}
		}
		
		bw.write(String.valueOf(ans));
		br.close();
		bw.close();
	}
}
