import java.io.*;
import java.util.StringTokenizer;

public class BOJ_3512 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        double reducedArea = 0;
        int bedroomArea = 0, flatArea = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            String t = st.nextToken();

            reducedArea += (t.equals("balcony") ? (double) a / 2 : a);
            bedroomArea += (t.equals("bedroom") ? a : 0);
            flatArea += a;
        }

        bw.write(String.format("%d\n%d\n%f", flatArea, bedroomArea, reducedArea * C));
        br.close();
        bw.close();
    }
}
