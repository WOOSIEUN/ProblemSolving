import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_3679 {
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
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            ArrayList<Point> points = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                points.add(new Point(i, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }

            points = makePolygon(points);
            for (int i = 0; i < points.size(); i++) {
                sb.append(points.get(i).idx).append(" ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }

    private static ArrayList<Point> makePolygon(ArrayList<Point> points) {
        Point root = getRoot(points);

        points.sort((p1, p2) -> {
            int result = ccw(root, p1, p2);

            if (result > 0) {
                return -1;
            } else if (result < 0) {
                return 1;
            } else {
                long distanceP1 = dist(root, p1);
                long distanceP2 = dist(root, p2);
                if (distanceP1 > distanceP2) {
                    return 1;
                }
            }
            return -1;
        });

        int inLineIdx = getInLineIdx(root, points);
        Collections.reverse(points.subList(inLineIdx, points.size()));

        return points;
    }

    private static int getInLineIdx(Point root, ArrayList<Point> points) {
        for (int inLineIdx = points.size() - 1; inLineIdx > 0; inLineIdx--){
            if (ccw(root, points.get(inLineIdx), points.get(inLineIdx - 1)) != 0) {
                return inLineIdx;
            }
        }
        return 0;
    }

    private static Point getRoot(ArrayList<Point> points) {
        Point root = new Point(-1, Integer.MAX_VALUE, Integer.MAX_VALUE);

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

    private static long dist(Point p1, Point p2) {
        return (long) (p2.x - p1.x) * (p2.x - p1.x) + (long) (p2.y - p1.y) * (p2.y - p1.y);
    }
}
