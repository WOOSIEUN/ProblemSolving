import java.io.*;
import java.util.StringTokenizer;

public class BOJ_17252 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        bw.write(is33(N) ? "YES" : "NO");
        br.close();
        bw.close();
    }

    static boolean is33(int num) {
        if (num == 0) {
            return false;
        }

        while (num != 0) {
            if (num % 3 > 1) {
                return false;
            }
            num /= 3;
        }
        return true;
    }

}
