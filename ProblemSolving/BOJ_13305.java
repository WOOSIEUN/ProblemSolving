import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_13305 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		long[] dist = new long [N - 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < dist.length; i++) {
			dist[i] = Long.parseLong(st.nextToken());
		}
		
		long[] oil = new long [N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < oil.length; i++) {
			oil[i] = Long.parseLong(st.nextToken());
		}

		long costSum = 0, minCost = oil[0];
		for (int i = 0; i < dist.length; i++) {
			minCost = Math.min(minCost, oil[i]);
			costSum += (minCost * dist[i]);
		}
		
		bw.write(String.valueOf(costSum));
		br.close();
		bw.close();
	}
}
