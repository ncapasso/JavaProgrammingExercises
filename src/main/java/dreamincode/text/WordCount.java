package dreamincode.text;

import utilities.IOUtils;

import java.util.ArrayList;

/**
 * Created by ncapasso on 5/16/2017.
 */
public class WordCount {
    public static void main(String[] args) {
        WordCount wc = new WordCount();
        System.out.println("Enter any number of sentences. Empty input exits.");
        wc.wordCounter(IOUtils.getInput(System.in));
    }

    private void wordCounter(ArrayList<String> words) {
        int totalCount = 0;
        for (String s : words) {
            String[] totalStrings = s.split(" ");
            for (String str : totalStrings) {
                if(str.matches("^[-+]?\\d+(\\.\\d+)?$"))
                    continue;
                totalCount++;
            }
        }
        System.out.println("Total word count: " + totalCount);
    }
}
