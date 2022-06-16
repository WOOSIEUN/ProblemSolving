import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
 
public class Solution {
 
    static class Point {
        int x, y;
 
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
 
    static class Person implements Comparable<Person> {
        String name;
        char type;
        int score;
 
        public Person(String name, char type) {
            this.name = name;
            this.type = type;
            this.score = 0;
        }
 
        public int compareTo(Person o) {
            if (this.score == o.score)
                return this.name.compareTo(o.name);
            else
                return o.score - this.score;
        }
    }
 
    static int[][] mapNumber = new int[5][8];
    static char[][] mapChar = new char[5][8];
    static ArrayList<Point>[] startList;
    static int max;
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();
        StringTokenizer st;
 
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            // 사람 입력
            int N = Integer.parseInt(br.readLine());
            ArrayList<Person> people = new ArrayList<Person>();
            startList = new ArrayList[N];
            for (int i = 0; i < N; i++)
                startList[i] = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                people.add(new Person(st.nextToken(), st.nextToken().charAt(0)));
            }
 
            // 맵 입력
            for (int i = 0; i < 5; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 8; j++) {
                    String cur = st.nextToken();
                    mapChar[i][j] = cur.charAt(0);
                    mapNumber[i][j] = cur.charAt(1) - '0';
                    // 출발 가능점은 ArrayList에 가능점으로 추가
                    // 8인 카드는 출발점이 될 수 없음
                    if (cur.charAt(1) - '0' != 8)
                        for (int k = 0; k < N; k++)
                            // 같은 타입일 경우 추가
                            if (people.get(k).type == cur.charAt(0))
                                startList[k].add(new Point(i, j));
                }
            }
 
            // 출발 가능점에 대해서 탐색
            for (int k = 0; k < N; k++)
                for (int i = 0; i < startList[k].size(); i++) {
                    max = -1;
                    int x = startList[k].get(i).x;
                    int y = startList[k].get(i).y;
                    dfs(x, y, people.get(k).type, (mapNumber[x][y] == 1 ? true : false), 1, 1);
                    int score = max;
                    // -1을 리턴 받은 경우 탐색이 불가능한 케이스
                    if (score != -1) {
                        people.get(k).score = Math.max(people.get(k).score, score);
                    }
                }
 
            // 점수 - 이름 순으로 정렬하여 동점자까지 출력
            Collections.sort(people);
            int max = people.get(0).score;
            result.append("#" + t + " " + people.get(0).name);
            for (int i = 1; i < N; i++) {
                if (people.get(i).score == max)
                    result.append(" " + people.get(i).name);
                else
                    break;
            }
            result.append("\n");
        }
        bw.write(result.toString());
        br.close();
        bw.close();
    }
     
    static int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}};
     
    /* 맵을 사방탐색하며 산책로를 구성하고, 그 점수를 계산하는 함수 */
    private static void dfs(int x, int y, char type, boolean isStartWithOne, int depth, int typeCnt) {
        int curVal = mapNumber[x][y];
        // 현재 지점의 타입이 권리를 가진 타입과 동일하며, depth가 1을 초과하는 경우 도착점으로 선정이 가능하므로 점수를 계산
        if (mapChar[x][y] == type && depth > 1) {
                /* 기본 점수 */
                int compareScore = depth;
                 
                /* 추가 점수 확인 */
                // type 연속에 따른 보너스 점수 처리를 위한 처리
                // 구성한 산책로의 길이와 권리를 가진 타입의 산책로의 수가 동일하며, 그 길이가 4 이상인 경우 추가 점수 획득
                if (depth == typeCnt && typeCnt >= 4) compareScore += typeCnt;
                 
                // 만약 시작점이 1이었을 경우 1점 추가
                if(isStartWithOne) compareScore++;
                 
                // 만약 종료점이 8일 경우 2점 추가
                if (curVal == 8) compareScore += 2;
                 
                //전체 점수 계산 후 max 값과 비교하여 가장 큰 값을 저장
                max = Math.max(max, compareScore);
        }
         
        // 사방 탐색
        for (int[] dir : dirs) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            // 맵 범위 내에 존재하고, 현재 맵의 숫자보다 가려는 맵의 숫자가 큰 경우 산책로를 구성할 수 있음
            if (rangeCheck(nx, ny) && mapNumber[nx][ny] > curVal) {
                if (mapChar[nx][ny] != type) {
                    // 같은 타입이 아닌 경우, 타입 연속에 따른 보너스 점수 처리를 위해 typeCnt를 증가시키지 않음
                    dfs(nx, ny, type, isStartWithOne, depth + 1, typeCnt);
                } else {
                    // 같은 타입인 경우, typeCnt를 증가하며 계속 탐색
                    dfs(nx, ny, type, isStartWithOne, depth + 1, typeCnt + 1);
                }
            }
        }
    }
 
    /* 탐색하려는 지점이 맵 안에 위치하는지 확인하는 함수 */
    private static boolean rangeCheck(int x, int y) {
        return (0 <= x && x < 5 && 0 <= y && y < 8 ? true : false);
    }
}