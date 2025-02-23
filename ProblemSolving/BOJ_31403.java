import java.io.*;

public class BOJ_31403 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        sb.append(A + B - C).append("\n");

        String string = "";
        string += A;
        string += B;

        sb.append(Integer.parseInt(string) - C).append("\n");

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
