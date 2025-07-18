import java.io.*;
import java.util.StringTokenizer;

public class BOJ_27329 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        char[] word = br.readLine().toCharArray();
        boolean isRepeatingString = true;
        for (int left = 0, right = N / 2; left < N / 2 && right < N; left++, right++) {
            if (word[left] != word[right]) {
                isRepeatingString = false;
                break;
            }
        }

        bw.write(isRepeatingString ? "Yes" : "No");
        br.close();
        bw.close();
    }
}
