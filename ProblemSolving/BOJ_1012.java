import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_1012 {
	
	static int N, M;
	static int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static boolean[][] field;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			field = new boolean [N][M];
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				field[x][y] = true;
			}
			
			int earthworm = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (field[i][j]) {
						checkField(i, j);
						earthworm++;
					}
				}
			}
			sb.append(earthworm).append("\n");
		}
				
		bw.write(sb.toString());
		br.close();
		bw.close();
	}

	private static void checkField(int x, int y) {
		field[x][y] = false;
		
		for (int[] dir : dirs) {
			int nx = x + dir[0];
			int ny = y + dir[1];
			
			if (!isInMap(nx, ny) || !field[nx][ny]) {
				continue;
			}
			
			checkField(nx, ny);
		}
	}

	private static boolean isInMap(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < M;
	}
}
