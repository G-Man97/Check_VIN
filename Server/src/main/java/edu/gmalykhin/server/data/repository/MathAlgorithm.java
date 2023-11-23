package edu.gmalykhin.server.data.repository;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public final class MathAlgorithm {
    private static final Map<Character, Integer> TABLE_1;

    static {
        Map<Character, Integer> tempMap = new TreeMap<>();
        tempMap.put('A', 1);
        tempMap.put('B', 2);
        tempMap.put('C', 3);
        tempMap.put('D', 4);
        tempMap.put('E', 5);
        tempMap.put('F', 6);
        tempMap.put('G', 7);
        tempMap.put('H', 8);
        tempMap.put('J', 1);
        tempMap.put('K', 2);
        tempMap.put('L', 3);
        tempMap.put('M', 4);
        tempMap.put('N', 5);
        tempMap.put('P', 7);
        tempMap.put('R', 9);
        tempMap.put('S', 2);
        tempMap.put('T', 3);
        tempMap.put('U', 4);
        tempMap.put('V', 5);
        tempMap.put('W', 6);
        tempMap.put('X', 7);
        tempMap.put('Y', 8);
        tempMap.put('Z', 9);

        TABLE_1 = Collections.unmodifiableMap(tempMap);
    }

    private static final int[] TABLE_2 = {8, 7, 6, 5, 4, 3, 2, 10, 0, 9, 8, 7, 6, 5, 4, 3, 2};

    private MathAlgorithm() {
    }

    public static int calculate(String vin) {

        int sum = 0;

        int[] vinToSequenceOfDigits = vin.chars().mapToObj(c -> (char) c)
                .mapToInt(character ->
                        TABLE_1.containsKey(character)
                                ? TABLE_1.get(character)
                                : Character.digit(character, 10)).toArray();

        for (int i = 0; i < vinToSequenceOfDigits.length; i++) {
            sum += vinToSequenceOfDigits[i] * TABLE_2[i];
        }

        return sum % 11;
    }
}
