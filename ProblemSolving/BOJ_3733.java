import java.io.*;
import java.util.StringTokenizer;

public class BOJ_3733 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String line;
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while ((line = br.readLine()) != null) {
            st = new StringTokenizer(line);
            int people = Integer.parseInt(st.nextToken()) + 1;
            int stocks = Integer.parseInt(st.nextToken());
            sb.append(stocks / people).append("\n");
        }
        
        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}