import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_8979 {
    static class Medal implements Comparable<Medal> {
        int idx, gold, silver, bronze;

        public Medal(int idx, int gold, int silver, int bronze) {
            this.idx = idx;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }

        @Override
        public int compareTo(Medal medal) {
            if (this.gold == medal.gold) {
                if (this.silver == medal.silver) {
                    return medal.bronze - this.bronze;
                }
                return medal.silver - this.silver;
            }
            return medal.gold - this.gold;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Medal[] medals = new Medal[N];
        for (int i = 0; i < medals.length; i++) {
            st = new StringTokenizer(br.readLine());
            medals[i] = new Medal(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(medals);

        int rank = 1;
        for (int i = 1, curRank = 1; i < medals.length; i++) {
            if (medals[i].gold != medals[i - 1].gold || medals[i].silver != medals[i - 1].silver || medals[i].bronze != medals[i - 1].bronze) {
                curRank = i + 1;
            }

            if (medals[i].idx == K) {
                rank = curRank;
                break;
            }
        }

        bw.write(String.valueOf(rank));
        br.close();
        bw.close();
    }
}
