import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;

public class BOJ_1264 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		
		final HashSet<Character> vowel = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
		
		StringBuilder sb = new StringBuilder();
		String line;
		while (!(line = br.readLine()).equals("#")) {
			int ans = 0;
			char[] lineToChar = line.toCharArray();
			for (int i = 0; i < lineToChar.length; i++) {
				if (vowel.contains(Character.toLowerCase(lineToChar[i]))) {
					ans++;
				}
			}
			sb.append(ans).append("\n");
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}
