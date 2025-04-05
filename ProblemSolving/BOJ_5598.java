import java.io.*;

public class BOJ_5598 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] targetStr = br.readLine().toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : targetStr) {
            sb.append((char) (c - 3 < 'A' ? c + 23 : c - 3));
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
