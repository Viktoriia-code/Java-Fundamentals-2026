package arrayListDay4;

import java.util.List;

/** Demo program for Day 3 Programming Problem: arrayListDay4.Registry
 * @author R. Schiedermeier
 * @version 2026-10-15
 */
public class RegistryDemo {
    public static void main(String[] args) {
        Registry registry = new Registry();

        // store
        registry.store("Mm. Zsazsa", 42);
        registry.store("Colonel Bubble", 0);
        registry.store("Lord Fiddlebottom", 238);

        // recall
        System.out.println(registry.recall("Mm. Zsazsa")); // 42
        System.out.println(registry.recall("Colonel Bubble")); // 0
        System.out.println(registry.recall("Lord Fiddlebottom")); // 238
        System.out.println(registry.recall("Mr X")); // -1

        // update
        registry.store("Colonel Bubble", 252);
        registry.store("Colonel Bubble", 123456789);
        System.out.println(registry.recall("Colonel Bubble")); // 213456789
        System.out.println(registry.recall("Lord Fiddlebottom")); // 238

        // delete
        registry.delete("Colonel Bubble");
        System.out.println(registry.recall("Colonel Bubble")); // -1
        System.out.println(registry.recall("Lord Fiddlebottom")); // 238
        registry.delete("Colonel Bubble"); // already gone
        System.out.println(registry.recall("Colonel Bubble")); // -1

        // names
        List<String> names = registry.names();
        System.out.println(names.size()); // 2
        System.out.println(names.contains("Lord Fiddlebottom")); // true
        System.out.println(names.contains("Mm. Zsazsa")); // true
    }
}
