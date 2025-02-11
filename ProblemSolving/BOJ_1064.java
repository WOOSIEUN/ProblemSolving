import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1064 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] points = new int[6];

        for (int i = 0; i < points.length; i++) {
            points[i] = Integer.parseInt(st.nextToken());
        }

        double ans = 0;
        if (isParallel(points)) {
            ans = -1;
        } else {
            double lengthOfAB = getLength(points[0],points[1],points[2],points[3]);
            double lengthOfBC = getLength(points[2],points[3],points[4],points[5]);
            double lengthOfCA = getLength(points[4],points[5],points[0],points[1]);

            double max = Math.max(lengthOfAB, Math.max(lengthOfBC, lengthOfCA));
            double min = Math.min(lengthOfAB, Math.min(lengthOfBC, lengthOfCA));

            ans = 2 * (max - min);
        }

        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }

    private static boolean isParallel(int[] points) {
        return (points[2] - points[0]) * (points[5] - points[1]) == (points[4] - points[0]) * (points[3] - points[1]);
    }

    private static double getLength(int fromX, int fromY, int toX, int toY) {
        return Math.sqrt(Math.pow(toX - fromX, 2) + Math.pow(toY - fromY, 2));
    }
}
