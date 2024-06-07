import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;

public class BOJ_11478 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String word = br.readLine();
		HashSet<String> subStr = new HashSet<>();

	    for (int i = 0; i < word.length(); i++) {
	    	for (int j = i + 1; j <= word.length(); j++) {
	    	   subStr.add(word.substring(i, j));
	    	}
	    }
		
		bw.write(String.valueOf(subStr.size()));
		br.close();
		bw.close();
	}
}
