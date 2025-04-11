import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_5567 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] universityW = new int[10];
        int[] universityK = new int[10];

        for (int i = 0; i < universityW.length; i++) {
            universityW[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < universityK.length; i++) {
            universityK[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(universityW);
        Arrays.sort(universityK);

        StringBuilder sb = new StringBuilder();
        sb.append(universityW[9] + universityW[8] + universityW[7]).append(" ");
        sb.append(universityK[9] + universityK[8] + universityK[7]);

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
