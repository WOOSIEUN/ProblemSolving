import java.io.*;
import java.util.StringTokenizer;

public class BOJ_16693 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        double a = Double.parseDouble(st.nextToken());
        double p1 = Double.parseDouble(st.nextToken());

        st = new StringTokenizer(br.readLine());
        double r = Double.parseDouble(st.nextToken());
        double p2 = Double.parseDouble(st.nextToken());

        bw.write(a / p1 < Math.PI * r * r / p2 ? "Whole pizza" : "Slice of pizza");
        br.close();
        bw.close();
    }
}
