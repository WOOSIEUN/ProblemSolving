import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_27110 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int fried = Integer.parseInt(st.nextToken());
		int soy = Integer.parseInt(st.nextToken());
		int spicy = Integer.parseInt(st.nextToken());
		
		int ans = 0;
		ans += (fried - N > 0 ? N : fried);
		ans += (soy - N > 0 ? N : soy);
		ans += (spicy - N > 0 ? N : spicy);
		
		bw.write(String.valueOf(ans));
		br.close();
		bw.close();
	}
}
