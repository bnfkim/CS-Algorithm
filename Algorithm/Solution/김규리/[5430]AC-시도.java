import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;


public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //테스트 케이스 개수
        int T = Integer.parseInt(br.readLine());

        while(T-->0){
            //수행할 함수
            String p = br.readLine();

            //배열에 들어있는 수의 개수
            int n = Integer.parseInt(br.readLine());

            //배열에 들어 있는 정수
            String str = br.readLine();

            //arrStr -> arr 변경
            ArrayList<Integer> arr = makeArr(str, n);

            //arr 에 명령어 적용
            arr = funcArr(p, arr);

            //결과 만들기
            makeResult(arr);
        }
        System.out.println(sb);
    }

    public static ArrayList<Integer> makeArr(String str, int n){
        //str 정리하기
        str = str.substring(1,str.length()-1);

        ArrayList<Integer> arr = new ArrayList<>();

        if(str.length() != 0) {
            String[] strArr = str.split(",");

            for (int i = 0; i < strArr.length; i++) {
                arr.add(Integer.parseInt(strArr[i]));
            }
        }
        return arr;
    }

    public static void makeResult(ArrayList<Integer> arr){

        if(arr.isEmpty()){
            sb.append("error").append("\n");
        } else {
            sb.append("[");
            for (Integer integer : arr) {
                sb.append(integer);
                sb.append(",");
            }

            sb.deleteCharAt(sb.length()-1);
            sb.append("]").append("\n");
        }
    }

    public static ArrayList<Integer> funcArr(String str, ArrayList<Integer> arr) {

        for(int i=0; i<str.length(); i++){
            char st = str.charAt(i);
            switch (st) {
                case 'R':
                    Collections.reverse(arr);
                    break;

                case 'D':
                    if(arr.isEmpty()){
                        return new ArrayList<>();
                    } else{
                        arr.remove(0);
                    }
                    break;
            }
        }
        return arr;
    }
}