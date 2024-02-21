import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_5427 {
	static class Point {
		int x, y; 
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int w, h;
	static int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static boolean[][] map;
	static Point person;
	static Queue<Point> fires;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			map = new boolean [h][w];
			fires = new LinkedList<>();
			
			for (int i = 0; i < h; i++) {
				String line = br.readLine();
				for (int j = 0; j < w; j++) {
					char cur = line.charAt(j);

					map[i][j] = (cur == '@' || cur == '.' ? true : false);
					
					if (cur == '@') {
						person = new Point(i, j);
					} else if (cur == '*') {
						fires.add(new Point(i, j));
					}
				}
			}
			
			int time = escapeBuilding();
			sb.append(time == -1 ? "IMPOSSIBLE" : time).append("\n");
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}

	private static int escapeBuilding() {
		boolean[][] visited = new boolean [h][w];
		Queue<Point> route = new LinkedList<>();
		route.add(person);
		visited[person.x][person.y] = true;
		
		for (int time = 1; ; time++) {
			int fireLen = fires.size();
			while (fireLen-- > 0) {
				Point cur = fires.poll();
				
				for (int[] dir : dirs) {
					int nx = cur.x + dir[0];
					int ny = cur.y + dir[1];
					
					if (!isInMap(nx, ny) || !map[nx][ny]) {
						continue;
					}
					
					map[nx][ny] = false;
					fires.add(new Point(nx, ny));
				}
			}
			
			if (route.isEmpty()) {
				break;
			}
			
			int routeLen = route.size();
			while (routeLen-- > 0) {
				Point cur = route.poll();
				
				for (int[] dir : dirs) {
					int nx = cur.x + dir[0];
					int ny = cur.y + dir[1];
					
					if (!isInMap(nx, ny)) {
						return time;
					}
					
					if (!map[nx][ny] || visited[nx][ny]) {
						continue;
					}
					
					route.add(new Point(nx, ny));
					visited[nx][ny] = true;
				}
			}
		}		
		
		return -1;
	}

	private static boolean isInMap(int x, int y) {
		return 0 <= x && x < h && 0 <= y && y < w;
	}
}
