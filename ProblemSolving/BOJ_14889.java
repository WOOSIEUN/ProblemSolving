import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_14889 {
	
	static final int MAX = 2001;
	static int N, min = MAX;
	static int[][] stats;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		stats = new int [N][N];
		visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				stats[i][j] = Integer.parseInt(st.nextToken());
			}			
		}
		
		dfs(0, 0);
		
		bw.write(String.valueOf(min));
		br.close();
		bw.close();
	}

	private static void dfs(int cur, int depth) {
		if (depth == N / 2) {
			calculateScore();
			return;
		}
		
		for (int i = cur; i < N; i++) {
			if (visited[i]) {
				continue;
			}
			
			visited[i] = true;
			dfs(i, depth + 1);
			visited[i] = false;
		}
	}
	
	private static void calculateScore() {
		int start = 0, link = 0;
		
		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				if (visited[i] && visited[j]) {
                    start += (stats[i][j] + stats[j][i]);
                } else if (!visited[i] && !visited[j]) {
                    link += (stats[i][j] + stats[j][i]);
                }
			}
		}
		
		min = Math.min(min, Math.abs(start - link));
	}
}
