import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_1987 {
	static int[][] dirs = {{-1, 1, 0, 0}, {0, 0, -1, 1}};
	static char[][] map;
	static boolean[] isVisited = new boolean[26];
	static int R, C, max;	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char [R][C];
		for (int i = 0; i < R; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < C; j++) 
				map[i][j] = tmp.charAt(j);
		}
		dfs(0, 0, 1);
		bw.write("" + max);
		br.close();
		bw.close();
	}
	
	static void dfs(int x, int y, int depth) {
		isVisited[map[x][y] - 'A'] = true;
		for (int i = 0; i < 4; i++) {
			int nx = x + dirs[0][i];
			int ny = y + dirs[1][i];
			if(isVaild(nx, ny) && !isVisited[map[nx][ny] - 'A']) {				
				dfs(nx, ny, depth + 1);
			}
		}
		max = Math.max(max, depth);
		isVisited[map[x][y] - 'A'] = false;
	}
	
	static boolean isVaild(int nx, int ny) {
		return (0 <= nx && nx < R && 0 <= ny && ny < C ? true : false);
	}

}
