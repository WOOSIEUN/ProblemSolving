import java.io.*;
import java.util.StringTokenizer;

public class BOJ_17266 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] streetLamp = new int [M];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            streetLamp[i] = Integer.parseInt(st.nextToken());
        }

        int left = 1, right = N, ans = 0;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (isLightable(mid, streetLamp, N)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }

    static boolean isLightable(int target, int[] streetLamp, int N) {
        int prev = 0;

        for (int i = 0; i < streetLamp.length; i++) {
            if (streetLamp[i] - target <= prev) {
                prev = streetLamp[i] + target;
            } else {
                return false;
            }
        }

        return (N - prev) <= 0;
    }
}
