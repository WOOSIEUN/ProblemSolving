import java.io.*;

public class BOJ_15829 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int L = Integer.parseInt(br.readLine());
        char[] str = br.readLine().toCharArray();

        long hash = 0, pow = 1, r = 31, M = 1234567891;
        for (char c : str) {
            hash = (hash + (c - 'a' + 1) * pow) % M;
            pow = (pow * r) % M;
        }

        bw.write(String.valueOf(hash % M));
        br.close();
        bw.close();
    }
}
