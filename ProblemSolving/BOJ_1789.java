import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_1789 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		long N = Long.parseLong(br.readLine());
		long sum = 0, cnt = 0;
		for (long i = 1; ; i++) {
			if (sum > N) {
				break;
			}
			
			sum += i;
			cnt++;
		}
		
		bw.write(String.valueOf(cnt - 1));
		br.close();
		bw.close();
	}
}
