import java.io.*;

public class BOJ_5554 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int time = 0;
        for (int i = 0; i < 4; i++) {
            time += Integer.parseInt(br.readLine());
        }

        bw.write(String.format("%d\n%d", time / 60, time % 60));
        br.close();
        bw.close();
    }
}
