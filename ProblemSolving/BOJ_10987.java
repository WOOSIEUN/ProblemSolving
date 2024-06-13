import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		
		final HashSet<Character> vowel = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
		
        int ans = 0;
		char[] line = br.readLine().toCharArray();
        for (int i = 0; i < line.length; i++) {
            if (vowel.contains(line[i])) {
			    ans++;
            }
        }
		
		bw.write(String.valueOf(ans));
		br.close();
		bw.close();
	}
}