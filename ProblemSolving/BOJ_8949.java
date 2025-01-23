import java.io.*;
import java.util.StringTokenizer;

public class BOJ_8949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String A = st.nextToken();
        String B = st.nextToken();

        int diff = Math.abs(A.length() - B.length());
        if (A.length() < B.length()) {
            A = getConvertedString(A, diff);
        } else {
            B = getConvertedString(B, diff);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < A.length(); i++) {
            sb.append((A.charAt(i) - '0') + (B.charAt(i) - '0'));
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }

    private static String getConvertedString(String target, int diff) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < diff; i++) {
            sb.append("0");
        }
        sb.append(target);
        return sb.toString();
    }
}
