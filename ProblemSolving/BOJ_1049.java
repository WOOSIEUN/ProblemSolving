import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_1049 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int minPackage = 1000, minString = 1000;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			minPackage = Math.min(minPackage, Integer.parseInt(st.nextToken()));
			minString = Math.min(minString, Integer.parseInt(st.nextToken()));
		}
		
		bw.write(String.valueOf(minPackage > minString * 6 ? (minString * N) : (minPackage * (N / 6) + Math.min(N % 6 * minString, minPackage))));
		br.close();
		bw.close();
	}
}
