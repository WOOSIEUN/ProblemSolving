import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_12100 {
	static int N, ans;
	static int[][] map, dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	static boolean[][] added;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int [N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		getMaxBlock(0);
		
		bw.write(String.valueOf(ans));
		br.close();
		bw.close();
	}
	
	private static void getMaxBlock(int cnt) {
		if (cnt == 5) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					ans = Math.max(ans, map[i][j]);
				}
			}
			return;
		}
		
		int[][] originalMap = new int [N][N];
		copyMap(map, originalMap);
		
		for (int dir = 0; dir < 4; dir++) {
			moveBlocks(dir);
			getMaxBlock(cnt + 1);
			copyMap(originalMap, map);
		}		
	}
		
	private static void moveBlocks(int dir) {
		added = new boolean [N][N];
		if (dir == 0) {
			for (int j = 0; j < N; j++) {
				for (int i = 0; i < N; i++) {
					if (map[i][j] != 0) {
						moveBlock(i, j, dirs[dir]);
					}									
				}
			}
		} else if (dir == 1) {
			for (int j = 0; j < N; j++) {
				for (int i = N - 1; i >= 0; i--) {
					if (map[i][j] != 0) {
						moveBlock(i, j, dirs[dir]);
					}									
				}
			}
		} else if (dir == 2) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] != 0) {
						moveBlock(i, j, dirs[dir]);
					}									
				}
			}
		} else if (dir == 3) {
			for (int i = 0; i < N; i++) {
				for (int j = N - 1; j >= 0; j--) {
					if (map[i][j] != 0) {
						moveBlock(i, j, dirs[dir]);
					}									
				}
			}
		}		
	}
	
	private static void moveBlock(int x, int y, int[] dir) {
		while (true) {
			int nX = x + dir[0];
			int nY = y + dir[1];
			
			if (!isInMap(nX, nY) || added[nX][nY]) {
				return;
			}
			
			if (map[x][y] == map[nX][nY]) {
				added[nX][nY] = true;
				map[nX][nY] += map[x][y];
				map[x][y] = 0;
				return;
			} else if (map[nX][nY] != 0) {
				return;
			}

			map[nX][nY] = map[x][y];
			map[x][y] = 0;
			x = nX;
			y = nY;			
		}		
	}

	private static boolean isInMap(int x, int y) {
		return 0 <= x && x < N && 0 <= y && y < N;
	}

	private static void copyMap(int[][] src, int[][] dest) {
		for(int i = 0; i < src.length; i++) {
			dest[i] = src[i].clone();
		}
	}
}
