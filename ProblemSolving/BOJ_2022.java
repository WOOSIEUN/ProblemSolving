import java.io.*;
import java.util.StringTokenizer;

import static javax.swing.text.html.HTML.Attribute.N;

public class BOJ_2022 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        double x = Double.parseDouble(st.nextToken());
        double y = Double.parseDouble(st.nextToken());
        double c = Double.parseDouble(st.nextToken());

        double left = 0, right = Math.min(x, y);

        while (right - left >= 0.001) {
            double mid = (left + right) / 2;
            double h1 = Math.sqrt(Math.pow(x, 2) - Math.pow(mid, 2));
            double h2 = Math.sqrt(Math.pow(y, 2) - Math.pow(mid, 2));
            double res = (h1 * h2) / (h1 + h2);

            if (res >= c) {
                left = mid;
            } else {
                right = mid;
            }
        }

        bw.write(String.format("%.3f", left));
        br.close();
        bw.close();
    }
}
