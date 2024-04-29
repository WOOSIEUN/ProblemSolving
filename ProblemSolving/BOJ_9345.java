import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_9345 {
	static abstract class SegmentTree {
		int[] tree;
		
		public SegmentTree(int N, int[] value) {
			double treeHeight = Math.ceil((Math.log(N) / Math.log(2)));
			tree = new int [(int) Math.pow(2, treeHeight + 1)];
			init(value, 1, 0, N - 1);
		}
		
		abstract int init(int[] value, int cur, int start, int end);
		abstract int query(int from, int to, int cur, int start, int end);
		abstract int update(int value, int index, int cur, int start, int end);
	}
	
	static class MinSegmentTree extends SegmentTree {
		public MinSegmentTree(int N, int[] value) {
			super(N, value);
		}

		int init(int[] value, int cur, int start, int end) {
			if (start == end) {
				return tree[cur] = value[start];
			}
			
			int mid = (start + end) / 2;
			return tree[cur] = Math.min(init(value, cur * 2, start, mid), init(value, cur * 2 + 1, mid + 1, end));
		}
		
		int query(int from, int to, int cur, int start, int end) {
			if (to < start || end < from) {
				return Integer.MAX_VALUE;
			}
			
			if (from <= start && end <= to) {
				return tree[cur];
			}
			
			int mid = (start + end) / 2;
			return Math.min(query(from, to, cur * 2, start, mid), query(from, to, cur * 2 + 1, mid + 1, end));
		}
		
		int update(int value, int index, int cur, int start, int end) {
			if (index < start || end < index) {
				return tree[cur];
			}
			
            if (start == end) {
            	return tree[cur] = value;
            }
            
			int mid = (start + end) / 2;
            return tree[cur] = Math.min(update(value, index, cur * 2, start, mid), update(value, index, cur * 2 + 1, mid + 1, end));
		}
	}
	
	static class MaxSegmentTree extends SegmentTree {
		public MaxSegmentTree(int N, int[] value) {
			super(N, value);
		}
		
		int init(int[] value, int cur, int start, int end) {
			if (start == end) {
				return tree[cur] = value[start];
			}
			
			int mid = (start + end) / 2;
			return tree[cur] = Math.max(init(value, cur * 2, start, mid), init(value, cur * 2 + 1, mid + 1, end));
		}
		
		int query(int from, int to, int cur, int start, int end) {
			if (to < start || end < from) {
				return Integer.MIN_VALUE;
			}
			
			if (from <= start && end <= to) {
				return tree[cur];
			}

			int mid = (start + end) / 2;
			return Math.max(query(from, to, cur * 2, start, mid), query(from, to, cur * 2 + 1, mid + 1, end));
		}
		
		int update(int value, int index, int cur, int start, int end) {
			if (index < start || end < index) {
				return tree[cur];
			}
			
            if (start == end) {
            	return tree[cur] = value;
            }
            
			int mid = (start + end) / 2;
            return tree[cur] = Math.max(update(value, index, cur * 2, start, mid), update(value, index, cur * 2 + 1, mid + 1, end));
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			int[] values = new int [N];
			for(int i = 0; i < N; i++){
				values[i] = i;
			}

	        SegmentTree minSegmentTree = new MinSegmentTree(N, values);
	        SegmentTree maxSegmentTree = new MaxSegmentTree(N, values);
	        
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int Q = Integer.parseInt(st.nextToken());
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				
				if (Q == 0) {
					minSegmentTree.update(values[B], A, 1, 0, N - 1);
					minSegmentTree.update(values[A], B, 1, 0, N - 1);
					maxSegmentTree.update(values[B], A, 1, 0, N - 1);
					maxSegmentTree.update(values[A], B, 1, 0, N - 1);
					
					int tmp = values[A];
					values[A] = values[B];
					values[B] = tmp;
				} else {
					int min = minSegmentTree.query(A, B, 1, 0, N - 1);
					int max = maxSegmentTree.query(A, B, 1, 0, N - 1);

					sb.append((min == A && max == B) ? "YES\n" : "NO\n");
				}
			}
		}		
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}
