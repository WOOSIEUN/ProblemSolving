import java.io.*;
import java.util.*;

public class BOJ_9250 {
    static class TrieNode {
        Map<Character, TrieNode> child = new HashMap<>();
        boolean output;
        TrieNode fail;

        public TrieNode() {}

        public void insert(String word) {
            TrieNode curNode = this;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);

                curNode.child.putIfAbsent(c, new TrieNode());
                curNode = curNode.child.get(c);

                if (i == word.length() - 1) {
                    curNode.output = true;
                }
            }
        }

        public void computeFailFunc() {
            Queue<TrieNode> q = new LinkedList<>();
            this.fail = this;
            q.add(this);

            while (!q.isEmpty()) {
                TrieNode cur = q.poll();

                for (int i = 0; i < 26; i++) {
                    char c = (char) (i + 97);
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

        public boolean ahoCorasick(String word) {
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
                    return true;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        TrieNode trieSet = new TrieNode();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            trieSet.insert(br.readLine());
        }

        trieSet.computeFailFunc();

        int Q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < Q; i++) {
            sb.append(trieSet.ahoCorasick(br.readLine())? "YES\n" : "NO\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
