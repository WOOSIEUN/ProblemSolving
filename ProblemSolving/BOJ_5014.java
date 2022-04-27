import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_5014 {
	static int F,S,G,U,D, result, cur, next;
	static int[] visited, dirs;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		F = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		U = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		visited = new int[F + 1];
		dirs = new int[2];
		dirs[0] = U;
		dirs[1] = -D;
		result = bfs();
		if(result == -1) bw.write("use the stairs");
		else bw.write(result+"");
		br.close();
		bw.close();
	}
	private static int bfs() {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(S);
		visited[S] = 1;
		while(!queue.isEmpty()) {
			cur = queue.poll();
			if(cur == G) return visited[cur] - 1;
			for (int dir : dirs) {
				next = cur + dir;
				if(isInMap(next) && visited[next] == 0) {
					visited[next] = visited[cur] + 1;
					queue.add(next);
				}
			}
		}
		return -1;
	}
	private static boolean isInMap(int n) {
		return 1 <= n && n <= F;
	}
}
