import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;

public class BOJ_18409 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		HashSet<Character> vowels = new HashSet<>(Arrays.asList('a', 'i', 'u', 'e', 'o'));
		int N = Integer.parseInt(br.readLine());
		char[] str = br.readLine().toCharArray();
		
		int ans = 0;
		for (char ch : str) {
			ans += (vowels.contains(ch) ? 1 : 0);
		}
		
		bw.write(String.valueOf(ans));
		br.close();
		bw.close();
	}
}
