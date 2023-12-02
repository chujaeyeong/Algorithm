import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        ArrayList<String> list = new ArrayList<>();
        
        for (int i = 0; i < s.length(); i++) {
            list.add(s.substring(i, s.length()));
        }
        
        Collections.sort(list);
        
        for (String i : list) {
            System.out.println(i);
        }
    }
}