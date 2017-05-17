package dreamincode.text;

import utilities.IOUtils;

import java.util.ArrayList;

/**
 * Created by ncapasso on 5/16/2017.
 */
public class CheckIfPalendrome {
    public static void main(String[] args) {
        System.out.println("Please enter any number of words to check if it's a palindrome. Empty input exits.");
        checkIfPalindrome(IOUtils.getInput());
    }


    private static void checkIfPalindrome(ArrayList<String> strings){
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
