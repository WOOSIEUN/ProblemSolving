import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_1074 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int pow, result = 0;
		while(N-- > 0) {
			pow = (int)Math.pow(2, N);
			if (r < pow && c < pow) 
				result += pow * pow * 0;
			else if (r < pow && c >= pow) {
				c -= pow;
				result += pow * pow * 1;
			} else if (r >= pow && c < pow) { 
				r -= pow;
				result += pow * pow * 2;
			}else if (r >= pow && c >= pow) {
				r -= pow;
				c -= pow;
				result += pow * pow * 3;				
			}
		}
		bw.write(""+result);
		br.close();
		bw.close();
	}
}
