import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_12904 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		boolean isChangable = false;
		
		String S = br.readLine();
		StringBuilder T = new StringBuilder(br.readLine());
		
		while (true) {
			if (T.charAt(T.length() - 1) == 'A') {
				T.deleteCharAt(T.length() - 1);
			} else {
				T.deleteCharAt(T.length() - 1);
				T.reverse();
			}
			
			if (T.length() == S.length()) {
				if (T.toString().equals(S)) {
					isChangable = true;
				}
				break;
			}
		}		
		
		bw.write(isChangable ? "1" : "0");
		br.close();
		bw.close();
	}
}
