import java.io.*;
import java.util.StringTokenizer;

public class BOJ_16316 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        boolean valid = true;
        for (int i = 1; i <= N; i++) {
            String word = st.nextToken();
            if (!word.equals("mumble") && Integer.parseInt(word) != i) {
                valid = false;
                break;
            }
        }

        bw.write(valid ? "makes sense" : "something is fishy");
        br.close();
        bw.close();
    }
}
