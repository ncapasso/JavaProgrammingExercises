package other;

import utilities.IOUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by ncapasso on 5/25/2017.
 */
public class LeetSpeakConverter {

    private static final Map<String, String[]> leetMap;

    static {
        leetMap = new HashMap<>();
        leetMap.put("a", new String[]{"/-\\", "/\\", "4", "@"});
        leetMap.put("b", new String[]{"|3", "8", "|o"});
        leetMap.put("c", new String[]{"(", "<", "K", "S"});
        leetMap.put("d", new String[]{"|)", "o|", "|>", "<|"});
        leetMap.put("e", new String[]{"3"});
        leetMap.put("f", new String[]{"|=", "ph"});
        leetMap.put("g", new String[]{"(", "9", "6"});
        leetMap.put("h", new String[]{"|-|", "]-[", "}-{", "(-)", ")-(", "#"});
        leetMap.put("i", new String[]{"l", "1", "|", "!", "]["});
        leetMap.put("j", new String[]{"_|"});
        leetMap.put("k", new String[]{"|<", "/<", "\\<", "|{"});
        leetMap.put("l", new String[]{"|_", "|", "1"});
        leetMap.put("m", new String[]{"|\\/|", "/\\/\\", "|'|'|", "(\\/)", "/\\\\", "/|\\", "/v\\"});
        leetMap.put("n", new String[]{"|\\|", "/\\/", "|\\\\|", "/|/"});
        leetMap.put("o", new String[]{"o", "()", "[]", "{}"});
        leetMap.put("p", new String[]{"|2", "|D"});
        leetMap.put("q", new String[]{"(,)", "kw"});
        leetMap.put("r", new String[]{"|2", "|Z", "|?"});
        leetMap.put("s", new String[]{"5", "$"});
        leetMap.put("t", new String[]{"+", "\'][\'", "7"});
        leetMap.put("u", new String[]{"|_|"});
        leetMap.put("v", new String[]{"[/", "\\|", "\\/", "/"});
        leetMap.put("w", new String[]{"\\/\\/", "\\|\\|", "|/|/", "\\|/", "\\^/", "//"});
        leetMap.put("x", new String[]{"><", "}{"});
        leetMap.put("y", new String[]{"`/", "\'/", "j"});
        leetMap.put("z", new String[]{"2", "(\\)"});
    }

    public static void main(String[] args) {
        // System.out.println(wordConverter("test123"));

        System.out.println("Please enter words to convert into leet-speak. Empty line exits.");
        ArrayList<String> input = IOUtils.getInput(System.in);
        System.out.println("Do you want vowels to be changed? y/n");
        String boolResp = IOUtils.getInputSingleLine(System.in);
        if (boolResp != null && boolResp.toLowerCase().equals("n")) {
            for (String s : input) {
                System.out.println("Original word: " + s + "\nConverted word: " + wordConverter(s , true));
            }
        } else {
            for (String s : input) {
                System.out.println("Original word: " + s + "\nConverted word: " + wordConverter(s, false));
            }
        }
    }


    private static String wordConverter(String input, boolean changeVowels) {
        Random random = new Random();
        StringBuilder str = new StringBuilder();
        char[] wordChar = input.toCharArray();


        for (char c : wordChar) {
            String tempStr = Character.toString(c).toLowerCase();
            if (changeVowels && isAVowel(c)) {
                str.append(c);
                continue;
            }
            if (leetMap.containsKey(tempStr)) {
                String[] tempArr = leetMap.get(tempStr);
                str.append(tempArr[random.nextInt((tempArr.length))]);
            } else {
                str.append(c);
            }
        }
        return str.toString();
    }

    private static boolean isAVowel(char c) {

        switch (Character.toLowerCase(c)) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                return true;
            default:
                return false;
        }
    }
}
