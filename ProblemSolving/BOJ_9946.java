import java.io.*;
import java.util.StringTokenizer;

public class BOJ_9946 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();
        for (int t = 1; ; t++) {
            String originalWord = br.readLine();
            String returnedWord = br.readLine();

            if (originalWord.equals("END") && returnedWord.equals("END")) {
                break;
            }

            int[] originalAlpabet = new int[26];
            for (int i = 0; i < originalWord.length(); i++) {
                originalAlpabet[originalWord.charAt(i) - 'a']++;
            }

            int[] returnedAlpabet = new int[26];
            for (int i = 0; i < returnedWord.length(); i++) {
                returnedAlpabet[returnedWord.charAt(i) - 'a']++;
            }

            boolean isSame = true;
            for (int i = 0; i < originalAlpabet.length; i++) {
                if (originalAlpabet[i] != returnedAlpabet[i]) {
                    isSame = false;
                    break;
                }
            }
            sb.append("Case ").append(t).append(": ").append(isSame ? "same\n" : "different\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
