import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA_4012 {
	static int [][] food;
	static boolean [] isSelected;
	static int N, min;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			food = new int [N][N];
			isSelected = new boolean [N];
			min = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++)	
					food[i][j] = Integer.parseInt(st.nextToken());
			}
			synergy(0, 0);
			sb.append("#" + t + " " + min + "\n");
		}
		bw.write(sb.toString());
		br.close();
		bw.close();
	}

	static void synergy(int cnt, int idx) {
		if(cnt == N/2) {
			min = Math.min(min, Math.abs(getSum(true) - getSum(false)));
			return;
		}
		if (idx == N) return;
		isSelected[idx] = true;
		synergy(cnt + 1, idx + 1);
		isSelected[idx] = false;
		synergy(cnt, idx + 1);
	}

	static int getSum(boolean b) {
		int sum = 0;
		for (int i = 0; i < N; i++)
			if(isSelected[i] == b) 
				for (int j = 0; j < N; j++)
					if(isSelected[j] == b) sum += food[i][j];
		return sum;
	}

}
