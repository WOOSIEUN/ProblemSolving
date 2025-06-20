import java.io.*;

public class BOJ_10707 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());
        int D = Integer.parseInt(br.readLine());
        int P = Integer.parseInt(br.readLine());

        int chargeOfX = A * P;
        int chargeOfY = B;
        if (P > C) {
            chargeOfY += (P - C) * D;
        }

        bw.write(String.valueOf(Math.min(chargeOfX, chargeOfY)));
        br.close();
        bw.close();
    }
}
