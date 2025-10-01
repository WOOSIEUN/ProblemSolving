import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1041 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int min = Integer.MAX_VALUE;
        int[] dice = new int[6];
        for (int i = 0; i < 6; i++) {
            dice[i] = Integer.parseInt(st.nextToken());
            min = Math.min(min, dice[i]);
        }

        long ans = 0;
        if (N == 1) {
            Arrays.sort(dice);
            for (int i = 0; i < dice.length - 1; i++) {
                ans += dice[i];
            }
        } else {
            long visibleSide1 = 5L * (N - 2) * (N - 2) + 4L * (N - 2);
            long visibleSide2 = 8L * (N - 2) + 4;
            long visibleSide3 = 4;

            int minOfVisibleSide2 = Integer.MAX_VALUE;
            for (int i = 0; i < dice.length; i++) {
                for (int j = i + 1; j < dice.length; j++) {
                    if (i + j == 5) {
                        continue;
                    }

                    minOfVisibleSide2 = Math.min(minOfVisibleSide2, dice[i] + dice[j]);
                }
            }

            ans += visibleSide1 * min;
            ans += visibleSide2 * minOfVisibleSide2;
            ans += visibleSide3 * (Math.min(dice[0], dice[5]) + Math.min(dice[1], dice[4]) + Math.min(dice[2], dice[3]));
        }

        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }
}
