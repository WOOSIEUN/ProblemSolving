import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_4225 {
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

        StringBuilder sb = new StringBuilder();
        for (int t = 1; ; t++) {
            int N = Integer.parseInt(br.readLine());

            if (N == 0) {
                break;
            }

            ArrayList<Point> points = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                points.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }

            ArrayList<Point> convexHull = new ArrayList<>(grahamScan(points));
            convexHull.add(getRoot(points));

            BigDecimal minWith = BigDecimal.valueOf(getMinWidth(convexHull));
            minWith = minWith.setScale(2, RoundingMode.CEILING);
            sb.append("Case ").append(t).append(": ").append(String.format("%.2f", minWith.doubleValue())).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }

    private static double getMinWidth(ArrayList<Point> convexHull) {
        double minHeight = Double.MAX_VALUE;

        for (int i = 0; i < convexHull.size() - 1; i++) {
            Point p1 = convexHull.get(i);
            Point p2 = convexHull.get(i + 1);
            double maxHeight = 0;
            for (Point point : convexHull) {
                maxHeight = Math.max(maxHeight, dist(p1, p2, point));
            }
            minHeight = Math.min(minHeight, maxHeight);
        }
        return minHeight;
    }

    private static Stack<Point> grahamScan(ArrayList<Point> points) {
        Point root = getRoot(points);

        points.sort(new Comparator<Point>() {
            @Override
            public int compare(Point p1, Point p2) {
                int result = ccwForCompare(root, p1, p2);

                if (result > 0) {
                    return -1;
                } else if (result < 0) {
                    return 1;
                } else {
                    long distanceP1 = dist(root, p1);
                    long distanceP2 = dist(root, p2);
                    return Long.compare(distanceP1, distanceP2);
                }
            }
        });

        Stack<Point> stack = new Stack<>();
        stack.add(root);

        for (int i = 1; i < points.size(); i++) {
            while (stack.size() > 1 && (ccwForCompare(stack.get(stack.size() - 2), stack.get(stack.size() - 1), points.get(i)) <= 0)) {
                stack.pop();
            }
            stack.add(points.get(i));
        }

        return stack;
    }

    private static Point getRoot(ArrayList<Point> points) {
        Point root = new Point(Integer.MAX_VALUE, Integer.MAX_VALUE);

        for (int i = 0; i < points.size(); i++) {
            if (points.get(i).y < root.y) {
                root = points.get(i);
            } else if (points.get(i).y == root.y) {
                if (points.get(i).x < root.x) {
                    root = points.get(i);
                }
            }
        }

        return root;
    }

    private static int ccwForCompare(Point p1, Point p2, Point p3) {
        long res = (long) (p2.x - p1.x) * (p3.y - p1.y) - (long) (p3.x - p1.x) * (p2.y - p1.y);
        if (res < 0) {
            return -1;
        } else if (res > 0) {
            return 1;
        } else {
            return 0;
        }
    }

    private static long ccw(Point p1, Point p2, Point p3) {
        return (long) (p2.x - p1.x) * (p3.y - p1.y) - (long) (p3.x - p1.x) * (p2.y - p1.y);
    }

    private static long dist(Point p1, Point p2) {
        return (long) (p2.x - p1.x) * (p2.x - p1.x) + (long) (p2.y - p1.y) * (p2.y - p1.y);
    }

    private static double dist(Point p1, Point p2, Point p3) {
        double outerProduct = Math.abs(ccw(p1, p2, p3));
        return outerProduct / Math.sqrt(dist(p1, p2));
    }
}
