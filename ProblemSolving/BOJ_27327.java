import java.io.*;

public class BOJ_27327 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(Integer.parseInt(br.readLine()) * 24));
        br.close();
        bw.close();
    }
}