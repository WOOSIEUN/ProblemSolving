import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;

public class BOJ_1427 {
	public static void main(String[] args) throws IOException {
		InputStream in = System.in;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int ch;
		int[] count = new int [10];
		while ((ch = in.read()) != '\n') {
			count[ch - '0']++;
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 9; i >= 0; i--) {
			while (count[i]-- > 0) {
				sb.append(i);
			}
		}
		
		bw.write(sb.toString());
		bw.close();
	}
}
