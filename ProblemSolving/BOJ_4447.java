import java.io.*;
import java.util.StringTokenizer;

public class BOJ_4447 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            int numOfG = 0, numOfB = 0;
            for (char c : name.toCharArray()) {
                if (Character.toLowerCase(c) == 'g') {
                    numOfG++;
                } else if (Character.toLowerCase(c) == 'b') {
                    numOfB++;
                }
            }
            sb.append(name).append(" is ").append(numOfG > numOfB ? "GOOD\n" : (numOfG < numOfB ? "A BADDY\n" : "NEUTRAL\n"));
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
