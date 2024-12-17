import java.io.*;
import java.util.StringTokenizer;

public class BOJ_11365 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String line = null;
        while(!"END".equals((line = br.readLine()))) {
            sb.append(new StringBuilder(line).reverse().toString()).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
