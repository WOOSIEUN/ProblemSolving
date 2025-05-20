import java.io.*;
import java.util.StringTokenizer;

public class BOJ_4740 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();
        String line = null;;
        while (true) {
            line = br.readLine();
            if (line.equals("***")) {
                break;
            }

            sb.append(new StringBuilder(line).reverse()).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
