import java.io.*;
import java.util.Arrays;

public class BOJ_2309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] dwarfs = new int[9];
        int sum = 0;
        for (int i = 0; i < dwarfs.length; i++) {
            dwarfs[i] = Integer.parseInt(br.readLine());
            sum += dwarfs[i];
        }

        StringBuilder sb = new StringBuilder();
        outer: for (int cur = 0; cur < dwarfs.length - 1; cur++) {
            for (int next = cur + 1; next < dwarfs.length; next++) {
                if (sum - dwarfs[cur] - dwarfs[next] != 100) {
                    continue;
                }

                dwarfs[cur] = 0;
                dwarfs[next] = 0;
                Arrays.sort(dwarfs);

                for (int k = 2; k < dwarfs.length; k++) {
                    sb.append(dwarfs[k]).append("\n");
                }
                break outer;
            }
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
