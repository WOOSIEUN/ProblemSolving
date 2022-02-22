import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA_3289 {
	static int[] parent;
	static int N, M;
	static int[] cmd = new int [3];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			makeSet();
			sb.append("#").append(t).append(" ");
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 3; j++) cmd[j] = Integer.parseInt(st.nextToken());
				if(cmd[0] == 0) union(cmd[1], cmd[2]);
				else sb.append((find(cmd[1]) == find(cmd[2]) ? "1" : "0"));
			}
			sb.append("\n");
		}
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
	
	public static void makeSet() {
		parent = new int[N+1];
		for(int i = 0; i < N+1; i++)
			parent[i] = i;		
	}
	
	private static int find(int i) {
		if (parent[i] == i) return i;
		else return parent[i] = find(parent[i]);
	}

	private static void union(int i, int j) {
		int pi = find(i);
		int pj = find(j);		
		if(pi != pj)
			parent[pj] = pi;
	}		
}
