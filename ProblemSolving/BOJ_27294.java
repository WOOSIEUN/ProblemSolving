import java.io.*;
import java.util.*;

public class BOJ_27294 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int time = Integer.parseInt(st.nextToken());
        boolean withDrink = Integer.parseInt(st.nextToken()) == 1;

        int ans = 320;
        if (withDrink || time < 12 || 16 < time) {
            ans = 280;
        }

        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }
}