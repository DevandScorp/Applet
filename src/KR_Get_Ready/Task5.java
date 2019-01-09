package KR_Get_Ready;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Task5 {
    public static void main(String[] args) {
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))){
            StringBuilder stringBuilder = new StringBuilder();
            String s=null;
            while(!(s = bufferedReader.readLine()).equals("exit")){
                stringBuilder.append(s+" ");
            }
            s = stringBuilder.toString();
            StringTokenizer stringTokenizer = new StringTokenizer(s,"?./ \n\t");
            while(stringTokenizer.hasMoreTokens()){
                String s1 = stringTokenizer.nextToken();
                System.out.println(s1);
                if(s1.matches("[0-9]+")){
                    System.out.println("that is it" + s1);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
