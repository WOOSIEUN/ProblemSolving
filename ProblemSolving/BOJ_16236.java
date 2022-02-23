import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16236 {
	static class Fish implements Comparable<Fish>{
		int x, y, dist;
		public Fish(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
		@Override
		public int compareTo (Fish f) {
			if(this.dist == f.dist) {
				if(this.x == f.x) return this.y - f.y;
				else return this.x - f.x;
			} else return this.dist - f.dist;
		}		
	}
	static Fish cur;
	static Queue<Fish> queue = new LinkedList<Fish>();
	static PriorityQueue<Fish> fishes;
	static int N, nx, ny, eat, time, size = 2;
	static int [][] dirs = {{-1, 0}, {0, -1},{1, 0},{0, 1}};
	static int [][] map;
	static boolean[][] isVisited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int [N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9) {
					queue.offer(new Fish(i, j, 0));
					map[i][j] = 0;
				}
			}
		}
		while(true) {
			isVisited = new boolean [N][N];
			fishes = new PriorityQueue<Fish>();
			while(!queue.isEmpty()) {
				cur = queue.poll();
				isVisited[cur.x][cur.y] = true;
				for (int[] dir : dirs) {
					nx = cur.x + dir[0];
					ny = cur.y + dir[1];
					if(isInMap(nx, ny) && !isVisited[nx][ny] && map[nx][ny] <= size) {
						if(0 < map[nx][ny] && map[nx][ny] < size) 
							fishes.offer(new Fish(nx, ny, cur.dist + 1));
						queue.offer(new Fish(nx, ny, cur.dist + 1));
						isVisited[nx][ny] = true;
					}
				}
			}
			if(!fishes.isEmpty()) {
				cur = fishes.poll();
				map[cur.x][cur.y] = 0;
				time += cur.dist;
				if(++eat == size) {
					size++;
					eat = 0;
				}
				queue.add(new Fish(cur.x, cur.y, 0));
			} else break;
		}
		bw.write(""+time);
		br.close();
		bw.close();
	}
	
	public static boolean isInMap(int nx, int ny) {
		return 0 <= nx && nx < N && 0 <= ny && ny < N;
	}	
}
