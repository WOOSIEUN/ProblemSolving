import java.io.*;
import java.util.StringTokenizer;

public class BOJ_5596 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWrited(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int minguk = 0, manse = 0;
        while (st.hasMoreTokens()) {
            minguk += Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            manse += Integer.parseInt(st.nextToken());
        }

        bw.write(String.valueOf(Math.max(minguk, manse)));
        br.close();
        bw.close();
    }
}