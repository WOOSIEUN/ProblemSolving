import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_5176 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int K = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < K; t++) {
            st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            HashSet<Integer> set = new HashSet<>();
            for (int i = 0; i < P; i++) {
                set.add(Integer.parseInt(br.readLine()));
            }

            sb.append(P - set.size()).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
