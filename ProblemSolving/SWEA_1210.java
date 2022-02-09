import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA_1210 {
	static int[][] map;
	static int[][] dirs = { { 0, -1 }, { 0, 1 }, { -1, 0 } };
	static int N, x, y, nx, ny;
	static final int MAX = 100;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		for (int t = 1; t <= 10; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[MAX][MAX];
			for (int i = 0; i < MAX; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; st.hasMoreTokens(); j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int j = 0; j < MAX; j++)
				if (map[MAX - 1][j] == 2)
					y = j;
			x = MAX - 1;
			while (x > 0) {
				map[x][y] = -1;
				for (int[] dir : dirs) {
					nx = x + dir[0];
					ny = y + dir[1];
					if (isVaild(nx, ny) && map[nx][ny] == 1) {
						x = nx;
						y = ny;
						break;
					}
				}
			}
			bw.write("#" + t + " " + y + "\n");
		}
		br.close();
		bw.close();
	}

	static boolean isVaild(int nx2, int ny2) {
		return ((0 <= nx && nx < MAX && 0 <= ny && ny < MAX) ? true : false);
	}
}
