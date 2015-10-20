package javaUtilConcurrentPackage.concurrentMap.concurrentHashMap;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
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
