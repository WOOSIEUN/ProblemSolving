import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_9229 {
	static int N, M, snack[], max;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			max = -1;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			snack = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; st.hasMoreTokens(); i++)
				snack[i] = Integer.parseInt(st.nextToken());
			int sum = 0;
			for (int i = 0; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {
					sum = snack[i] + snack[j];
					if (max < sum && sum <= M) max = sum;
				}
			}
			System.out.printf("#%d %d\n", t, max);
		}
		br.close();
	}
}
