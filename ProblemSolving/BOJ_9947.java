import java.io.*;
import java.util.StringTokenizer;

public class BOJ_9947 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();
        while (true) {
            st = new StringTokenizer(br.readLine());
            String firstPerson = st.nextToken();
            String secondPerson = st.nextToken();

            if (firstPerson.equals("#") && secondPerson.equals("#")) {
                break;
            }

            int n = Integer.parseInt(br.readLine());
            int correct = 0, wrong = 0;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                if (st.nextToken().equals(st.nextToken())) {
                    correct++;
                } else {
                    wrong++;
                }
            }

            sb.append(firstPerson).append(" ").append(correct).append(" ").append(secondPerson).append(" ").append(wrong).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
