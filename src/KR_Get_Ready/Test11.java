package KR_Get_Ready;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Test11 {
    private static boolean isPalindrom(String str){
        for(int i = 0;i<str.length()/2;++i){
            if(str.charAt(i)!=str.charAt(str.length()-(1+i))){
                return false;
            }
        }
        return true;
    }
    static class Position {
        private int start;
        private int end;
        private String value;

        public Position(int start, String value){
            this.start = start;
            this.value = value;
            this.end = start+ value.length()-1;
        }

        public int getStart() {
            return start;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public int getEnd() {
            return end;
        }

        public void setEnd(int end) {
            this.end = end;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Position{" +
                    "start=" + start +
                    ", end=" + end +
                    ", value='" + value + '\'' +
                    '}';
        }
    }
    public static void main(String[] args) {
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))){
            StringBuilder stringBuilder = new StringBuilder();
            String s=null;
            while(!(s = bufferedReader.readLine()).equals("exit")){
                StringBuilder res = new StringBuilder(s);
                List<Position> positions = new ArrayList<>();
                String[] strings = s.split("[^A-Za-z]");
                int pos = 0;
                for(String a : strings) {
                    pos = s.indexOf(a, pos);
                    if (isPalindrom(a)) {
                        positions.add(new Position(pos,a));
                    }
                }
                List<Position> sorted = new ArrayList<>(positions);
                sorted.sort(Comparator.comparing(o -> o.value));
                System.out.println(positions);
                System.out.println(sorted);
                for (int i = sorted.size() - 1; i >= 0; --i){
                    res.replace(positions.get(i).start, positions.get(i).end + 1, sorted.get(i).value);
                }
                System.out.println(res.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
