import java.io.*;
import java.util.StringTokenizer;

public class BOJ_20205 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] upSampledImage = new int[N * K][N * K];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                if (Integer.parseInt(st.nextToken()) == 1) {
                    fillImage(upSampledImage, 1, i, j, K);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int[] line : upSampledImage) {
            for (int pixel : line) {
                sb.append(pixel).append(' ');
            }
            sb.append('\n');
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }

    private static void fillImage(int[][] upSampledImage, int num, int x, int y, int K) {
        for (int i = x * K; i < x * K + K; i++) {
            for (int j = y * K; j < y * K + K; j++) {
                upSampledImage[i][j] = num;
            }
        }
    }
}
