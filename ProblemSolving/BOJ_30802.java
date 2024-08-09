import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_30802 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer tshirtSt = new StringTokenizer(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());

		int numOfTShirtBundles = 0;
		while (tshirtSt.hasMoreTokens()) {
			numOfTShirtBundles += (int) Math.ceil(Double.parseDouble(tshirtSt.nextToken()) / T);
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(numOfTShirtBundles).append("\n").append(N / P).append(" ").append(N % P);
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}
