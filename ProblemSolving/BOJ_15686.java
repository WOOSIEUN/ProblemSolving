import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_15686 {
	static class Point {
		int x, y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int M;
	static int minDist = Integer.MAX_VALUE;
	static boolean[] visited;
	static int[][] map;
	static ArrayList<Point> house, chicken;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int [N][N];
		house = new ArrayList<>();
		chicken = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if (map[i][j] == 1) {
					house.add(new Point(i, j));
				} else if (map[i][j] == 2) {
					chicken.add(new Point(i, j));					
				}
			}
		}

		visited = new boolean[chicken.size()];
		combination(0, 0);
		
		bw.write(String.valueOf(minDist));
		br.close();
		bw.close();
	}

	private static void combination(int cnt, int start) {
		if (cnt == M) {
			minDist = Math.min(minDist, getDist());
			return;
		}		
		
		for (int i = start; i < chicken.size(); i++) {
			if (visited[i]) {
				continue;
			}
			visited[i] = true;
			combination(cnt + 1, i + 1);
			visited[i] = false;
		}
	}

	private static int getDist() {
		int distTotal = 0;
		for (int i = 0; i < house.size(); i++) {
			int dist = Integer.MAX_VALUE;
			
			for (int j = 0; j < chicken.size(); j++) {
				if (!visited[j]) {
					continue;
				}				
				
				dist = Math.min(dist, Math.abs(house.get(i).x - chicken.get(j).x) + Math.abs(house.get(i).y - chicken.get(j).y));
			}
			
			distTotal += dist;
		}
		return distTotal;
	}
}
