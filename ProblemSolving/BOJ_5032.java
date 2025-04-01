import java.io.*;
import java.util.StringTokenizer;

public class BOJ_5032 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int e = Integer.parseInt(st.nextToken());
        int f = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int leftEmptyBottles = e + f;
        int drinks = 0;
        while (leftEmptyBottles >= c) {
            int newDrinks = leftEmptyBottles / c;
            drinks += newDrinks;
            leftEmptyBottles = newDrinks + (leftEmptyBottles % c);
        }

        bw.write(String.valueOf(drinks));
        br.close();
        bw.close();
    }
}
