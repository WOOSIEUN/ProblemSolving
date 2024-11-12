import java.io.*;
import java.util.StringTokenizer;

public class BOJ_10255 {
    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int minX = Integer.parseInt(st.nextToken());
            int minY = Integer.parseInt(st.nextToken());
            int maxX = Integer.parseInt(st.nextToken());
            int maxY = Integer.parseInt(st.nextToken());
            Point[] rectangle = {new Point(minX, minY), new Point(minX, maxY), new Point(maxX, maxY), new Point(maxX, minY)};

            st = new StringTokenizer(br.readLine());
            Point[] line = {new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())), new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()))};

            int ans = -1;
            for (int i = 0; i < rectangle.length; i++) {
                if (!isCrossed(line[0], line[1], rectangle[i], rectangle[(i + 1) % rectangle.length])) {
                    ans = 0;
                    break;
                }
            }

            if (ans == 0) {
                sb.append(ans).append("\n");
                continue;
            }

            if (isCrossedOnInfinitePoints(line[0], line[1], rectangle[0], rectangle[2])) {
                ans = 4;
                sb.append(ans).append("\n");
                continue;
            }

                int cntOnVertex = 0, cntOnEdge = 0;
            for (int i = 0; i < rectangle.length; i++) {
                if (isCrossedOnVertex(line[0], line[1], rectangle[i], rectangle[(i + 1) % rectangle.length])) {
                    cntOnVertex++;
                } else if (isCrossedOnEdge(line[0], line[1], rectangle[i], rectangle[(i + 1) % rectangle.length])) {
                    cntOnEdge++;
                }
            }

            if (ans == -1) {
                ans = cntOnEdge + cntOnVertex / 2;
            }

            sb.append(ans).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }

    private static boolean isCrossed(Point p1, Point p2, Point p3, Point p4) {
        int ccw123 = ccw(p1, p2, p3), ccw124 = ccw(p1, p2, p4), ccw341 = ccw(p3, p4, p1), ccw342 = ccw(p3, p4, p2);
        if (ccw123 * ccw124 <= 0 && ccw341 * ccw342 <= 0) {
            if ((p1.x < p3.x && p2.x < p3.x && p1.x < p4.x && p2.x < p4.x) || (p3.x < p1.x && p3.x < p2.x && p4.x < p1.x && p4.x < p2.x)) {
                return false;
            }
            if ((p1.y < p3.y && p2.y < p3.y && p1.y < p4.y && p2.y < p4.y) || (p3.y < p1.y && p3.y < p2.y && p4.y < p1.y && p4.y < p2.y)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isCrossedOnVertex(Point p1, Point p2, Point p3, Point p4) {
        int ccw123 = ccw(p1, p2, p3), ccw124 = ccw(p1, p2, p4), ccw341 = ccw(p3, p4, p1), ccw342 = ccw(p3, p4, p2);
        return ccw123 * ccw124 == 0 && ccw341 * ccw342 <= 0;
    }

    private static boolean isCrossedOnEdge(Point p1, Point p2, Point p3, Point p4) {
        int ccw123 = ccw(p1, p2, p3), ccw124 = ccw(p1, p2, p4), ccw341 = ccw(p3, p4, p1), ccw342 = ccw(p3, p4, p2);
        return ccw123 * ccw124 < 0 && ccw341 * ccw342 <= 0;
    }

    private static boolean isCrossedOnInfinitePoints(Point p1, Point p2, Point min, Point max) {
       if ((p1.y < max.y) && (min.y < p2.y) || (p2.y < max.y) && (min.y < p1.y)) {
           if ((p1.x == p2.x && p1.x == min.x) || (p1.x == p2.x && p1.x == max.x)) {
                return true;
            }
        } else if ((p1.x < max.x) && (min.x < p2.x) || (p2.x < max.x) && (min.x < p1.x)) {
            if ((p1.y == p2.y && p1.y == min.y) || (p1.y == p2.y && p1.y == max.y)) {
                return true;
            }
        }
        return false;
    }

    public static int ccw(Point p1, Point p2, Point p3) {
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
