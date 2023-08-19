import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_13460 {
	static class Marble {
		int redX, redY, blueX, blueY, cnt;
		public Marble(int redX, int redY, int blueX, int blueY, int cnt) {
			this.redX = redX;
			this.redY = redY;
			this.blueX = blueX;
			this.blueY = blueY;
			this.cnt = cnt;
		}
	}

	static int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static char[][] map;
	static boolean[][][][] visited;
	static int N, M, redX, redY, blueX, blueY;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char [N][M];
		visited = new boolean[N][M][N][M];
		for (int i = 0; i < N; i++) {
			char[] line = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				map[i][j] = line[j];
				if (line[j] == 'R') {
					redX = i;
					redY = j;
				} else if (line[j] == 'B') {
					blueX = i;
					blueY = j;
				}
			}			
		}
				
		bw.write(String.valueOf(getMinTilt()));
		br.close();
		bw.close();
	}

	private static int getMinTilt() {
		Queue<Marble> queue = new LinkedList<>();
		queue.add(new Marble(redX, redY, blueX, blueY, 0));
		visited[redX][redY][blueX][blueY] = true;
		
		while(!queue.isEmpty()) {
			Marble cur = queue.poll();
			
			if (cur.cnt >= 10) {
				return -1;
			}
			
			for (int i = 0; i < 4; i++) {
				boolean isRedInHole = false, isBlueInHole = false;
				int newRedX = cur.redX;
				int newRedY = cur.redY;
				int newBlueX = cur.blueX;
				int newBlueY = cur.blueY;
				
				while (map[newRedX + dirs[i][0]][newRedY + dirs[i][1]] != '#') {
					newRedX += dirs[i][0];
					newRedY += dirs[i][1];
					if (map[newRedX][newRedY] == 'O') {
						isRedInHole = true;
						break;
					}
				}
				
				while (map[newBlueX + dirs[i][0]][newBlueY + dirs[i][1]] != '#') {
					newBlueX += dirs[i][0];
					newBlueY += dirs[i][1];
					if (map[newBlueX][newBlueY] == 'O') {
						isBlueInHole = true;
						break;
					}
				}
				
				if (isBlueInHole) {
					continue;
				} else if (isRedInHole && !isBlueInHole) {
					return cur.cnt + 1;
				}
				
				if (newRedX == newBlueX && newRedY == newBlueY) {
					if (i == 0) {
						if (cur.redX < cur.blueX) {
							newBlueX -= dirs[i][0];
						} else {
							newRedX -= dirs[i][0];
						}
					} else if (i == 1) {
						if (cur.redY < cur.blueY) {
							newRedY -= dirs[i][1];
						} else {
							newBlueY -= dirs[i][1];
						}
					} else if (i == 2) {
						if (cur.redX < cur.blueX) {
							newRedX -= dirs[i][0];
						} else {
							newBlueX -= dirs[i][0];
						}
					} else {
						if (cur.redY < cur.blueY) {
							newBlueY -= dirs[i][1];
						} else {
							newRedY -= dirs[i][1];
						}
					}
				}
				
				if (!visited[newRedX][newRedY][newBlueX][newBlueY]) {					
					queue.add(new Marble(newRedX, newRedY, newBlueX, newBlueY, cur.cnt + 1));
					visited[newRedX][newRedY][newBlueX][newBlueY] = true;
				}
			}
		}
		return -1;
	}
}
