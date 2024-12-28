import java.io.*;
import java.util.*;

public class BOJ_32969 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<String> digitalHumanities = new ArrayList<>(Arrays.asList("social", "history", "language", "literacy"));
        List<String> publicBigdata = new ArrayList<>(Arrays.asList("bigdata", "public", "society"));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String ans = "";
        while (st.hasMoreTokens()) {
            String theme = st.nextToken().toLowerCase();

            for (String word : digitalHumanities) {
                if (theme.contains(word)) {
                    ans = "digital humanities";
                    break;
                }
            }

            for (String word : publicBigdata) {
                if (theme.contains(word)) {
                    ans = "public bigdata";
                    break;
                }
            }
        }

        bw.write(ans);
        br.close();
        bw.close();
    }
}
