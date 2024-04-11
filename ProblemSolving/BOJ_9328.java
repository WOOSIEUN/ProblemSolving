import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_9328 {
	static class Point {
		int x, y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int H, W;
	static int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static char[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken()) + 2;
			W = Integer.parseInt(st.nextToken()) + 2;
			map = new char [H][W];
			
			for (int i = 0; i < H; i++) {
				if (i == 0 || i == H - 1) {
					for (int j = 0; j < W; j++) {
						map[i][j] = '.';
					}
					continue;
				}
				
				String line = br.readLine();				
				for (int j = 1; j < W - 1; j++) {
					map[i][j] = line.charAt(j - 1);
				}				

				map[i][0] = '.';
				map[i][W - 1] = '.';
			}
			
			String line = br.readLine();
			boolean[] hasKey = new boolean [26];
			if (line.charAt(0) != '0') {
				for (char key : line.toCharArray()) {
					hasKey[key - 'a'] = true;
				}
			}
			
			sb.append(getMaxStolenDoc(new Point(0, 0), hasKey)).append("\n");
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}

	private static int getMaxStolenDoc(Point start, boolean[] hasKey) {
		int numOfDocuments = 0;
		boolean[][] visited = new boolean [H][W];
		boolean[] visitedDoor = new boolean [26];
		ArrayList<ArrayList<Point>> doorList = new ArrayList<>();
		for (int i = 0; i < 26; i++) {
			doorList.add(new ArrayList<>());
		}
		
		Queue<Point> queue = new LinkedList<>();
		queue.add(start);
		visited[start.x][start.y] = true;
		
		while (!queue.isEmpty()) {
			Point cur = queue.poll();
			
			for (int[] dir : dirs) {
				int nx = cur.x + dir[0];
				int ny = cur.y + dir[1];
				
				if (!isInMap(nx, ny) || visited[nx][ny] || map[nx][ny] == '*') {
					continue;
				}
				
				if ('A' <= map[nx][ny] && map[nx][ny] <= 'Z') {
					if (hasKey[map[nx][ny] - 'A']) {
						queue.add(new Point(nx, ny));
						visited[nx][ny] = true;
					} else {
						visitedDoor[map[nx][ny] - 'A'] = true;
						doorList.get(map[nx][ny] - 'A').add(new Point(nx, ny));
					}
				} else if ('a' <= map[nx][ny] && map[nx][ny] <= 'z') {
					hasKey[map[nx][ny] - 'a'] = true;
					queue.add(new Point(nx, ny));
					visited[nx][ny] = true;
					
					if (visitedDoor[map[nx][ny] - 'a']) {
						for (Point door : doorList.get(map[nx][ny] - 'a')) {
							if (visited[door.x][door.y]) {
								continue;
							}
							
							queue.add(door);
						}
					}
				} else if (map[nx][ny] == '$') {
					numOfDocuments++;
					queue.add(new Point(nx, ny));
					visited[nx][ny] = true;
				} else {
					queue.add(new Point(nx, ny));
					visited[nx][ny] = true;
				}
			}
		}
		
		return numOfDocuments;
	}

	private static boolean isInMap(int x, int y) {
		return 0 <= x && x < H && 0 <= y && y < W;
	}
}
