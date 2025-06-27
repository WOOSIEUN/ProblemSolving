import java.io.*;

public class BOJ_4779 {

    static boolean[] cantor;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input;
        StringBuilder sb = new StringBuilder();
        while ((input = br.readLine()) != null) {
            int N = (int) Math.pow(3, Integer.parseInt(input));
            cantor = new boolean[N];

            divideAndConquer(0, N);

            for (int i = 0; i < N; i++) {
                sb.append(cantor[i] ? " " : "-");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }

    private static void divideAndConquer(int start, int length) {
        if (length < 2) {
            return;
        }

        int trisection = length / 3;
        for (int i = start + trisection; i < start + trisection * 2; i++) {
            cantor[i] = true;
        }

        divideAndConquer(start, trisection);
        divideAndConquer(start + trisection * 2, trisection);
    }
}
