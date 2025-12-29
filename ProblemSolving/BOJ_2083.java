import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2083 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();
        while (true) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int age = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            if (name.equals("#") && age == 0 && weight == 0) {
                break;
            }

            String type = "Junior";
            if (age > 17 || weight >= 80) {
                type = "Senior";
            }
            sb.append(name).append(" ").append(type).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
