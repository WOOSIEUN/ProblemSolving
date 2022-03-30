import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class JUNGOL_1082 {
	static class Node{
		int x, y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}		
	}
	static int R, C, nx, ny, result, time;
	static boolean isPossible, flag = true;
	static char [][] map;
	static boolean [][] visited;
	static int [][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
	static Queue<Node> fire = new LinkedList<Node>();
	static Queue<Node> jaewoo = new LinkedList<Node>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visited = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().trim().toCharArray();
			for (int j = 0; j < C; j++) {
				char tmp = map[i][j];
				if (tmp == 'S') {
					jaewoo.add(new Node(i, j));
				} else if (tmp == '*') {
					fire.add(new Node(i, j));
				}
			}
		}
		while(flag) {
			spread();
			go();
			if(fire.size() == 0 && jaewoo.size() == 0) {
				flag = false;
			}
		}
		if(isPossible) bw.write(""+result);
		else bw.write("impossible");
		br.close();
		bw.close();
	}
	
	public static void spread() {
		int size = fire.size();
		for (int i = 0; i < size; i++) {
			Node n = fire.poll();
			for (int[] dir : dirs) {
				nx = n.x + dir[0];
				ny = n.y + dir[1];
				if(isInMap(nx, ny) && map[nx][ny] == '.' && !visited[nx][ny]) {
					map[nx][ny] = '*';
					visited[nx][ny] = true;
					fire.offer(new Node(nx, ny));
				}
			}
		}
	}
	
	public static void go() {
		time++;
		int size = jaewoo.size();
		for (int i = 0; i < size; i++) {
			Node cur = jaewoo.poll();
			for (int[] dir : dirs) {
				nx = cur.x + dir[0];
				ny = cur.y + dir[1];
				if(isInMap(nx, ny)) {
					if (map[nx][ny] == 'D') {
						result = time;
						isPossible = true;
						flag = false;
						return;
					} else if(map[nx][ny] == '.' && !visited[nx][ny]) {
						visited[nx][ny] = true;
						jaewoo.offer(new Node(nx, ny));
					}
				}
			}
		}
	}
	
	public static boolean isInMap(int x, int y) {
		return (0 <= x && x < R && 0 <= y && y < C) ? true : false;
	}
}
