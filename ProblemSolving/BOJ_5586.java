import java.io.*;
import java.util.StringTokenizer;

public class BOJ_5586 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] string = br.readLine().toCharArray();

        int numOfJOIs = 0, numOfIOIs = 0;
        for (int i = 0; i < string.length - 2; i++) {
            if (string[i] == 'J' && string[i + 1] == 'O' && string[i + 2] == 'I') {
                numOfJOIs++;
            } else if (string[i] == 'I' && string[i + 1] == 'O' && string[i + 2] == 'I') {
                numOfIOIs++;
            }
        }

        bw.write(String.format("%d\n%d", numOfJOIs, numOfIOIs));
        br.close();
        bw.close();
    }
}
