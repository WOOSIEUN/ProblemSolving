import java.io.*;
import java.util.StringTokenizer;

public class BOJ_17610 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int k = Integer.parseInt(br.readLine());

        int sum = 0;
        int[] weights = new int[k];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            weights[i] = Integer.parseInt(st.nextToken());
            sum+= weights[i];
        }

        bw.write(String.valueOf(getUnmeasurableCount(weights, sum)));
        br.close();
        bw.close();
    }

    private static int getUnmeasurableCount(int[] weights, int sum) {
        boolean[] possible = new boolean[sum + 1];
        measureWeight(0, 0, weights, possible);

        int count = 0;
        for (int i = 1; i < possible.length; i++) {
            count += (possible[i] ? 0 : 1);
        }
        return count;
    }

    private static void measureWeight(int curWeight, int idx, int[] weights, boolean[] possible) {
        if (idx == weights.length) {
            if (curWeight > 0) {
                possible[curWeight] = true;
            }
            return;
        }

        measureWeight(curWeight, idx + 1, weights, possible);
        measureWeight(curWeight - weights[idx], idx + 1, weights, possible);
        measureWeight(curWeight + weights[idx], idx + 1, weights, possible);
    }
}
