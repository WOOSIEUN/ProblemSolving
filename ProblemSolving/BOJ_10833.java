import java.io.*;
import java.util.StringTokenizer;

public class BOJ_10833 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int numOfLeftApples = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int student = Integer.parseInt(st.nextToken());
            int numOfApples = Integer.parseInt(st.nextToken());
            numOfLeftApples += (numOfApples % student);
        }

        bw.write(String.valueOf(numOfLeftApples));
        br.close();
        bw.close();
    }
}
