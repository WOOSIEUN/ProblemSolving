import java.io.*;
import java.util.StringTokenizer;

public class BOJ_18185 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] ramenToBuy = new int[N + 2];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            ramenToBuy[i] = Integer.parseInt(st.nextToken());
        }

        int cost = 0;
        for (int i = 0; i < N; i++) {
            if (ramenToBuy[i] == 0) {
                continue;
            }

            int numOfRamen = ramenToBuy[i];
            ramenToBuy[i] -= numOfRamen;
            cost += numOfRamen * 3;

            numOfRamen = Math.min(numOfRamen, ramenToBuy[i + 1]);
            ramenToBuy[i + 1] -= numOfRamen;
            cost += numOfRamen * 2;

            numOfRamen = Math.min(numOfRamen, ramenToBuy[i + 2] - Math.min(ramenToBuy[i + 1], ramenToBuy[i + 2]));
            ramenToBuy[i + 2] -= numOfRamen;
            cost += numOfRamen * 2;
        }

        bw.write(String.valueOf(cost));
        br.close();
        bw.close();
    }
}
