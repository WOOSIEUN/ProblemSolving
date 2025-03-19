import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_1461 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Integer> positiveBooks = new ArrayList<>();
        ArrayList<Integer> negativeBooks = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num < 0) {
                negativeBooks.add(Math.abs(num));
            } else {
                positiveBooks.add(num);
            }
        }

        Collections.sort(positiveBooks, Collections.reverseOrder());
        Collections.sort(negativeBooks, Collections.reverseOrder());

        int ans = 0;
        for (int i = 0; i < positiveBooks.size(); i += M) {
            ans += positiveBooks.get(i) * 2;
        }

        for (int i = 0; i < negativeBooks.size(); i += M) {
            ans += negativeBooks.get(i) * 2;
        }

        ans -= Math.max(positiveBooks.isEmpty() ? 0 : positiveBooks.get(0), negativeBooks.isEmpty() ? 0 : negativeBooks.get(0));

        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }
}
