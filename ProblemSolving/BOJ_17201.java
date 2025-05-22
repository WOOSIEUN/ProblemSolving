import java.io.*;

public class BOJ_17201 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        char[] magnets = br.readLine().toCharArray();

        boolean connected = true;
        for (int i = 1; i < magnets.length; i++) {
            if (magnets[i - 1] == magnets[i]) {
                connected = false;
                break;
            }
        }

        bw.write(connected ? "Yes" : "No");
        br.close();
        bw.close();
    }
}
