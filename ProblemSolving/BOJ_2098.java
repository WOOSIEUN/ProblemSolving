import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2098 {
	
	static int[][] map, dp;
	static int N, INF = 16000000;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int [N][N];
		dp = new int [N][(1 << N) - 1];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}			
		}
		
		bw.write(String.valueOf(TSP(0, 1)));
		br.close();
		bw.close();
	}

	private static int TSP(int curCity, int visitedBit) {
		if (visitedBit == (1 << N) - 1) {
			if (map[curCity][0] == 0) {
				return INF;
			}
			return map[curCity][0];
		}
		
		if (dp[curCity][visitedBit] > 0) {
			return dp[curCity][visitedBit];
		}
		
		dp[curCity][visitedBit] = INF;
		for (int i = 0; i < N; i++) {
			if ((visitedBit & (1 << i)) == 0 && map[curCity][i] != 0) {
				dp[curCity][visitedBit] = Math.min(dp[curCity][visitedBit], TSP(i, visitedBit | (1 << i)) + map[curCity][i]);
			}
		}
		
		return dp[curCity][visitedBit];
	}
}
