import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17143 {
	static class Node {
		int x, y, s, d, z;
		public Node(int x, int y, int s, int d, int z) {
			this.x = x;
			this.y = y;
			this.s = s;
			this.d = d;
			this.z = z;
		}
	}
	static int R, C, M, result, x, y, s, d, z, nx, ny;
	static int[][] dirs = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };
	static Node[][] sharks;
	static Queue<Node> q;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		sharks = new Node[R][C];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			z = Integer.parseInt(st.nextToken()); 
			if (d == 1) d = 0;
			else if (d == 4) d = 1;
			if (d == 0 || d == 2) s %= (R - 1) * 2; 
			else if (d == 1 || d == 3) s %= (C - 1) * 2;
			sharks[x-1][y-1] = new Node(x-1, y-1, s, d, z);
		}

		for (int j = 0; j < C; j++) {
			catchShark(j);
			findShark();
			moveShark();
		}
		
		bw.write(""+result);
		br.close();
		bw.close();
	}

	private static void moveShark() {
		sharks = new Node[R][C];
		while(!q.isEmpty()) {
			Node cur = q.poll();
			for(int s = 0; s < cur.s; s++) { 
				nx = cur.x + dirs[cur.d][0]; 
				ny = cur.y + dirs[cur.d][1];
				if(!isInMap(nx, ny)) { 
					cur.x -= dirs[cur.d][0];
					cur.y -= dirs[cur.d][1];
					cur.d = (cur.d + 2) % 4;
					continue;
				} else {
					cur.x = nx; 
					cur.y = ny;
				}
			}
			if(sharks[cur.x][cur.y] != null) {
				if(sharks[cur.x][cur.y].z < cur.z)
					sharks[cur.x][cur.y] = new Node(cur.x, cur.y, cur.s, cur.d, cur.z);
			} else {
				sharks[cur.x][cur.y] = new Node(cur.x, cur.y, cur.s, cur.d, cur.z);
			}
		}
	}

	private static void catchShark(int j) {
		for (int i = 0; i < R; i++)
			if (sharks[i][j] != null) {
				result += sharks[i][j].z;
				sharks[i][j] = null;
				break;
			}
	}

	private static void findShark() {
		q = new LinkedList<>(); 
		for(int i = 0; i < R; i++)
			for(int j = 0; j < C; j++)
				if(sharks[i][j] != null)
					q.add(new Node(i, j, sharks[i][j].s, sharks[i][j].d, sharks[i][j].z));
	}

	public static boolean isInMap(int nx, int ny) {
		return 0 <= nx && nx < R && 0 <= ny && ny < C;
	}	
}
