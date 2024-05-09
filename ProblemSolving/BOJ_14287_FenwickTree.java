import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_14287_FenwickTree {
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
			int endIdx = end[idx];
			int result = 0;
			while (endIdx > 0) {
				result += tree[endIdx];
				endIdx -= (endIdx & -endIdx);
			}

			int startIdx = start[idx] - 1;
			while (startIdx > 0) {
				result -= tree[startIdx];
				startIdx -= (startIdx & -startIdx);
			}
			return result;	
		}
		
		private void update(int idx, int diff) {
			idx = start[idx];
		    while (idx < tree.length) {
		    	tree[idx] += diff;
				idx += (idx & -idx);
		    }
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
	    
		FenwickTree fenwickTree = new FenwickTree(N + 1, adjList);

		StringBuilder sb = new StringBuilder();
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(st.nextToken());
			int i = Integer.parseInt(st.nextToken());
			
			if (cmd == 1) {
				int w = Integer.parseInt(st.nextToken());
				fenwickTree.update(i, w);
			} else {
				sb.append(fenwickTree.query(i)).append("\n");
			}
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}