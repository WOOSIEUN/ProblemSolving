import java.io.*;
import java.util.StringTokenizer;

public class BOJ_8370 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        bw.write(String.valueOf(Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken())));
        br.close();
        bw.close();
    }
}