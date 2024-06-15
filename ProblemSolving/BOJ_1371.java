import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		
        int[] alpabet = new int [26];
        String line;
        while ((line = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(line);
            while (st.hasMoreTokens()) {
                char[] lineToChar = st.nextToken().toCharArray();
                for (char ch : lineToChar) {
                    alpabet[Character.toLowerCase(ch) - 'a']++;
                }
            }
        }
        
        int maxValue = alpabet[0];
        for (int i = 0; i < alpabet.length; i++) {
            maxValue = Math.max(maxValue, alpabet[i]);
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < alpabet.length; i++) {
            if (maxValue == alpabet[i]) {
                sb.append((char) (i + 'a'));
            }
        }
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}