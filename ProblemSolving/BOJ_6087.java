import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_6087 {
	static class Laser implements Comparable<Laser>{
		int x, y, dir, numOfMirror;

		public Laser(int x, int y, int dir, int numOfMirror) {
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.numOfMirror = numOfMirror;
		}

		@Override
		public int compareTo(Laser laser) {
			return this.numOfMirror - laser.numOfMirror;
		}
	}
	
	static int W, H;
	static int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static boolean[][] map;
	static Laser start, end;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new boolean [H][W];
		for (int i = 0; i < H; i++) {
			char[] line = br.readLine().toCharArray();
			for (int j = 0; j < W; j++) {
				if (line[j] == 'C') {
					if (start == null) {
						start = new Laser(i, j, -4, -1);
					} else {
						end = new Laser(i, j, 0, 0);
					}
				}
				
				if (line[j] == '*') {
					map[i][j] = false;					
				} else {
					map[i][j] = true;
				}				
			}
		}
		
		bw.write(String.valueOf(findMinNumOfMirror()));
		br.close();
		bw.close();
	}
	
	private static int findMinNumOfMirror() {
        int minNumOfMirror = Integer.MAX_VALUE;
		int[][][] numOfMirror = new int [dirs.length][H][W];
		for (int i = 0; i < dirs.length; i++) {
			for (int j = 0; j < H; j++) {
				Arrays.fill(numOfMirror[i][j], Integer.MAX_VALUE);
			}
		}
		
		PriorityQueue<Laser> queue = new PriorityQueue<>();
		queue.add(start);
		
		while (!queue.isEmpty()) {
			Laser cur = queue.poll();
			
			if (cur.x == end.x && cur.y == end.y) {
				minNumOfMirror = Math.min(minNumOfMirror, cur.numOfMirror);
                continue;
			}
						
			for (int dir = 0; dir < 4; dir++) {
				int nx = cur.x + dirs[dir][0];
				int ny = cur.y + dirs[dir][1];
				
				if (!isInMap(nx, ny) || !map[nx][ny] || Math.abs(cur.dir - dir) == 2) {
					continue;
				}
				
				int nNumOfMirror = cur.numOfMirror + (dir == cur.dir ? 0 : 1);
				if (numOfMirror[dir][nx][ny] > nNumOfMirror) {
					queue.add(new Laser(nx, ny, dir, nNumOfMirror));
					numOfMirror[dir][nx][ny] = nNumOfMirror;
				}
			}
		}
		
		return minNumOfMirror;
	}

	private static boolean isInMap(int x, int y) {
		return 0 <= x && x < H && 0 <= y && y < W;
	}
}
