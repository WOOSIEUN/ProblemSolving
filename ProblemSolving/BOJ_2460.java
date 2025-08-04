import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2460 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int numOfPassengers = 0, max = 0;
        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            numOfPassengers -= Integer.parseInt(st.nextToken());
            numOfPassengers += Integer.parseInt(st.nextToken());
            if (numOfPassengers > 10000) {
                numOfPassengers = 10000;
            }
            max = Math.max(max, numOfPassengers);
        }

        bw.write(String.valueOf(max));
        br.close();
        bw.close();
    }
}
