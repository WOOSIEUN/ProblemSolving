import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_14614 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		String C = st.nextToken();

		int ans = 0;
		if ((C.charAt(C.length() - 1) - '0') % 2 == 0) {
			ans = A;
		} else {
	        ans = A ^ B;
	    }
		
		bw.write(String.valueOf(ans));
		br.close();
		bw.close();
	}
}
