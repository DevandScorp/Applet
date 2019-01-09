package KR_Get_Ready;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task4 {
    public static void main(String[] args) {
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))){
            StringBuilder stringBuilder = new StringBuilder();
            String s=null;
            while(!(s = bufferedReader.readLine()).equals("exit")){
                stringBuilder.append(s+" ");
            }
            s = stringBuilder.toString();
            for(int i = 0;i<s.length();++i){
                int question = s.indexOf('?',i);
                if(question!=-1){
                    String m = s.substring(i,question);
                    String[] inner = m.split("[!.]");
                    System.out.println(inner[inner.length-1]);
                    System.out.println();
                    i = question+1;
                }
                else{
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
