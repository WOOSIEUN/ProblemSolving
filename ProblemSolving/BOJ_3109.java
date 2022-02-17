import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_3109 {
	static int[][] dirs = {{-1, 0, 1}, {1, 1, 1}};
	static boolean[][] map;
	static boolean[][] isVisited;
	static int R, C, result;	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new boolean [R][C];
		isVisited = new boolean [R][C];
		for (int i = 0; i < R; i++) {
			String tmp = br.readLine();
			for (int j = 0; j < C; j++) 
				if(tmp.charAt(j) == '.') map[i][j] = true;
		}
		for (int i = 0; i < R; i++)	dfs(i, 0);
		bw.write("" + result);
		br.close();
		bw.close();
	}
	
	static boolean dfs(int x, int y) {
		if(y == C-1) {
			result++;
			return true;
		}
		isVisited[x][y] = true;
		for (int i = 0; i < 3; i++) {
			int nx = x + dirs[0][i];
			int ny = y + dirs[1][i];
			if(isVaild(nx, ny) && !isVisited[nx][ny] && map[nx][ny]) {				
				if (dfs(nx, ny)) return true;
			}
		}	
		return false;
	}
	
	static boolean isVaild(int nx, int ny) {
		return (0 <= nx && nx < R && 0 <= ny && ny < C ? true : false);
	}

}
