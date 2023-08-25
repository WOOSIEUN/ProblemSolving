import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_11501 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] stockPrice = new int [N];
			int maxStockPrice = 0;
			long sumOfStockPrice = 0;
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				stockPrice[i] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = N - 1; i >= 0; i--) {
				if (maxStockPrice < stockPrice[i]) {
					maxStockPrice = stockPrice[i];
				} else {
					sumOfStockPrice += (maxStockPrice - stockPrice[i]);
				}
			}
			sb.append(sumOfStockPrice).append("\n");
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}
