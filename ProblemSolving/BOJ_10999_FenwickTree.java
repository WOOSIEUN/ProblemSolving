import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_10999_FenwickTree {
	static class FenwickTree {
		private long[] arrDiffTree, prefixSumDiffTree;
		
		public FenwickTree(int N) {
			arrDiffTree = new long [N];
			prefixSumDiffTree = new long [N];
		}
		
		private long getTreeValue(int treeType, int idx) {
			long[] tree = treeType == 1 ? arrDiffTree : prefixSumDiffTree;
		     
		    long answer = 0;
		    while (idx > 0) {
		        answer += tree[idx];
		        idx -= (idx & -idx);
		    }
		    return answer;
		}

		private long prefixSum(int idx) {
		    return getTreeValue(1, idx) * idx - getTreeValue(2, idx);
		}

		private long query(int a, int b) {
		    return prefixSum(b) - prefixSum(a - 1);
		}
		
		private void update(int treeType, int idx, long diff) {
			long[] tree = treeType == 1 ? arrDiffTree : prefixSumDiffTree;
		     
		    while (idx < tree.length) {
		    	tree[idx] += diff;
		        idx += idx & -idx;
		    }
		}

		private void rangeUpdate(int a, int b, long diff) {
		    update(1, a, diff);
		    update(1, b + 1, -diff);
		    update(2, a, diff * (a - 1));
		    update(2, b + 1, -diff * b);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
        FenwickTree fenwickTree = new FenwickTree(N + 1);
        
        for(int i = 1; i <= N; i++) {
        	fenwickTree.rangeUpdate(i, i, Long.parseLong(br.readLine()));
		}

        StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M + K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			if (a == 1) {
				long d = Long.parseLong(st.nextToken());
				fenwickTree.rangeUpdate(b, c, d);
			} else {
				sb.append(fenwickTree.query(b, c)).append("\n");
			}
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}
