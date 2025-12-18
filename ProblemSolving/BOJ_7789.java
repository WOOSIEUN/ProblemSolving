import java.io.*;
import java.util.StringTokenizer;

public class BOJ_7789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int prevTel = Integer.parseInt(st.nextToken());
        int newTel = Integer.parseInt(st.nextToken() + prevTel);

        String ans = "Yes";
        for (int i = 2; i < Math.sqrt(prevTel); i++) {
            if (prevTel % i == 0) {
                ans = "No";
                break;
            }
        }

        for (int i = 2; i < Math.sqrt(newTel); i++) {
            if (newTel % i == 0) {
                ans = "No";
                break;
            }
        }

        bw.write(ans);
        br.close();
        bw.close();
    }
}
