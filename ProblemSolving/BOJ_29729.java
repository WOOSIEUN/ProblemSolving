import java.io.*;
import java.util.StringTokenizer;

public class BOJ_29729 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int numOfElements = 0;
        for (int i = 0; i < N + M; i++) {
            if (Integer.parseInt(br.readLine()) == 1) {
                numOfElements++;
            } else {
                numOfElements--;
            }

            if (numOfElements > S) {
                S *= 2;
            }
        }

        bw.write(String.valueOf(S));
        br.close();
        bw.close();
    }
}
