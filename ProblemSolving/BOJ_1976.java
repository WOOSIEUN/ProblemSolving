import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_1976 {
	
	static int[] parents;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		parents = new int[N];
		for (int i = 0; i < N; i++) {
			parents[i] = i;
		}
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				if (Integer.parseInt(st.nextToken()) == 1) {
					union(i, j);
				}
			}
		}

		st = new StringTokenizer(br.readLine());
		boolean travelable = true;
		int parent = find(Integer.parseInt(st.nextToken()) - 1);
		for (int i = 1; i < M; i++) {
			if (parent != find(Integer.parseInt(st.nextToken()) - 1)) {
				travelable = false;
				break;
			}
		}
		
		bw.write(travelable ? "YES" : "NO");
		br.close();
		bw.close();
	}
	
	static private int find(int x) {
		if (parents[x] == x) {
			return x;
		}
		return parents[x] = find(parents[x]);
	}
	
	static private void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if (a > b) {
			parents[b] = a;
		} else {
			parents[a] = b;
		}
	}
}
