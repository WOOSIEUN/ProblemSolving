import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;

public class BOJ_11319 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		final HashSet<Character> vowel = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
		
		int N = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			int vowels = 0, consonants = 0;
			char[] line = br.readLine().toCharArray();
			
			for (int j = 0; j < line.length; j++) {
				if (line[j] == ' ') {
					continue;
				} else if (vowel.contains(Character.toLowerCase(line[j]))) {
					vowels++;
				} else {
					consonants++;
				}
			}
			sb.append(consonants).append(" ").append(vowels).append("\n");
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}
