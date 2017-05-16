package dreamincode.text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by ncapasso on 5/16/2017.
 */
public class StringReverse {
    public static void main(String[] args) {
        StringReverse rev = new StringReverse();

        rev.reverse(rev.getString());
    }

    private void reverse(ArrayList<String> stringArr){
        if(stringArr.isEmpty()) {
            System.out.println("No words were entered. Exiting.");
            return;
        }
        for(String s : stringArr){
            char[] cArr = s.toCharArray();
            for(int i = cArr.length; i > 0; i--){
                System.out.print(cArr[i-1]);
            }
            System.out.println();

        }

    }

    private ArrayList<String> getString(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> strArray = new ArrayList<>();
        System.out.println("Please enter any number of words to reverse. Empty input exits.");
        try {
            String next;
            while((next = br.readLine())!=null && !next.isEmpty()){
                strArray.add(next);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return strArray;
    }
}
