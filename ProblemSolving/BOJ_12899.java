import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_12899 {
	
	static final int MAX = 2000000;
	static int[] tree;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		double treeHeight = Math.ceil(Math.log(MAX) / Math.log(2));
		tree = new int [(int) Math.pow(2, treeHeight + 1)];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			if (cmd == 1) {
				update(num - 1, 1, 0, MAX - 1);
			} else {
				sb.append(query(num, 1, 0, MAX - 1) + 1).append("\n");
			}
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
	
	private static int update(int num, int cur, int left, int right) {
		if (left == right) {
			tree[cur] += 1;
			return tree[cur];
		}
		
		int mid = (left + right) / 2;
		if (mid >= num) {
			update(num, cur * 2, left, mid);			
		} else {
			update(num, cur * 2 + 1, mid + 1, right);			
		}
		
		return tree[cur] = tree[cur * 2] + tree[cur * 2 + 1];		
	}

	private static int query(int idx, int cur, int left, int right) {
		if (left == right){
             tree[cur] -= 1;
             return left;
		 }

		int mid = (left + right) / 2;
		int ans = 0;
		if (idx <= tree[cur * 2]) {
			ans = query(idx, cur * 2, left, mid);
		} else {
			ans = query(idx - tree[cur * 2], cur * 2 + 1, mid + 1, right);
		}

		tree[cur] = tree[cur * 2] + tree[cur * 2 + 1];
		return ans;
	}
}
