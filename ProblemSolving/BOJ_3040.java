import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_3040 {
	static StringBuilder sb;
	static int [] hat;
	static boolean [] isVisited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		sb = new StringBuilder();
		hat = new int [9];
		isVisited = new boolean [9];
		for (int i = 0; i < 9; i++)
			hat[i] = Integer.parseInt(br.readLine());
		subset(0,0,0);
		bw.write(sb.toString());
		br.close();
		bw.close();
	}

	private static void subset(int cnt, int idx, int hatSum) {
		if(cnt == 7) {
			if (hatSum == 100)
				for (int i = 0; i < 9; i++)
					if(isVisited[i])
						sb.append(hat[i] + "\n");
			return;
		} else if (idx == 9) return;
		isVisited[idx] = true;
		subset(cnt + 1, idx + 1, hatSum + hat[idx]);
		isVisited[idx] = false;
		subset(cnt, idx + 1, hatSum);
	}
}