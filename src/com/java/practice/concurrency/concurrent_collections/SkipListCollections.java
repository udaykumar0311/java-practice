package com.java.practice.concurrency.concurrent_collections;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ConcurrentSkipListSet;

public class SkipListCollections {
    public static void main(String[] args) {
        Set<String> countries = new ConcurrentSkipListSet<>();
        countries.add("Germany");
        countries.add("Canada");
        countries.add("Australia");
        
        // natural order for Stringa is alphabetic
        for(String country:countries){
//            countries.remove(country);
            System.out.println(country);
//            System.out.println(countries);
        }

        Map<String, Integer> map = new ConcurrentSkipListMap<>();
        map.put("Jack", 12);
        map.put("Zack", 15);
        map.put("Anna", 22);
        
        // ordered by keys
        for(String key:map.keySet()){
//            map.remove(key);
            System.out.println(key + " -> " + map.get(key));
        }
    }
}
