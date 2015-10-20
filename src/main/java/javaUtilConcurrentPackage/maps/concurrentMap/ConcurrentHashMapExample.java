package javaUtilConcurrentPackage.maps.concurrentMap;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Example of ConcurrentMap interface with ConcurrentHashMap implementation.
 * Has better concurrency than HashTable.
 * Does not block for read, block only changing part for write.
 *
 * @author dkorolev
 *         Date: 20.10.15
 *         Time: 20:08
 */
public class ConcurrentHashMapExample {

    public static void main(String[] args) {

        ConcurrentMap<String, Integer> concurrentMap = new ConcurrentHashMap<>();

        concurrentMap.put("a", 1);
        concurrentMap.put("b", 2);

        Integer i = concurrentMap.get("b");
        System.out.println(i);
    }
}
