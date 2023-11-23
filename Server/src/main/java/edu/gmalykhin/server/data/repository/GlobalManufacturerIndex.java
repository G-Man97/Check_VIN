package edu.gmalykhin.server.data.repository;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class GlobalManufacturerIndex {
    public static final Map<String, String> GLOBAL_MANUFACTURER_INDEX;

    static {
        Map<String, String> tempMap = new TreeMap<>();
        tempMap.put("WBA", "BMW-AG");
        tempMap.put("WBH", "BMW-AG");
        tempMap.put("WBS", "BMW-AG");
        tempMap.put("WUA", "BMW-AG");
        tempMap.put("WUS", "BMW-AG");
        tempMap.put("X4A", "BMW-AG");

        GLOBAL_MANUFACTURER_INDEX = Collections.unmodifiableMap(tempMap);
    }
}
