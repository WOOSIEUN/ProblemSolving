import java.io.*;
import java.util.StringTokenizer;

public class BOJ_24098 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(Integer.parseInt(br.readLine()) % 21));
        br.close();
        bw.close();
    }
}