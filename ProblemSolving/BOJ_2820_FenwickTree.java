import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_2820_FenwickTree {
	static class FenwickTree {
		private int cnt;
		private int[] tree, start, end;
		private ArrayList<Integer>[] adjList;
		
		public FenwickTree(int N, int[] salary, ArrayList<Integer>[] adjList) {
			tree = new int [N];
			start = new int [N];
			end = new int [N];
			this.adjList = adjList;
			
			cnt = 0;
			eulerTourTechinque(1, 0);
			
			init(salary);
		}
		
		private void init(int[] salary) {
	        for (int i = 1; i < tree.length; i++) {
	            rangeUpdate(start[i], start[i], salary[i]);
	        }
		}

		private void eulerTourTechinque(int x, int parent) {
		    start[x] = ++cnt;

		    for (int next : adjList[x]) {
		        if (next == parent) {
			        continue;
		        }
		        eulerTourTechinque(next, x);
		    }
		    
		    end[x] = cnt;
		}

		private int query(int idx) {
			idx = start[idx];
			int result = 0;
			while (idx > 0) {
				result += tree[idx];
			    idx -= (idx & -idx);
			}
			return result;	
		}
		
		private void update(int idx, int diff) {		     
		    while (idx < tree.length) {
		    	tree[idx] += diff;
				idx += (idx & -idx);
		    }
		}

		private void rangeUpdate(int a, int b, int diff) {
		    update(a, diff);
		    update(b + 1, -diff);
		}
		
		private void updateChild(int idx, int diff) {
	        rangeUpdate(start[idx] + 1, end[idx], diff);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] salary = new int [N + 1];
		ArrayList<Integer>[] adjList = new ArrayList [N + 1];
		for (int i = 1; i <= N; i++) {
			adjList[i] = new ArrayList<>();
		}
        
		salary[1] = Integer.parseInt(br.readLine());
	    for(int i = 2; i <= N; i++) {
		    st = new StringTokenizer(br.readLine());
		    salary[i] = Integer.parseInt(st.nextToken());
	    	adjList[Integer.parseInt(st.nextToken())].add(i);
	    }

		FenwickTree fenwickTree = new FenwickTree(N + 1, salary, adjList);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			char cmd = st.nextToken().charAt(0);
			int a = Integer.parseInt(st.nextToken());
			
			if (cmd == 'p') {
				int x = Integer.parseInt(st.nextToken());
				fenwickTree.updateChild(a, x);
			} else {
				sb.append(fenwickTree.query(a)).append("\n");
			}
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}