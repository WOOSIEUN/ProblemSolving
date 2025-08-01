import java.io.*;

public class BOJ_10886 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int cntCute = 0, cntNotCute = 0;

        for (int i = 0; i < N; i++) {
            if (br.readLine().equals("1")) {
                cntCute++;
            } else {
                cntNotCute++;
            }
        }

        bw.write(cntCute > cntNotCute ? "Junhee is cute!" : "Junhee is not cute!");
        br.close();
        bw.close();
    }
}
