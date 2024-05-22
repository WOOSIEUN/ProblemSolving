import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_18437 {
	static class SegmentTree {
		private int cnt;
		private int[] tree, lazy, start, end;
		private ArrayList<Integer>[] adjList;
		
		public SegmentTree(int N, ArrayList<Integer>[] adjList, int value) {
			double treeHeight = Math.ceil((Math.log(N) / Math.log(2)));
			tree = new int [(int) Math.pow(2, treeHeight + 1)];
			lazy = new int [(int) Math.pow(2, treeHeight + 1)];
			Arrays.fill(lazy, -1);
			
			start = new int [N + 1];
			end = new int [N + 1];
			this.adjList = adjList;
			
			cnt = 0;
			eulerTourTechnique(1);

			init(value, 1, 1, N);
		}
		
		private int init(int value, int cur, int start, int end) {
			if (start == end) {
				return tree[cur] = value;
			}
			
			int mid = (start + end) / 2;
			return tree[cur] = init(value, cur * 2, start, mid) + init(value, cur * 2 + 1, mid + 1, end);
		}

		private void eulerTourTechnique(int x) {
		    start[x] = ++cnt;

		    for (int next : adjList[x]) {
		        eulerTourTechnique(next);
		    }
		    
		    end[x] = cnt;
		}

		private int query(int from, int to, int cur, int start, int end) {
			propagate(start, end, cur);
			
			if (to < start || end < from) {
				return 0;
			}
			
			if (from <= start && end <= to) {
				return tree[cur];
			}
			
			int mid = (start + end) / 2;
			return query(from, to, cur * 2, start, mid) + query(from, to, cur * 2 + 1, mid + 1, end);	
		}
		
		private int queryChild(int idx, int N) {
			return query(start[idx] + 1, end[idx], 1, 1, N);
		}
		
		private int update(int value, int from, int to, int cur, int start, int end) {
			propagate(start, end, cur);
			
			if (to < start || end < from) {
				return tree[cur];
			}
			
			if (from <= start && end <= to) {
				lazy[cur] = value;
				propagate(start, end, cur);
				return tree[cur];
			}
			
			int mid = (start + end) / 2;
			return tree[cur] = update(value, from, to, cur * 2, start, mid) + update(value, from, to, cur * 2 + 1, mid + 1, end);
		}
				
		private void updateChild(int idx, int value, int N) {
			update(value, start[idx] + 1, end[idx], 1, 1, N);
		}

		private void propagate(int start, int end, int cur) {
			if (lazy[cur] == -1){
				return;
			}

			if (start != end) {
				lazy[cur * 2] = lazy[cur];
				lazy[cur * 2 + 1] = lazy[cur];
			}
			
			tree[cur] = lazy[cur] * (end - start + 1);
			lazy[cur] = -1;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<Integer>[] adjList = new ArrayList [N + 1];
		for (int i = 1; i <= N; i++) {
			adjList[i] = new ArrayList<>();
		}

	    st = new StringTokenizer(br.readLine());
	    st.nextToken();
	    for(int i = 2; i <= N; i++) {
	    	adjList[Integer.parseInt(st.nextToken())].add(i);
	    }

		SegmentTree segmentTree = new SegmentTree(N, adjList, 1);

		int M = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(st.nextToken());
			int i = Integer.parseInt(st.nextToken());

			if (cmd == 1) {
				segmentTree.updateChild(i, 1, N);
			} else if (cmd == 2) {
				segmentTree.updateChild(i, 0, N);
			} else {
				sb.append(segmentTree.queryChild(i, N)).append("\n");
			}
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}
