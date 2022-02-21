import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class SWEA_1238 {
	static StringBuilder sb;
	static int len, start, from, to, max, maxIdx;
	static ArrayList<Integer> [] adjList;
	static int [] depth;
	static boolean [] isVisited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		sb = new StringBuilder();
		for (int t = 1; t <= 10; t++) {
			adjList = new ArrayList[101];
			isVisited = new boolean[101];
			depth = new int[101];
			for (int i = 1; i < 101; i++)
				adjList[i] = new ArrayList<Integer>();
			
			st = new StringTokenizer(br.readLine());
			len = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < len/2; i++) {
				from = Integer.parseInt(st.nextToken());
				to = Integer.parseInt(st.nextToken());
				adjList[from].add(to);
			}			
			bfs(start);
			sb.append("#").append(t).append(" ").append(maxIdx).append("\n");
		}
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
	
	public static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(start);
		isVisited[start] = true;
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			for (Integer next : adjList[cur]) {
				if(!isVisited[next]) {
					isVisited[next] = true;
					depth[next] = depth[cur] + 1;
					queue.offer(next);
				}				
			}			
		}
		
		max = 0;
		for (int i = 1; i < 101; i++)
			if(max <= depth[i]) {
				max = depth[i];
				maxIdx = i;
			}
	}
}
