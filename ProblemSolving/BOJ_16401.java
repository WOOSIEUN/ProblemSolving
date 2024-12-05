import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_16401 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] snacks = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            snacks[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(String.valueOf(findMaxLengthOfSnack(snacks, M)));
        br.close();
        bw.close();
    }

    private static int findMaxLengthOfSnack(int[] snacks, int m) {
        Arrays.sort(snacks);

        int maxLen = 0, left = 1, right = snacks[snacks.length - 1];
        while (left <= right) {
            int mid = (left + right) / 2;

            int numOfSnacks = getNumOfSnack(mid, snacks);
            if (numOfSnacks < m) {
                right = mid - 1;
            } else {
                maxLen = mid;
                left = mid + 1;
            }
        }
        return maxLen;
    }

    private static int getNumOfSnack(int len, int[] snacks) {
        int numOfSnacks = 0;
        for(int i = 0; i < snacks.length; i++){
            numOfSnacks += (snacks[i] / len);
        }
        return numOfSnacks;
    }
}
