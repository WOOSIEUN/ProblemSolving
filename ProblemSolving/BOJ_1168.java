import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_1168 {
	
	static int[] tree;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		double treeHeight = Math.ceil(Math.log(N) / Math.log(2));
		tree = new int [(int) Math.pow(2, treeHeight + 1)];
		init(1, 1, 0, N - 1);
		
		int idx = K;
		sb.append("<");
		for (int i = 0; i < N; i++) {
			sb.append(query(idx, 1, 0, N - 1) + 1);
			
			if (i < N - 1) {
				idx = (idx + K - 2) % (N - i - 1) + 1;
				sb.append(", ");
			}
		}
		sb.append(">");
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
	
	private static int init(int num, int cur, int left, int right) {
		if (left == right) {
			return tree[cur] = num;
		}
		
		int mid = (left + right) / 2;
		return tree[cur] = init(num, cur * 2, left, mid) + init(num, cur * 2 + 1, mid + 1, right);		
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
