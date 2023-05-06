import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_1205 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int rank = 1;
		int N = Integer.parseInt(st.nextToken());
		int taesu = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		if (N != 0) {
			int[] scores = new int [N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				scores[i] = Integer.parseInt(st.nextToken());
			}
			if (N==P && taesu <= scores[scores.length-1]) {
				rank = -1;
			} else {
				for (int score : scores){
	                if (taesu < score) {
	                    rank++;
	                } else {
	                    break;
	                }
	            }
			}
		}		
		bw.write(String.valueOf(rank));
		br.close();
		bw.close();
	}
}
