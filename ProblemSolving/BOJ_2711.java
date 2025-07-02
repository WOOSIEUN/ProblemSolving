import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2711 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            String word = st.nextToken();
            sb.append(word.substring(0, idx - 1) + word.substring(idx)).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
