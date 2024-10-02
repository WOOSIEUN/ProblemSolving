import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_1016 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long min = Long.parseLong(st.nextToken());
		long max = Long.parseLong(st.nextToken());

		int ans = (int) (max - min + 1);
		boolean[] check = new boolean [ans];
		
		for (long i = 2; i * i <= max; i++) {
			long power = i * i;
			long divided = min / power;
			
			if (min % power != 0) {
				divided++;
			}
			
			for (long j = divided; j * power <= max; j++) {
				int powerYes = (int) (j * power - min);
				
				if(!check[powerYes]) {
					check[powerYes] = true;
					ans--;
				}
			}
		}
		
		bw.write(String.valueOf(ans));
		br.close();
		bw.close();
	}
}
