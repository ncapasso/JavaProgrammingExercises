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
        wc.wordCounter(IOUtils.getInput());
    }

    private void wordCounter(ArrayList<String> words) {
        int totalCount = 0;
        for (String s : words) {
            String[] totalStrings = s.split(" ");
            for (String str : totalStrings) {
                if (!str.contains(" "))
                    totalCount += 1;
            }
        }
        System.out.println("Total word count: " + totalCount);
    }
}
