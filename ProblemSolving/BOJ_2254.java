import java.io.*;
import java.util.*;

public class BOJ_2254 {
    static class Point {
        int idx, x, y;

        public Point(int idx, int x, int y) {
            this.idx = idx;
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int px = Integer.parseInt(st.nextToken());
        int py = Integer.parseInt(st.nextToken());
        Point prison = new Point(-1, px, py);

        ArrayList<Point> points = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            points.add(new Point(i, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        int numOfWalls = 0;
        ArrayList<Point> pillars = points;
        while (true) {
            Stack<Point> convexHull = grahamScan(pillars);
            ArrayList<Point> convexHullList = new ArrayList<>(convexHull);

            if (!isInside(convexHullList, prison)) {
                break;
            }

            HashSet<Integer> usedIndexList = new HashSet<>();
            while (!convexHull.empty()) {
                usedIndexList.add(convexHull.pop().idx);
            }

            ArrayList<Point> leftPillars = new ArrayList<>();
            for (Point pillar : pillars) {
                if (!usedIndexList.contains(pillar.idx)) {
                    leftPillars.add(pillar);
                }
            }

            pillars = leftPillars;
            numOfWalls++;
        }

        bw.write(String.valueOf(numOfWalls));
        br.close();
        bw.close();
    }

    private static boolean isInside(ArrayList<Point> wall, Point prison) {
        if (wall.size() < 3) {
            return false;
        }

        int ccw = ccw(wall.get(0), wall.get(1), prison);
        for (int i = 1; i < wall.size(); i++) {
            int curCcw = ccw(wall.get(i), wall.get((i + 1) % wall.size()), prison);
            if (curCcw != ccw) {
                return false;
            }
        }
        return true;
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
                    long distanceP1 = dist(root, p1);
                    long distanceP2 = dist(root, p2);
                    return Long.compare(distanceP1, distanceP2);
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
        Point root = new Point(-1, Integer.MIN_VALUE, Integer.MIN_VALUE);

        for (int i = 0; i < points.size(); i++) {
            if (points.get(i).y > root.y) {
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

    private static long dist(Point p1, Point p2) {
        return (long) (p2.x - p1.x) * (p2.x - p1.x) + (long) (p2.y - p1.y) * (p2.y - p1.y);
    }
}
