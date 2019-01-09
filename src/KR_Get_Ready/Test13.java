package KR_Get_Ready;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test13 {
    public static void main(String[] args) {
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))){
            StringBuilder stringBuilder = new StringBuilder();
            String s=null;
            while(!(s = bufferedReader.readLine()).equals("exit")){
                stringBuilder.append(s);
            }
            s = stringBuilder.toString();
            String s1 = s.replaceAll("\\s{8}", "\t");
            System.out.println(s1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
