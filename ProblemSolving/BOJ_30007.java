import java.io.*;
import java.util.StringTokenizer;

public class BOJ_30007 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            sb.append(getAmountOfWater(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()))).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }

    private static int getAmountOfWater(int A, int B, int X) {
        return A * (X - 1) + B;
    }
}
