import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_2169 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int [N][M];
		int[][] dp = new int [N][M];
		int[][] horizontalDP = new int [2][M + 2];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++){
            	map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
		
		dp[0][0] = map[0][0];
		
		for (int j = 1; j < M; j++) {
			dp[0][j] = map[0][j] + dp[0][j - 1];
		}
		
		for (int i = 1; i < N; i++) {            
			horizontalDP[0][0] = dp[i - 1][0];
            for(int j = 1; j <= M; j++) {
            	horizontalDP[0][j] = Math.max(horizontalDP[0][j - 1], dp[i - 1][j - 1]) + map[i][j - 1];
            }
             
            horizontalDP[1][M + 1] = dp[i - 1][M - 1];
            for(int j = M; j > 0; j--) {
            	horizontalDP[1][j] = Math.max(horizontalDP[1][j + 1], dp[i - 1][j - 1]) + map[i][j - 1];
            }
             
            for(int j = 0; j < M; j++) {
                dp[i][j] = Math.max(horizontalDP[0][j + 1], horizontalDP[1][j + 1]);
            }
        }
		
		bw.write(String.valueOf(dp[N - 1][M - 1]));
		br.close();
		bw.close();
	}
}
