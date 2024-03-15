import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_2583 {
	
	static int N, M, K, cnt;
	static int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static boolean[][] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		visited = new boolean[M][N];
		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			int fromY = Integer.parseInt(st.nextToken());
			int toX = M - Integer.parseInt(st.nextToken());
			int toY = Integer.parseInt(st.nextToken());
			int fromX = M - Integer.parseInt(st.nextToken());
			
			for (int i = fromX; i < toX; i++) {
				for (int j = fromY; j < toY; j++) {
					visited[i][j] = true;
				}
			}
		}
		
		ArrayList<Integer> areas = new ArrayList<>();
		for (int x = 0; x < M; x++) {
			for (int y = 0; y < N; y++) {
				if (!visited[x][y]) {
					cnt = 0;
					getArea(x, y);
					areas.add(cnt);
				}
			}
		}
		
		Collections.sort(areas);
		
		StringBuilder sb = new StringBuilder();
		sb.append(areas.size()).append("\n");
		for (int area : areas) {
			sb.append(area).append(" ");
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}

	private static void getArea(int x, int y) {
		visited[x][y] = true;
		cnt++;
		
		for (int[] dir : dirs) {
			int nx = x + dir[0];
			int ny = y + dir[1];
			
			if (!isInMap(nx, ny) || visited[nx][ny]) {
				continue;
			}
			
			getArea(nx, ny);
		}
	}

	private static boolean isInMap(int x, int y) {
		return 0 <= x && x < M && 0 <= y && y < N;
	}
}
