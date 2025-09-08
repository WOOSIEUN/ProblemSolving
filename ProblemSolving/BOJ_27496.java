import java.io.*;
import java.util.StringTokenizer;

public class BOJ_27496 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int hour = 0;
        int[] alcohol = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int left = -L, right = 0, bloodAlcoholContent = 0; right < N; left++, right++) {
            alcohol[right] = Integer.parseInt(st.nextToken());
            bloodAlcoholContent += alcohol[right];
            if (left >= 0) {
                bloodAlcoholContent -= alcohol[left];
            }

            if (isPeekTime(bloodAlcoholContent)) {
                hour++;
            }
        }

        bw.write(String.valueOf(hour));
        br.close();
        bw.close();
    }

    private static boolean isPeekTime(int bloodAlcoholContent) {
        return 129 <= bloodAlcoholContent && bloodAlcoholContent <= 138;
    }
}
