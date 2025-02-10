import java.io.*;

public class BOJ_11654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf((int) br.readLine().charAt(0)));
        br.close();
        bw.close();
    }
}