import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2457 {
    static class Flower implements Comparable<Flower> {
        int start, end;

        public Flower(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Flower flower) {
            if (this.start == flower.start) {
                return flower.end - this.end;
            }
            return this.start - flower.start;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Flower[] flowers = new Flower[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            flowers[i] = new Flower(makeDate(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())), makeDate(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Arrays.sort(flowers);

        int numOfFlowers = 0, cur = 0, startDay = 301, maxEndDay = 0;
        final int endDay = 1130;
        while (startDay <= endDay) {
            boolean find = false;

            for (;cur < flowers.length; cur++) {
                if (flowers[cur].start > startDay) {
                    break;
                } else if (flowers[cur].end > maxEndDay) {
                    maxEndDay = flowers[cur].end;
                    find = true;
                }
            }

            if (find) {
                numOfFlowers++;
                startDay = maxEndDay;
            } else {
                break;
            }
        }

        bw.write(startDay <= endDay ? "0" : String.valueOf(numOfFlowers));
        br.close();
        bw.close();
    }

    private static int makeDate(int month, int day) {
        return month * 100 + day;
    }
}
