package dreamincode.text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * Created by ncapasso on 5/16/2017.
 */
public class RegexQueryTool {
    public static void main(String[] args) {
        Pattern p = getRegexFromInput();
        if(p != null){
            parseStringFromRegex(getStringToTest(), p);
        }
    }

    private static Pattern getRegexFromInput(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter a regex expression.");
        try {
            String brReturn = br.readLine();
            if(brReturn != null && !brReturn.isEmpty()) {
                return Pattern.compile(br.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch(PatternSyntaxException p){
            System.err.println("Invalid regex pattern. Please try again.\nEnter a blank line to exit.");
            getRegexFromInput();
        }
        return null;
    }

    private static String getStringToTest(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter a sentence to test.");
        try {
            return br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    private static ArrayList<String> parseStringFromRegex(String input, Pattern regexPattern){
        int count = 0;
        if(!input.isEmpty() && regexPattern != null){
            Matcher m = regexPattern.matcher(input);
            while(m.find()){
                count++;
                System.out.println("Number of matched entries: " + count);
            }

        }
        return null;
    }
}
