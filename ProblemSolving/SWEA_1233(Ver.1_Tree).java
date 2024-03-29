import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA_1233 {
	static String[] tree;
	static int vaild, N, cur, mid;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder result = new StringBuilder();
		StringTokenizer st;
		for (int t = 1; t <= 10; t++) {
			vaild = 1;
			N = Integer.parseInt(br.readLine());
			mid = N/2;
			tree = new String[N+1];
			for (int i = 1; i < N+1; i++) {
				st = new StringTokenizer(br.readLine());
				tree[Integer.parseInt(st.nextToken())] = st.nextToken();
			}
			for (int i = 1; i < N+1; i++) {
				cur = tree[i].charAt(0);
				if (0 <= cur - '0' && cur - '0' <= 9) {
					if (i <= mid) {
						vaild = 0;
						break;
					}
				} else {
					if (i > mid) {
						vaild = 0;
						break;
					}
				}
			}
			result.append("#"+t+" "+vaild+"\n");
		}
		bw.write(result.toString());
		br.close();
		bw.close();
	}
}