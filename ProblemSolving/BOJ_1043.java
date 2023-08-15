import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1043 {
	
	static int [] parent;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int answer = 0;
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		parent = new int [N + 1];
		boolean [] truth = new boolean [N + 1];
        for (int i = 1; i <= N; i++) {
        	parent[i] = i;
        }
        
        st = new StringTokenizer(br.readLine());
        int numOfTruth = Integer.parseInt(st.nextToken());
        for (int i = 0; i < numOfTruth; i++) {
        	truth[Integer.parseInt(st.nextToken())] = true;
        }
        
        ArrayList<Integer>[] people = new ArrayList [M];        
		for (int i = 0; i < M; i++) {
			people[i] = new ArrayList<> ();
			st = new StringTokenizer(br.readLine());
			int numOfMember = Integer.parseInt(st.nextToken());
			int pre = Integer.parseInt(st.nextToken());
			people[i].add(pre);
			for (int j = 1; j < numOfMember; j++) {
				int cur = Integer.parseInt(st.nextToken());
				people[i].add(cur);
				union(pre, cur);
				pre = cur;
			}
		}
		
		for (int i = 1; i < N + 1; i++) {
			if (truth[i]) {
				truth[find(i)] = true;
			}
		}
		
		for (int i = 0; i < M; i++) {
			if(!truth[find(people[i].get(0))]) {
				answer++;
			}
		}
		
		bw.write(String.valueOf(answer));
		br.close();
		bw.close();
	}
	
	private static int find(int node) {
		if (parent[node] == node) {
			return node;
		}
		parent[node] = find(parent[node]);
		return parent[node];
	}

	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a != b) {
			if (a < b) {
				parent[b] = a;
			} else {
				parent[a] = b;
			}
		}
		
	}
}
