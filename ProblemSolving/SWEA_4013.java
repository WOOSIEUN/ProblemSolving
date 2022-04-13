import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SWEA_4013 {
	static int K, result, idx, dir;
	static int [] rotate;
	static int[][] wheel = new int [4][8];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			K = Integer.parseInt(br.readLine());
			result = 0;
			for (int i = 0; i < 4; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 8; j++)
					wheel[i][j] = Integer.parseInt(st.nextToken());					
			}
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				idx = Integer.parseInt(st.nextToken());
				dir = Integer.parseInt(st.nextToken());
				rotate = new int [4];
				rotate[--idx] = dir;
				for (int j = idx; j < 3; j++) {
					if (wheel[j][2] != wheel[j + 1][6]) rotate[j + 1] = -rotate[j];
					else break;
				}
				for (int j = idx; j > 0; j--) {
					if (wheel[j][6] != wheel[j - 1][2]) rotate[j - 1] = -rotate[j];
					else break;
				}
				for (int j = 0; j < 4; j++) {
					if(rotate[j] == 1) {
						int tmp = wheel[j][7];
						for (int k = 7; k > 0; k--) wheel[j][k] = wheel[j][k-1];
						wheel[j][0] = tmp;
					} else if (rotate[j] == -1) {
						int tmp = wheel[j][0];
						for (int k = 0; k < 7; k++) wheel[j][k] = wheel[j][k+1];
						wheel[j][7] = tmp;
					}
				}
			}
			for (int i = 0; i < 4; i++)
				if(wheel[i][0] == 1) result += 1<<i;
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}
