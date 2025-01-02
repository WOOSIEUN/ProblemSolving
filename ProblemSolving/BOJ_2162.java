import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_2162 {
    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Point[][] lines = new Point[N][2];
        parents = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            lines[i][0] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            lines[i][1] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            parents[i] = i;
        }

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (isIntersect(lines[i], lines[j])) {
                    union(i, j);
                }
            }
        }

        HashMap<Integer, Integer> groupMap = new HashMap<>();
        int max = -1;
        for (int i = 0; i < N; i++) {
            int parent = find(i);
            groupMap.put(parent, groupMap.getOrDefault(parent, 0) + 1);
            max = Math.max(max, groupMap.get(parent));
        }

        StringBuilder sb = new StringBuilder();
        sb.append(groupMap.size()).append("\n").append(max);

        bw.write(sb.toString());
        br.close();
        bw.close();
    }

    private static void union(int a, int b) {
        int aParent = find(a);
        int bParent = find(b);

        if (aParent != bParent) {
            parents[aParent] = bParent;
        }
    }

    private static int find(int a) {
        if (parents[a] == a) {
            return a;
        }
        return parents[a] = find(parents[a]);
    }

    static boolean isIntersect(Point[] line1, Point[] line2) {
        int ccw1 = ccw(line1[0], line1[1], line2[0]) * ccw(line1[0], line1[1], line2[1]);
        int ccw2 = ccw(line2[0], line2[1], line1[0]) * ccw(line2[0], line2[1], line1[1]);

        if (ccw1 == 0 && ccw2 == 0) {
            return Math.min(line1[0].x, line1[1].x) <= Math.max(line2[0].x, line2[1].x) && Math.min(line2[0].x, line2[1].x) <= Math.max(line1[0].x, line1[1].x) && Math.min(line1[0].y, line1[1].y) <= Math.max(line2[0].y, line2[1].y) && Math.min(line2[0].y, line2[1].y) <= Math.max(line1[0].y, line1[1].y);
        } else if (ccw1 <= 0 && ccw2 <= 0) {
            return true;
        } else {
            return false;
        }
    }

    private static int ccw(Point p1, Point p2, Point p3) {
        long res = (long) (p2.x - p1.x) * (p3.y - p1.y) - (long) (p3.x - p1.x) * (p2.y - p1.y);
        if (res < 0) {
            return -1;
        } else if (res > 0) {
            return 1;
        } else {
            return 0;
        }
    }
}
