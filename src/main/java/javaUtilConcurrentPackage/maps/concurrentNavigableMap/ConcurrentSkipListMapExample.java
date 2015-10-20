package javaUtilConcurrentPackage.maps.concurrentNavigableMap;

import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * Example of ConcurrentNavigableMap with ConcurrentSkipListMap implementation.
 * Adds support for concurrent access.
 *
 * @author dkorolev
 *         Date: 20.10.15
 *         Time: 20:14
 */
public class ConcurrentSkipListMapExample {

    public static void main(String[] args) {
        ConcurrentNavigableMap<Integer, String> navigableMap = new ConcurrentSkipListMap<>();

        navigableMap.put(1, "a");
        navigableMap.put(2, "b");
        navigableMap.put(3, "c");

        //return map where keys are strictly less than the given one.
        ConcurrentNavigableMap<Integer,String> headMap = navigableMap.headMap(2);
        for (Integer i : headMap.keySet()) {
            System.out.println(i);
        }

        System.out.println();
        // return map where keys are greater or equal than the given one.
        ConcurrentNavigableMap<Integer, String> tailMap = navigableMap.tailMap(2);
        for (Integer i : tailMap.keySet()) {
            System.out.println(i);
        }


        System.out.println();
        // return map where keys are ge 1st, lt 2nd one.
        ConcurrentNavigableMap<Integer, String> subMap = navigableMap.subMap(2, 3);
        for (Integer i : subMap.keySet()) {
            System.out.println(i);
        }


        System.out.println();
        // return map with reverse order.
        ConcurrentNavigableMap<Integer, String> descMap = navigableMap.descendingMap();
        for (Integer i : descMap.keySet()) {
            System.out.println(i);
        }
    }
}
