package dreamincode.text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by ncapasso on 5/16/2017.
 */
public class CountVowels {
    public static void main(String[] args) {
        CountVowels vow = new CountVowels();
        vow.countVowels(vow.getInput());
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

    private void countVowels(ArrayList<String> strings){
        for(String s : strings){
            int vowelCount = 0;
            int consCount = 0;

            for(char c : s.toCharArray()){
                switch(c){
                    case 'a': vowelCount++; break;
                    case 'e': vowelCount++; break;
                    case 'i': vowelCount++; break;
                    case 'o': vowelCount++; break;
                    case 'u': vowelCount++; break;
                    case 'y': vowelCount++; break;
                    default: consCount++;
                }
            }
            System.out.println("Current word: " + s + "\n" +
                    "Vowel count: " + vowelCount + "\n" +
                    "Consonant count:" + consCount + "\n");
        }
    }
}
