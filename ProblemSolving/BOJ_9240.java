import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_9240 {
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

        int N = Integer.parseInt(br.readLine());
        ArrayList<Point> points = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            points.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        ArrayList<Point> convexHull = new ArrayList<>(grahamScan(points));
        bw.write(String.valueOf(rotatingCalipers(convexHull)));
        br.close();
        bw.close();
    }

    static double rotatingCalipers(ArrayList<Point> convexHull) {
        double max_dist = 0;
        for (int firstCur = 0, secondCur = 1; firstCur < convexHull.size(); firstCur++) {
            int firstnext = (firstCur + 1) % convexHull.size();

            while (true) {
                int secondNext = (secondCur + 1) % convexHull.size();

                int bx = convexHull.get(firstnext).x - convexHull.get(firstCur).x; // 왼쪽 벡터
                int by = convexHull.get(firstnext).y - convexHull.get(firstCur).y;
                int cx = convexHull.get(secondNext).x - convexHull.get(secondCur).x;   // 오른쪽 벡터
                int cy = convexHull.get(secondNext).y - convexHull.get(secondCur).y;

                int ccw = ccw(new Point(0, 0), new Point(bx, by), new Point(cx, cy));
                if (ccw > 0) {
                    secondCur = secondNext;
                } else {
                    break;
                }
            }

            if (dist(convexHull.get(firstCur), convexHull.get(secondCur)) > max_dist) {
                max_dist = dist(convexHull.get(firstCur), convexHull.get(secondCur));
            }
        }
        return max_dist;
    }

    private static Stack<Point> grahamScan(ArrayList<Point> points) {
        Point root = getRoot(points);

        points.sort(new Comparator<Point>() {
            @Override
            public int compare(Point p1, Point p2) {
                int result = ccw(root, p1, p2);

                if (result > 0) {
                    return -1;
                } else if (result < 0) {
                    return 1;
                } else {
                    double distanceP1 = dist(root, p1);
                    double distanceP2 = dist(root, p2);
                    return Double.compare(distanceP1, distanceP2);
                }
            }
        });

        Stack<Point> stack = new Stack<>();
        stack.add(root);

        for (int i = 1; i < points.size(); i++) {
            while (stack.size() > 1 && (ccw(stack.get(stack.size() - 2), stack.get(stack.size() - 1), points.get(i)) <= 0)) {
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

    private static double dist(Point p1, Point p2) {
        return Math.sqrt((p2.x - p1.x) * (p2.x - p1.x) + (p2.y - p1.y) * (p2.y - p1.y));
    }
}
