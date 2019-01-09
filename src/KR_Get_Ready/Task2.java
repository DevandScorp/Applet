package KR_Get_Ready;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Task2 {
    public static void main(String[] args) {

        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))){
            StringBuilder stringBuilder = new StringBuilder();
            String s=null;
            while(!(s = bufferedReader.readLine()).equals("exit")){
                stringBuilder.append(s+" ");
            }
            s = stringBuilder.toString();
            String[] split = s.split("[ .!?]");
            System.out.println(Arrays.toString(split));
            Arrays.stream(split).forEach(str -> {
                if(Character.isUpperCase(str.charAt(0))) System.out.println(str);
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
