package dreamincode.text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by ncapasso on 5/16/2017.
 */
public class CheckIfPalendrome {
    public static void main(String[] args) {
        CheckIfPalendrome pal = new CheckIfPalendrome();
        pal.checkIfPalindrome(pal.getInput());
    }

    private ArrayList<String> getInput(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> stringArrayList = new ArrayList<>();
        System.out.println("Enter any number of sentences. Empty input exits.");
        String input;
        try {
            while((input = br.readLine()) != null && !input.isEmpty()){
                stringArrayList.add(input);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringArrayList;
    }

    private void checkIfPalindrome(ArrayList<String> strings){
        for(String s : strings){
            StringBuilder temp = new StringBuilder();
            char[] strArray = s.toCharArray();
            for(int i = strArray.length; i > 0; i--){
                temp.append(strArray[i - 1]);
            }
            if(temp.toString().equals(s)){
                System.out.println(s + " is a palindrome");
                continue;
            }
            System.out.println(s + " is not a palindrome.");
        }
    }
}
