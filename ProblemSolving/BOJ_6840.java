import java.io.*;
import java.util.Arrays;

public class BOJ_6840 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] bowls = new int[3];
        for (int i = 0; i < bowls.length; i++) {
            bowls[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(bowls);

        bw.write(String.valueOf(bowls[1]));
        br.close();
        bw.close();
    }
}
