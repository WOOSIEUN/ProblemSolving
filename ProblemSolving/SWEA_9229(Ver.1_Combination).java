import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_9229 {
	static int N, M, snack[], max, selected[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			max = -1;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			snack = new int [N];
			selected = new int[2];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; st.hasMoreTokens(); i++) 
				snack[i] = Integer.parseInt(st.nextToken()); 
			combi(0, 0);
			System.out.printf("#%d %d\n", t, max);
		}
		br.close();
	}

	static void combi(int cnt, int start) {
		if(cnt == 2) {
			int sum = selected[0] + selected[1];
			if(sum > M) return;
			else if(max < sum)
				max = sum;
			return;		
		}
		for(int i = start; i < N; i++) {
			selected[cnt] = snack[i];
			combi(cnt+1,i+1);
		}
	}
}
