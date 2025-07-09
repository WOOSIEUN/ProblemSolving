import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_5635 {
    static class Person implements Comparable<Person> {
        int year, month, day;
        String name;

        public Person(String name, int day, int month, int year) {
            this.year = year;
            this.month = month;
            this.day = day;
            this.name = name;
        }

        @Override
        public int compareTo(Person o) {
            if (this.year == o.year) {
                if (this.month == o.month) {
                    return this.day - o.day;
                }
                return this.month - o.month;
            }
            return this.year - o.year;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Person[] people = new Person[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            people[i] = new Person(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(people);

        bw.write(String.format("%s\n%s", people[people.length - 1].name, people[0].name));
        br.close();
        bw.close();
    }
}
