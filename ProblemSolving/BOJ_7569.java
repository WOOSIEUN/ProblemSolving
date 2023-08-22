import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7569 {
	static class Tomato {
		int x, y, z, day;
		public Tomato(int x, int y, int z, int day) {
			this.x = x;
			this.y = y;
			this.z = z;
			this.day = day;
		}
	}
	
	static int N, M, H;
	static Queue<Tomato> ripenTomatoes = new LinkedList<>();
	static int[][][] tomatoes;
	static int[][] dirs = {{-1, 0, 0}, {0, -1, 0}, {1, 0, 0}, {0, 1, 0}, {0, 0, -1}, {0, 0, 1}};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		tomatoes = new int [N][M][H];
				
		for (int k = 0; k < H; k++) {
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					tomatoes[i][j][k] = Integer.parseInt(st.nextToken());
					if (tomatoes[i][j][k] == 1) {
						ripenTomatoes.add(new Tomato(i, j, k, 0));
					}
				}
			}
		}
		
		int ans = getDuration();
		if (!isRipen()) {
			ans = -1;
		}
		
		bw.write(String.valueOf(ans));
		br.close();
		bw.close();
	}

	private static int getDuration() {
		int maxDay = 0;
		while (!ripenTomatoes.isEmpty()) {
			Tomato cur = ripenTomatoes.poll();
			maxDay = Math.max(maxDay, cur.day);
			for (int[] dir : dirs) {
				int nx = cur.x + dir[0];
				int ny = cur.y + dir[1];
				int nz = cur.z + dir[2];
				if (isInMap(nx, ny, nz) && tomatoes[nx][ny][nz] == 0) {
					tomatoes[nx][ny][nz] = 1;
					ripenTomatoes.add(new Tomato(nx, ny, nz, cur.day + 1));
				}
			}
		}
		return maxDay;
	}

	private static boolean isInMap(int x, int y, int z) {
		return 0 <= x && x < N && 0 <= y && y < M && 0 <= z && z < H;
	}

	private static boolean isRipen() {
		for (int k = 0; k < H; k++) {
			for (int i = 0; i < N; i++) {				
				for (int j = 0; j < M; j++) {					
					if (tomatoes[i][j][k] == 0) {
						return false;
					}
				}
			}
		}
		return true;
	}	
}
