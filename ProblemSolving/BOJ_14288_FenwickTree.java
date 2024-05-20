import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_14288_FenwickTree {
	static class FenwickTree {
		private int cnt;
		private int[] tree, start, end;
		private ArrayList<Integer>[] adjList;
		
		public FenwickTree(int N, ArrayList<Integer>[] adjList) {
			tree = new int [N];
			start = new int [N];
			end = new int [N];
			this.adjList = adjList;
			
			cnt = 0;
			eulerTourTechnique(1);
		}

		private void eulerTourTechnique(int x) {
		    start[x] = ++cnt;

		    for (int next : adjList[x]) {
		        eulerTourTechnique(next);
		    }
		    
		    end[x] = cnt;
		}

		private int query(int idx) {
			int result = 0;
			while (idx > 0) {
				result += tree[idx];
			    idx -= (idx & -idx);
			}
			return result;	
		}
		
		private int queryDownward(int idx) {			
			return query(start[idx]);	
		}
		
		private int queryUpward(int idx) {			
			return query(end[idx]) - query(start[idx] - 1);	
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
		
		private void updateDownward(int startIdx, int endIdx, int diff) {
	        rangeUpdate(start[startIdx], end[endIdx], diff);
		}
		
		private void updateUpward(int idx, int diff) {
			update(start[idx], diff);
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

	    st = new StringTokenizer(br.readLine());
	    st.nextToken();
	    for(int i = 2; i <= N; i++) {
	    	adjList[Integer.parseInt(st.nextToken())].add(i);
	    }

		FenwickTree downwardFenwickTree = new FenwickTree(N + 1, adjList);
		FenwickTree upwardFenwickTree = new FenwickTree(N + 1, adjList);

		StringBuilder sb = new StringBuilder();
		boolean isDownward = true;
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(st.nextToken());
			
			if (cmd == 1) {
				int i = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				
				if (isDownward) {
					downwardFenwickTree.updateDownward(i, i, w);
				} else {
					upwardFenwickTree.updateUpward(i, w);
				}
			} else if (cmd == 2) {
				int i = Integer.parseInt(st.nextToken());
				sb.append(downwardFenwickTree.queryDownward(i) + upwardFenwickTree.queryUpward(i)).append("\n");
			} else {
				isDownward = !isDownward;
			}
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}
