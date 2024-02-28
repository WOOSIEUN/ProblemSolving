import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class BOJ_1181 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		HashSet<String> wordSet = new HashSet<>();
		for (int i = 0; i < N; i++) {
			wordSet.add(br.readLine());
		}
		
		ArrayList<String> wordList = new ArrayList<>(wordSet);
		
		Collections.sort(wordList, (a, b) -> (a.length() == b.length() ? a.compareTo(b): a.length() - b.length()));

		for (int i = 0; i < wordList.size(); i++) {
			sb.append(wordList.get(i)).append("\n");
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}
