import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_17413 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), "<>", true);
		while (st.hasMoreTokens()) {
			String word = st.nextToken();
			if (word.charAt(0) == '<') {
				sb.append(word).append(st.nextToken()).append(st.nextToken());
			} else {
				StringTokenizer stBySpace = new StringTokenizer(word);
				while (stBySpace.hasMoreTokens()) {
					sb.append(reverse(stBySpace.nextToken())).append(" ");
				}
				sb.deleteCharAt(sb.length() - 1);
			}
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}

	private static String reverse(String target) {
		StringBuilder sb = new StringBuilder();
		return sb.append(target).reverse().toString();
	}
}
