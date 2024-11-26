import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2480 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int dice1 = Integer.parseInt(st.nextToken());
        int dice2 = Integer.parseInt(st.nextToken());
        int dice3 = Integer.parseInt(st.nextToken());

        int prize = 0;
        if (dice1 == dice2 && dice2 == dice3) {
            prize = 10000 + 1000 * dice1;
        } else if (dice1 == dice2) {
            prize = 1000 + 100 * dice1;
        } else if (dice1 == dice3) {
            prize = 1000 + 100 * dice1;
        } else if (dice2 == dice3) {
            prize = 1000 + 100 * dice2;
        } else {
            int max = Math.max(dice1, Math.max(dice2, dice3));
            prize = 100 * max;
        }

        bw.write(String.valueOf(prize));
        br.close();
        bw.close();
    }
}
