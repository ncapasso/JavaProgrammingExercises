package dreamincode.text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by ncapasso on 5/16/2017.
 */
public class WordCount {
    public static void main(String[] args) {
        WordCount wc = new WordCount();
        wc.wordCounter(wc.getInput());
    }

    private ArrayList<String> getInput() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> stringArrayList = new ArrayList<>();
        System.out.println("Enter any number of sentences. Empty input exits.");
        String input;
        try {
            while ((input = br.readLine()) != null && !input.isEmpty()) {
                stringArrayList.add(input);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringArrayList;
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
