import java.io.*;
import java.util.*;

public class BOJ_29731 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Set<String> promiseSet = new HashSet<String>() {
            {
                add("Never gonna give you up");
                add("Never gonna let you down");
                add("Never gonna run around and desert you");
                add("Never gonna make you cry");
                add("Never gonna say goodbye");
                add("Never gonna tell a lie and hurt you");
                add("Never gonna stop");
            }
        };

        int N = Integer.parseInt(br.readLine());
        boolean hacked = false;
        for (int i = 0; i < N; i++) {
            if (!promiseSet.contains(br.readLine())) {
                hacked = true;
            }
        }

        bw.write(hacked ? "Yes" : "No");
        br.close();
        bw.close();
    }
}
