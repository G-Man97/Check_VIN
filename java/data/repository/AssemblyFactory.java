package data.repository;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class AssemblyFactory {
    public static final Map<Character, String> ASSEMBLY_FACTORY;

    static {
        Map<Character, String> tempMap = new TreeMap<>();
        tempMap.put('A', "München DE");
        tempMap.put('B', "Dingolfing DE");
        tempMap.put('C', "Dingolfing DE");
        tempMap.put('D', "Dingolfing DE");
        tempMap.put('E', "Regensburg DE");
        tempMap.put('F', "München DE");
        tempMap.put('G', "Dingolfing DE");
        tempMap.put('J', "Dingolfing DE");
        tempMap.put('K', "München DE");
        tempMap.put('L', "Spartanburg USA");
        tempMap.put('V', "Leipzig DE");
        tempMap.put('W', "Graz AUS");

        ASSEMBLY_FACTORY = Collections.unmodifiableMap(tempMap);
    }
}
