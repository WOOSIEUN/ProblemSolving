import java.io.*;
import java.util.StringTokenizer;

public class BOJ_10813 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] basket = new int[N];
        for (int i = 0; i < N; i++) {
            basket[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int targetA = Integer.parseInt(st.nextToken()) - 1;
            int targetB = Integer.parseInt(st.nextToken()) - 1;
            swap(basket, targetA, targetB);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append((basket[i] + 1) + " ");
        }
        bw.write(sb.toString());
        br.close();
        bw.close();
    }

    static private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
