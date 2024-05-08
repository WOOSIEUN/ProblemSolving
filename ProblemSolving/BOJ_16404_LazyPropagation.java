import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_16404_LazyPropagation {
	static class SegmentTree {
		private int cnt;
		private int[] tree, lazy, start, end;
		private ArrayList<Integer>[] adjList;
		
		public SegmentTree(int N, ArrayList<Integer>[] adjList) {
			double treeHeight = Math.ceil((Math.log(N) / Math.log(2)));
			tree = new int [(int) Math.pow(2, treeHeight + 1)];
			lazy = new int [(int) Math.pow(2, treeHeight + 1)];
			start = new int [N + 1];
			end = new int [N + 1];
			this.adjList = adjList;
			
			cnt = 0;
			eulerTourTechinque(1, 0);
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

		private int pSum(int from, int to, int cur, int start, int end) {
			propagate(start, end, cur);
			
			if (to < start || end < from) {
				return 0;
			}
			
			if (from <= start && end <= to) {
				return tree[cur];
			}
			
			int mid = (start + end) / 2;
			return pSum(from, to, cur * 2, start, mid) + pSum(from, to, cur * 2 + 1, mid + 1, end);	
		}
		
		private int query(int idx, int N) {
			return pSum(start[idx], start[idx], 1, 1, N);
		}
		
		private int update(int diff, int from, int to, int cur, int start, int end) {
			propagate(start, end, cur);
			
			if (to < start || end < from) {
				return tree[cur];
			}
			
			if (from <= start && end <= to) {
				lazy[cur] += diff;
				propagate(start, end, cur);
				return tree[cur];
			}
			
			int mid = (start + end) / 2;
			return tree[cur] = update(diff, from, to, cur * 2, start, mid) + update(diff, from, to, cur * 2 + 1, mid + 1, end);
		}
		
		private void updateChild(int idx, int diff, int N) {
			update(diff, start[idx], end[idx], 1, 1, N);
		}

		private void propagate(int start, int end, int cur) {
			if (lazy[cur] == 0){
				return;
			}

			if (start != end) {
				lazy[cur * 2] += lazy[cur];
				lazy[cur * 2 + 1] += lazy[cur];
			}
			
			tree[cur] += lazy[cur] * (end - start + 1);
			lazy[cur] = 0;
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

		SegmentTree segmentTree = new SegmentTree(N, adjList);

		StringBuilder sb = new StringBuilder();
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(st.nextToken());
			int i = Integer.parseInt(st.nextToken());
			
			if (cmd == 1) {
				int w = Integer.parseInt(st.nextToken());
				segmentTree.updateChild(i, w, N);
			} else {
				sb.append(segmentTree.query(i, N)).append("\n");
			}
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}