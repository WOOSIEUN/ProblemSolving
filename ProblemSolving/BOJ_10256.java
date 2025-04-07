import java.io.*;
import java.util.*;

public class BOJ_10256 {
    static class TrieNode {
        Map<Character, TrieNode> child = new HashMap<>();
        boolean output;
        TrieNode fail;
        char[] DNAs;

        public TrieNode() {
            DNAs = new char[]{'A', 'G', 'T', 'C'};
        }

        public void insert(String word) {
            TrieNode curNode = this;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);

                curNode.child.putIfAbsent(c, new TrieNode());
                curNode = curNode.child.get(c);
            }
            curNode.output = true;
        }

        public void computeFailFunc() {
            Queue<TrieNode> q = new LinkedList<>();
            this.fail = this;
            q.add(this);

            while (!q.isEmpty()) {
                TrieNode cur = q.poll();

                for (char c : DNAs) {
                    TrieNode next = cur.child.get(c);

                    if (next == null) {
                        continue;
                    }

                    if (cur == this) {
                        next.fail = this;
                    } else {
                        TrieNode failLinkNode = cur.fail;

                        while (failLinkNode != this && failLinkNode.child.get(c) == null) {
                            failLinkNode = failLinkNode.fail;
                        }

                        if (failLinkNode.child.get(c) != null) {
                            failLinkNode = failLinkNode.child.get(c);
                        }

                        next.fail = failLinkNode;
                    }

                    if (next.fail.output) {
                        next.output = true;
                    }

                    q.add(next);
                }
            }
        }

        public int ahoCorasick(String word) {
            int cnt = 0;
            TrieNode curNode = this;

            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);

                while (curNode != this && curNode.child.get(c) == null) {
                    curNode = curNode.fail;
                }

                if (curNode.child.get(c) != null) {
                    curNode = curNode.child.get(c);
                }

                if (curNode.output) {
                    cnt++;
                }
            }
            return cnt;
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
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            String DNA = br.readLine();
            String marker = br.readLine();

            TrieNode trie = new TrieNode();
            trie.insert(marker);
            insertVariant(trie, marker);

            trie.computeFailFunc();
            sb.append(trie.ahoCorasick(DNA)).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }

    private static void insertVariant(TrieNode trie, String marker) {
        for (int start = 0; start < marker.length(); start++) {
            for (int end = start + 1; end < marker.length(); end++) {
                trie.insert(reverseString(marker, start, end + 1));
            }
        }
    }

    private static String reverseString(String target, int start, int end) {
        StringBuilder sb = new StringBuilder();
        sb.append(target, 0, start);
        sb.append(new StringBuilder(target.substring(start, end)).reverse());
        sb.append(target, end, target.length());
        return sb.toString();
    }
}
