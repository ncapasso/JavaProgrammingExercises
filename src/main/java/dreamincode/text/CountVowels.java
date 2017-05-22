package dreamincode.text;

import utilities.IOUtils;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by ncapasso on 5/16/2017.
 */
public class CountVowels {
    public static void main(String[] args) {
        CountVowels vow = new CountVowels();
        System.out.println("Please enter any number of words to count the vowels. Empty input exits.");
        vow.printMap(
                vow.countVowelsAndConsonants(IOUtils.getInput(System.in))
        );
    }

    public Map<String, int[]> countVowelsAndConsonants(ArrayList<String> strings){
        Map<String, int[]> wordValues = new LinkedHashMap<>();

        for(String s : strings){
            int vowelCount = 0;
            int consCount = 0;
            int i = 0;

            if(s.isEmpty()) {
                wordValues.put(s, new int[]{0, 0});
                continue;
            }


            char[] cArray = s.toCharArray();

            //Special case: Y is a vowel if at the beginning of a sentence, otherwise it's a consonant.
            if(cArray[0] == 'y'){
                vowelCount++;
                i++;
            }

            for( ; i < cArray.length; i++){
                if(!Character.isAlphabetic(cArray[i]))
                    continue;

                switch(Character.toLowerCase(cArray[i])){
                    case 'a': vowelCount++; break;
                    case 'e': vowelCount++; break;
                    case 'i': vowelCount++; break;
                    case 'o': vowelCount++; break;
                    case 'u': vowelCount++; break;
                    default: consCount++;
                }
            }

            wordValues.put(s, new int[]{vowelCount, consCount});


        }
        return wordValues;
    }

    private void printMap(Map<String, int[]> map){
        map.forEach((k,v)-> System.out.println("Current word: " + k + "\n" +
       "Vowel count: " + v[0] + "\n" +
       "Consonant count:" + v[1] + "\n"));
    }
}
