package revision;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        TreeSet<String> team = new TreeSet<>();
        team.add("india");
        team.add("aus");
        team.add("eng");
        team.add("india");

        System.out.println(team);
    }
}
