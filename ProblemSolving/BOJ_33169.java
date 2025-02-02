import java.io.*;

public class BOJ_33169 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(Integer.parseInt(br.readLine()) * 1000 + Integer.parseInt(br.readLine()) * 10000));
        br.close();
        bw.close();
    }
}