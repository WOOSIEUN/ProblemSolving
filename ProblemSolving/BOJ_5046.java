import java.io.*;
import java.util.StringTokenizer;

public class BOJ_5046 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[] hotelCost = new int[H], minCost = new int[H];
        for (int hotel = 0; hotel < H; hotel++) {
            hotelCost[hotel] = Integer.parseInt(br.readLine());

            int min = Integer.MAX_VALUE;
            st = new StringTokenizer(br.readLine());
            for (int week = 0; week < W; week++) {
                int room = Integer.parseInt(st.nextToken());
                if (room >= N && min > hotelCost[hotel] * N) {
                    min = hotelCost[hotel] * N;
                }
            }
            minCost[hotel] = min;
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < minCost.length; i++) {
            if (minCost[i] < min) {
                min = minCost[i];
            }
        }

        bw.write(min > B ? "stay home" : String.valueOf(min));
        br.close();
        bw.close();
    }
}
