import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_14500 {
	static int[][] dirs = {{-1, 1, 0, 0}, {0, 0, -1, 1}};
	static int[][] map;
	static boolean[][] isVisited;
	static int N, M, max = Integer.MIN_VALUE;	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int [N][M];
		isVisited = new boolean [N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++) {
				isVisited[i][j] = true;
				dfs(i, j, map[i][j], 1);
				isVisited[i][j] = false;
				exceptionBlock(i, j);
			}
		bw.write("" + max);
		br.close();
		bw.close();
	}
	

	 static void exceptionBlock(int x, int y) {
		int sum = map[x][y], cnt = 0;
		for (int i = 0; i < 4; i++) {
			int nx = x + dirs[0][i];
			int ny = y + dirs[1][i];
			if(!isVaild(nx, ny)) cnt++;
			else sum += map[nx][ny];
		}
		if (cnt > 1) return; // 블록 제작이 유효하지 않음
		else if (cnt == 1) max = Math.max(max, sum); //사방 중 하나가 빠진 경우
		else // 사방 돌며 하나씩 제거하여 확인 
			for (int i = 0; i < 4; i++) max = Math.max(max, sum - map[x + dirs[0][i]][y + dirs[1][i]]);
	}

	static void dfs(int x, int y, int sum, int depth) {
		if(depth == 4) {
			max = Math.max(max, sum);
			return;
		}
		for (int i = 0; i < 4; i++) {
			int nx = x + dirs[0][i];
			int ny = y + dirs[1][i];
			if(isVaild(nx, ny) && !isVisited[nx][ny]) {
				isVisited[nx][ny] = true;
				dfs(nx, ny, sum + map[nx][ny], depth + 1);
				isVisited[nx][ny] = false;
			}
		}		
	}

	static boolean isVaild(int nx, int ny) {
		return (0 <= nx && nx < N && 0 <= ny && ny < M ? true : false);
	}
}
