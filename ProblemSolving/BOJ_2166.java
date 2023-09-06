import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_2166 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] polygon = new int [N + 1][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			polygon[i][0] = Integer.parseInt(st.nextToken());
			polygon[i][1] = Integer.parseInt(st.nextToken());
		}
		
		polygon[N][0] = polygon[0][0];
		polygon[N][1] = polygon[0][1];
		
		long sum = 0;
        for (int i = 0; i < N; i++) {
            sum += (long) polygon[i][0] * polygon[i + 1][1] - (long) polygon[i + 1][0] * polygon[i][1];
        } 
		
		bw.write(String.format("%.1f", (Math.abs(sum) / 2.0)));
		br.close();
		bw.close();
	}
}
