package dreamincode.text;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertTrue;

/**
 * Created by ncapasso on 5/17/2017.
 */
public class CountVowelsTest {

    @Test
    public void checkWords() {
        Map<String, int[]> testWords = new LinkedHashMap<>();
        CountVowels cv = new CountVowels();

        testWords.put("banana", new int[]{3, 3});
        testWords.put("aeiou", new int[]{5, 0});
        testWords.put("test 123", new int[]{1, 3});
        testWords.put("!@#", new int[]{0, 0});
        testWords.put("", new int[]{0, 0});
        testWords.put("This Is A Test", new int[]{4, 7});

        ArrayList<String> testList = new ArrayList<>(testWords.keySet());
        Map<String, int[]> returnedMap = cv.countVowelsAndConsonants(testList);

        assertTrue(compare(returnedMap).equals(compare(testWords)));
    }

    private static Map<String, List<Integer>> compare(Map<String, int[]> givenMap) {
        Map<String, List<Integer>> tempMap = new LinkedHashMap<>();
        givenMap.forEach((s, i) -> {
            List<Integer> intList = new ArrayList<>(i.length);
            for (int z : i) {
                intList.add(z);
            }
            tempMap.put(s, intList);
        });
        return tempMap;
    }
}
