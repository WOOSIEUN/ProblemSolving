import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_2961 {
	static int N, min = Integer.MAX_VALUE;
	static int[][] food;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		food = new int [N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			food[i][0] = Integer.parseInt(st.nextToken());
			food[i][1] = Integer.parseInt(st.nextToken());
		}
		subset(0,1,0);
		bw.write(""+min);
		br.close();
		bw.close();
	}

	private static void subset(int cnt, int sour, int bitter) {
		if(bitter > 0 || sour > 1) 
			if(Math.abs(bitter-sour) < min) min = Math.abs(bitter-sour);
		if(cnt == N) return;
		subset(cnt+1, sour * food[cnt][0], bitter + food[cnt][1]);
		subset(cnt+1, sour, bitter);
	}
}