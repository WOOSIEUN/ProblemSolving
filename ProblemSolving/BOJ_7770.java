import java.io.*;

public class BOJ_7770 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int height = 0, blocks = 0;
        while (blocks <= N) {
            blocks += height * height + (height + 1) * (height + 1);
            height++;
        }

        bw.write(String.valueOf(height - 1));
        br.close();
        bw.close();
    }
}
