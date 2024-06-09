import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_6581 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		final String HR = "--------------------------------------------------------------------------------\n";

		int lineLen = 0;
		String line = "";
		StringBuilder sb = new StringBuilder();
		while ((line = br.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(line, " \t\n");
			while (st.hasMoreTokens()) {
				String word = st.nextToken();

				if (word.equals("<br>")) {
					if (sb.length() != 0 && sb.charAt(sb.length() - 1) == ' ') {
						sb.deleteCharAt(sb.length() - 1);
					}
					lineLen = 0;
					sb.append("\n");
				} else if (word.equals("<hr>")) {
					if (lineLen != 0) {
						if (sb.charAt(sb.length() - 1) == ' ') {
							sb.deleteCharAt(sb.length() - 1);
						}
						lineLen = 0;
						sb.append("\n");
					}
					sb.append(HR);
				} else if (word.equals("")) {
					continue;
				} else {
					if (lineLen + word.length() <= 80) {
						lineLen += word.length();
					} else {
						if (sb.charAt(sb.length() - 1) == ' ') {
							sb.deleteCharAt(sb.length() - 1);
						}
						lineLen = word.length();
						sb.append("\n");
					}

					sb.append(word);

					if (lineLen < 80) {
						lineLen++;
						sb.append(" ");
					}
				}
			}
		}

		bw.write(sb.deleteCharAt(sb.length() - 1).toString());
		br.close();
		bw.close();
	}
}
