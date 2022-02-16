import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA_6808 {
	static int [] card;
	static boolean[] isSelected;
	static StringBuilder sb;
	static int totalWin, totalLose;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;		
		sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			card = new int [9];
			isSelected = new boolean [19];
			totalWin = totalLose = 0;
			st = new StringTokenizer(br.readLine());
			int tmp;
			for (int i = 0; i < 9; i++) {
				tmp = Integer.parseInt(st.nextToken());
				card[i] = tmp;
				isSelected[tmp] = true;
			}
			permutation(0, 0, 0);
			sb.append("#").append(t).append(" ").append(totalWin).append(" ").append(totalLose).append("\n");
		}
		bw.write(sb.toString());
		br.close();
		bw.close();
	}

	private static void permutation(int cnt, int win, int lose) {
		if(cnt == 9) {
			if(win > lose) totalWin++;
			else totalLose++;
			return;
		}
		for (int i = 1; i < 19; i++) {
			if(isSelected[i]) continue;
			isSelected[i] = true;
			permutation(cnt+1, (card[cnt] > i ? win+card[cnt]+i : win), (card[cnt] < i ? lose+card[cnt]+i : lose));
			isSelected[i] = false;
		}
	}
}
