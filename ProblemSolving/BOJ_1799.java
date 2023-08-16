import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_1799 {
	
	static boolean [][] map;
	static boolean [] NWSE, NESW;
	static int maxBlack, maxWhite, N;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		map = new boolean [N][N];
		NWSE = new boolean [2 * N - 1];
		NESW = new boolean [2 * N - 1];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				if (Integer.parseInt(st.nextToken()) == 1) {
					map[i][j] = true;
				} else {
					map[i][j] = false;
				}
			}
		}		

		getMaxBishop(0, 0, 0, 'B');
		getMaxBishop(0, 1, 0, 'W');
		
		bw.write(String.valueOf(maxBlack + maxWhite));
		br.close();
		bw.close();
	}
	
	private static void getMaxBishop(int x, int y, int cnt, char type) {
		if (y >= N) {
			x++;
			if (y % 2 == 0) {
				y = 1;
			} else {
				y = 0;
			}
		}
		if (x >= N) {
			if (type == 'B') {
				maxBlack = Math.max(maxBlack, cnt);
			} else {
				maxWhite = Math.max(maxWhite, cnt);				
			}
			return;
		}
		
		if (map[x][y] && !NWSE[N - 1 + y - x] && !NESW[x + y]) {
			NWSE[N - 1 + y - x] = true;
			NESW[x + y] = true;
			getMaxBishop(x, y + 2, cnt + 1, type);
			NWSE[N - 1 + y - x] = false;
			NESW[x + y] = false;
		}
		getMaxBishop(x, y + 2, cnt, type);
	}
}
