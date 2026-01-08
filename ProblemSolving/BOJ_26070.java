import java.io.*;
import java.util.StringTokenizer;

public class BOJ_26070 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        int Z = Integer.parseInt(st.nextToken());

        long ans = 0;
        for (int i = 0; i < 3; i++) {
            int chicken = (Math.min(A, X));
            ans += chicken;
            A -= chicken;
            X -= chicken;

            int pizza = (Math.min(B, Y));
            ans += pizza;
            B -= pizza;
            Y -= pizza;

            int burger = (Math.min(C, Z));
            ans += burger;
            C -= burger;
            Z -= burger;

            int newY = X / 3;
            int newZ = Y / 3;
            int newX = Z / 3;

            Y = newY;
            Z = newZ;
            X = newX;
        }

        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }
}
