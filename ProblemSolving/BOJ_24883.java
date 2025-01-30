import java.io.*;

public class BOJ_24883 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        char N = br.readLine().charAt(0);
        String ans = "Naver Whale";
        if (N == 'N' || N == 'n') {
            ans = "Naver D2";
        }

        bw.write(ans);
        br.close();
        bw.close();
    }
}