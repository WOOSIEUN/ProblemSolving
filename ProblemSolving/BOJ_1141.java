import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_1141 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		String[] words = new String [N];
		for (int i = 0; i < N; i++) {
			words[i] = br.readLine();
		}
		
		Arrays.sort(words, (a, b) -> (b.length() - a.length()));
		
		HashSet<String> set = new HashSet<>();		
		for (String word: words) {
			if (hasSubstring(word, set)) {
				set.add(word);
			}
		}
		
		bw.write(String.valueOf(set.size()));
		br.close();
		bw.close();
	}

	private static boolean hasSubstring(String word, HashSet<String> set) {
		boolean available= true;
		for (String el : set) {
			if (el.indexOf(word) == 0) {
				available = false;
				break;
			}
		}
		return available;
	}
}
