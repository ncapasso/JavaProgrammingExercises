package dreamincode.text;

import utilities.IOUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * Created by ncapasso on 5/16/2017.
 */
public class RegexQueryTool {
    public static void main(String[] args) {
        Pattern p = getRegexFromInput();
        if (p != null) {
            System.out.println("Enter any number of sentences. Empty lines exit. ");
            IOUtils.getInput()
                    .forEach(s -> System.out.println(parseStringsFromRegex(s, p)));
        }
    }

    private static Pattern getRegexFromInput() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter a regex expression.");
        try {
            String brReturn = br.readLine();
            return Pattern.compile(brReturn);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (PatternSyntaxException p) {
            System.err.println("Invalid regex pattern. Please try again.\nEnter a blank line to exit.");
            getRegexFromInput();
        }
        return null;
    }

    private static String parseStringsFromRegex(String input, Pattern regexPattern) {
        Matcher m;
        String retString = "";

        String[] temp = input.split("\\p{Blank}");
        for (String s : temp) {
            m = regexPattern.matcher(s);
            if (m.find()) {
                retString = retString.concat("\u001B[31m" + s + "\u001B[0m" + " ");
            } else {
                retString = retString.concat(s + " ");
            }
        }
        return retString;
    }
}
