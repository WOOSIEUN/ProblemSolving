import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_20920 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashMap<String, Integer> wordMap = new HashMap<>();
		for (int i = 0; i < N; i++) {
            String word = br.readLine();
            if (word.length() < M) {
            	continue;
            }
            
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }
		
		List<String> wordList = new ArrayList<>(wordMap.keySet());
        Collections.sort(wordList, new Comparator<String>() {
            @Override
            public int compare(String word1, String word2) {
                if (Integer.compare(wordMap.get(word1), wordMap.get(word2)) != 0) {
                    return wordMap.get(word2) - wordMap.get(word1);
                }

                if (word1.length() != word2.length()) {
                    return word2.length() - word1.length();
                }
                
                return word1.compareTo(word2);
            }
        });
		
        StringBuilder sb = new StringBuilder();
        for (String word : wordList) {
            sb.append(word).append("\n");
        }
        
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}
