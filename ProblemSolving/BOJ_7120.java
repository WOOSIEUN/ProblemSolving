import java.io.*;

public class BOJ_7120 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] word = br.readLine().toCharArray();

        StringBuilder sb = new StringBuilder();
        sb.append(word.length == 0 ? "" : word[0]);

        for (int i = 1; i < word.length; i++) {
            if (word[i - 1] != word[i]) {
                sb.append(word[i]);
            }
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
