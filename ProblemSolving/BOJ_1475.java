import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] roomNumber = br.readLine().toCharArray();
        int[] plasticNumber = new int[10];

        for (char num : roomNumber) {
            plasticNumber[num - '0']++;
        }

        int sixAndNine = plasticNumber[6] + plasticNumber[9];
        sixAndNine = (sixAndNine % 2 == 1 ? sixAndNine / 2 + 1 : sixAndNine / 2);
        plasticNumber[6] = sixAndNine;
        plasticNumber[9] = sixAndNine;

        bw.write(String.valueOf(Arrays.stream(plasticNumber).max().getAsInt()));
        br.close();
        bw.close();
    }
}
