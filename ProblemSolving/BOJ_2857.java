import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2857 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < 6; i++) {
            if (br.readLine().contains("FBI")) {
                sb.append(i).append(" ");
            }
        }

        bw.write(sb.length() == 0 ? "HE GOT AWAY!" : sb.toString().trim());
        br.close();
        bw.close();
    }
}
