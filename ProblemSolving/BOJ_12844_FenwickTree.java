import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_12844_FenwickTree {
	static class FenwickTree {
		private int[] arrDiffTree, treeDiffTree;
		
		public FenwickTree(int N, int[] values) {
			arrDiffTree = new int [N];
			treeDiffTree = new int [N];			
			init(values);
		}
		
		private void init(int[] values) {
	        for (int i = 1; i < values.length; i++) {
	            rangeUpdate(i, i, values[i]);
	        }
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
		
		private void update(int treeType, int idx, int diff) {
			int[] tree = treeType == 1 ? arrDiffTree : treeDiffTree;
			
		    while (idx < tree.length) {
		    	tree[idx] ^= diff;
				idx += (idx & -idx);
		    }
		}

		private void rangeUpdate(int start, int end, int diff) {
		    update(1, start, diff);
		    update(1, end + 1, diff);
		    update(2, start, diff * ((start - 1) % 2));
		    update(2, end + 1, diff * (end % 2));
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());		
	    
	    int[] weights = new int [N + 1];
	    st = new StringTokenizer(br.readLine());
	    for(int i = 1; i <= N; i++) {
		    weights[i] = Integer.parseInt(st.nextToken());
	    }
	    
		FenwickTree fenwickTree = new FenwickTree(N + 1, weights);

		int M = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(st.nextToken());
			int i = Integer.parseInt(st.nextToken()) + 1;
			int j = Integer.parseInt(st.nextToken()) + 1;

			if (cmd == 1) {
				int k = Integer.parseInt(st.nextToken());
				fenwickTree.rangeUpdate(i, j, k);
			} else {
				sb.append(fenwickTree.rangeQuery(i, j)).append("\n");
			}
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}