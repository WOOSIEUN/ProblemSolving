import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_15782_FenwickTree {
	static class FenwickTree {
		private int cnt;
		private int[] arrDiffTree, treeDiffTree, start, end;
		private ArrayList<Integer>[] adjList;
		
		public FenwickTree(int N, int[] values, ArrayList<Integer>[] adjList) {
			arrDiffTree = new int [N];
			treeDiffTree = new int [N];
			start = new int [N];
			end = new int [N];
			this.adjList = adjList;
			
			cnt = 0;
			eulerTourTechnique(1, 0);
			
			init(values);
		}
		
		private void init(int[] values) {
	        for (int i = 1; i < arrDiffTree.length; i++) {
	            rangeUpdate(start[i], start[i], values[i]);
	        }
		}

		private void eulerTourTechnique(int x, int parent) {
		    start[x] = ++cnt;

		    for (int next : adjList[x]) {
		        if (next == parent) {
			        continue;
		        }
		        eulerTourTechnique(next, x);
		    }
		    
		    end[x] = cnt;
		}

		private int getTreeValue(int treeType, int idx) {
			int[] tree = treeType == 1 ? arrDiffTree : treeDiffTree;
			
			int result = 0;
			while (idx > 0) {
				result ^= tree[idx];
			    idx -= (idx & -idx);
			}
			return result;
		}
		
		private int query(int idx) {
			return ((idx % 2) * getTreeValue(1, idx)) ^ getTreeValue(2, idx);
		}
		
		private int rangeQuery(int start, int end){
		    return query(end) ^ query(start - 1);
		}
		
		private int queryChild(int idx) {
	        return rangeQuery(start[idx], end[idx]);
		}
		
		private void update(int treeType, int idx, int diff) {
			int[] tree = treeType == 1 ? arrDiffTree : treeDiffTree;
			
		    while (idx < tree.length) {
		    	tree[idx] ^= diff;
				idx += (idx & -idx);
		    }
		}

		private void rangeUpdate(int a, int b, int diff) {
		    update(1, a, diff);
		    update(1, b + 1, diff);
		    update(2, a, diff * ((a - 1) % 2));
		    update(2, b + 1, diff * (b % 2));
		}
		
		private void updateChild(int idx, int diff) {
	        rangeUpdate(start[idx], end[idx], diff);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer>[] adjList = new ArrayList [N + 1];
		for (int i = 1; i <= N; i++) {
			adjList[i] = new ArrayList<>();
		}
        
	    for(int i = 1; i < N; i++) {
		    st = new StringTokenizer(br.readLine());
		    int A = Integer.parseInt(st.nextToken());
		    int B = Integer.parseInt(st.nextToken());
	    	adjList[A].add(B);
	    	adjList[B].add(A);
	    }
	    
	    int[] weights = new int [N + 1];
	    st = new StringTokenizer(br.readLine());
	    for(int i = 1; i <= N; i++) {
		    weights[i] = Integer.parseInt(st.nextToken());
	    }
	    
		FenwickTree fenwickTree = new FenwickTree(N + 1, weights, adjList);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());

			if (cmd == 1) {
				sb.append(fenwickTree.queryChild(x)).append("\n");
			} else {
				int y = Integer.parseInt(st.nextToken());
				fenwickTree.updateChild(x, y);				
			}
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}