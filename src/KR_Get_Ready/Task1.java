package KR_Get_Ready;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        String s;
        while(!(s = bufferedReader.readLine()).equals("exit")){
            stringBuilder.append(s);
        }
        String res = stringBuilder.toString();
        for(int i = 0;i<res.length();++i){
            int start = res.indexOf("\"",i);
            if(start==-1)continue;
            int end = res.indexOf("\"",start+1);
            i = end;
            System.out.println(res.substring(start,end+1));
        }

    }
}
