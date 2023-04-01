import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_1543 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int ans = 0;
		String docs = br.readLine();
		String target = br.readLine();
		for (int i = 0; i < docs.length() - target.length() + 1; i++) {
			boolean flag = false;
			for (int j = 0; j < target.length(); j++) {
				if (docs.charAt(i + j) != target.charAt(j)) {
					flag = true;
					break;
				}
			}
			if (!flag) {
				ans++;
				i += target.length() - 1;
			}
		}
		bw.write(String.valueOf(ans));
		br.close();
		bw.close();
	}
}
