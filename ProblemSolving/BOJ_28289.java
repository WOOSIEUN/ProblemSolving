import java.io.*;
import java.util.StringTokenizer;

public class BOJ_28289 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int sw = 0, embedded = 0, ai = 0, none = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int grade = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            if (grade == 1) {
                none++;
            } else {
                if (c == 1 || c == 2) {
                    sw++;
                } else if (c == 3) {
                    embedded++;
                } else if (c == 4) {
                    ai++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(sw).append("\n");
        sb.append(embedded).append("\n");
        sb.append(ai).append("\n");
        sb.append(none).append("\n");
        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
