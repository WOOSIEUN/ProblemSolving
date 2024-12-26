import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int numOfParticipants = Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 5; i++) {
            sb.append(Integer.parseInt(st.nextToken()) - numOfParticipants).append(" ");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
