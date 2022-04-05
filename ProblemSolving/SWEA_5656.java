import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_5656 {
	static class Node {
		int x, y, w;
		public Node(int x, int y, int w) {
			this.x = x;
			this.y = y;
			this.w = w;
		}
	}
	static int N, W, H, min;
	static int[][] map, dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			map = new int[H][W];
			min = Integer.MAX_VALUE;
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			}
			go(0,map);
			sb.append("#").append(t).append(" ").append(min).append("\n");
		}
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
	
	public static boolean go(int count, int[][] map) { // 중복순열 이용하여 구슬을 던지기, 벽돌이 다 부서졌다면 true, 아니면 false
		int result = getRemain(map);
		if(result == 0) { //벽돌이 모두 부서졌다면
			min = 0;
			return true;
		}
		if(count == N) { // 모든 구슬을 다 던졌다면
			min = Math.min(min, result);
			return false;
		}
		
		int[][] newMap = new int[H][W];
		//0열부터 W-1열까지 구슬 던져보기
		for (int y = 0; y < W; y++) {
			//구슬에 맞는 벽돌 찾기
			int x = 0;
			while(x < H && map[x][y]==0) x++; //빈 공간이면 계속해서 아래로
			//해당 열은 벽돌이 없음
			if(x==H) continue;
			//배열의 상태 백업
			copy(map, newMap);
			boom(newMap, x, y); // 현재 벽돌 기준으로 주변의 가능한 모든 벽돌 함께 연쇄 처리
			down(newMap); // 부서진 벽돌 정리
			if(go(count+1, newMap)) return true; // 다음 구슬 던지러 go
		}
		return false;
	}
	
	public static void boom(int[][] map, int x, int y) { // r,c 위치에서 주변의 가능한 모든 벽돌도 함께 부수는 처리
		Queue<Node> queue = new LinkedList<Node>();
		if(map[x][y] > 1) { //벽돌 크기가 2이상이면
			queue.offer(new Node(x,y, map[x][y]));
		}
		map[x][y] = 0; // 자신은 제거처리(빈공간으로)
		
		while(!queue.isEmpty()) {
			Node cur = queue.poll();
			for (int[] dir : dirs) {
				int nx = cur.x;
				int ny = cur.y;
				for (int k = 1; k < cur.w; k++) { // 벽돌의 크기 -1 만큼 반복
					nx += dir[0];
					ny += dir[1];
					if(isInMap(nx, ny)) {
						if(map[nx][ny]>1) // 주변 벽돌에 영향을 주는 벽돌이면
							queue.offer(new Node(nx, ny, map[nx][ny]));
						map[nx][ny] = 0; // 빈공간이면 그냥 0, 벽돌이면 제거 처리
					}
				}
			}
		}
	}
	
	static ArrayList<Integer> list = new ArrayList<Integer>();
	public static void down(int[][] map) { // 부서진 벽돌 정리, 남은 벽돌 정리!! (공중에 떠 있는 벽돌도 아래로 내리기)
		for (int y = 0; y < W; y++) {
			int x = H-1; // 아래행 시작
			while(x>0) {
				if(map[x][y]==0) { //벽돌 찾기
					list.add(map[x][y]);
					map[x][y] = 0;
//					int nx = x-1;
//					while(nx > 0 && map[nx][y] == 0) nx--;
//					map[x][y] = map[nx][y];
//					map[nx][y] = 0;
				}
				x--;
			} // 부서지지 않고 남아있는 벽돌 리스트에 다담기, 벽돌이 있던 자리는 빈공간으로 처리가 됨
			x = H-1;
			for (int a : list) { // 벽돌 리스트
				map[x--][y] = a;
			}
			list.clear();
		}
	}

	public static int getRemain(int[][] map) { // 남은 벽돌 수 리턴
		int cnt = 0;
		for (int i = 0; i < H; i++)
			for (int j = 0; j < W; j++)
				if(map[i][j]>0) cnt++;
		return cnt;
	}
	
	public static void copy(int[][] map, int[][] newMap) {
		for (int i = 0; i < H; i++)
			for (int j = 0; j < W; j++)
				newMap[i][j] = map[i][j];
	}
	
	public static boolean isInMap(int x, int y) {
		return (0 <= x && x < H && 0 <= y && y < W) ? true : false;
	}
}
