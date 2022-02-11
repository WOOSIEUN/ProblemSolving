import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SWEA_2805 {
	static int N,sum;
	static String str;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw  = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			sum = 0;
			for (int i = 0; i < N/2; i++) {
				str = br.readLine();
				for (int j = N/2 - i; j <= N/2 + i; j++) {
					sum += str.charAt(j) - '0';
				}
			}
			for (int i = 0; i <= N/2; i++) {
				str = br.readLine();
				for (int j = i; j < N-i; j++)
					sum += str.charAt(j) - '0';
			}
			sb.append("#"+t+" "+sum+"\n");
		}
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}
