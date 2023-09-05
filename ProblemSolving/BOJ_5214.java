import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_5214 {
	
	static int N, K, M;
	static ArrayList<Integer> [] hyperTubes;
	static boolean [] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		hyperTubes = new ArrayList [N + M + 1];
		visited = new boolean [N + M + 1];
		for (int i = 0; i < N + M + 1; i++) {
			hyperTubes[i] = new ArrayList<>();
		}
		
		for (int hypertube = 0; hypertube < M; hypertube++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < K; j++) {
				int station = Integer.parseInt(st.nextToken());
				hyperTubes[N + hypertube + 1].add(station);
				hyperTubes[station].add(N + hypertube + 1);
			}
		}
		
		bw.write(String.valueOf(getMinStation()));
		br.close();
		bw.close();
	}

	private static int getMinStation() {
		int[] dist = new int[N + M + 1];
        Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(1);
		dist[1] = 1;
        visited[1] = true;
		
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            
            if (cur == N){
                break;
            }
            
            for (int next : hyperTubes[cur]) {
                if (!visited[next]) { 
                	visited[next] = true;                   
                    queue.add(next);
                    dist[next] = next > N ? dist[cur] + 1 : dist[cur];
                }
            }
        }
        return visited[N] ? dist[N] : -1;
	}
}
