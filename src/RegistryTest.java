import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author R. Schiedermeier
 * @version 2026-10-14
 */
class RegistryTest {
    @Test void unknownNameHasNoValue() {
        Registry sut = new Registry();
        int want = -1;

        int have = sut.recall("B");

        assertEquals(want, have);
    }

    @Test void store() {
        Registry sut = new Registry();
        int want = 52;

        sut.store("B", 52);
        int have = sut.recall("B");

        assertEquals(want, have);
    }

    @Test void storeInvalid() {
        Registry sut = new Registry();
        int want = -1;

        sut.store("B", -2);
        int have = sut.recall("B");

        assertEquals(want, have);
    }

    @Test void storeAndUpdate() {
        Registry sut = new Registry();
        int want = 52;

        sut.store("B", 51);
        sut.store("B", 52);
        int have = sut.recall("B");

        assertEquals(want, have);
    }

    @Test void storeInvalidAndUpdate() {
        Registry sut = new Registry();
        int want = 52;

        sut.store("B", -1);
        sut.store("B", 52);
        int have = sut.recall("B");

        assertEquals(want, have);
    }

    @Test void storeAndUpdateInvalid() {
        Registry sut = new Registry();
        int want = 52;

        sut.store("B", 52);
        sut.store("B", -1);
        int have = sut.recall("B");

        assertEquals(want, have);
    }

    @Test void storeSome() {
        Registry sut = new Registry();
        int want = 52;

        sut.store("B", 52);
        sut.store("C", 4);
        sut.store("A", 380);

        assertEquals(want, sut.recall("B"));
        assertEquals(380, sut.recall("A"));
        assertEquals(4, sut.recall("C"));
    }

    @Test void deleteUnknown() {
        Registry sut = new Registry();
        int want = -1;

        sut.delete("B");
        sut.delete("B");

        assertEquals(want, sut.recall("B"));
    }

    @Test void storeThenDelete() {
        Registry sut = new Registry();
        int want = -1;

        sut.store("B", 52);
        sut.delete("B");

        assertEquals(want, sut.recall("B"));
    }

    @Test void storeThenDeleteTwice() {
        Registry sut = new Registry();
        int want = -1;

        sut.store("B", 51);
        sut.delete("B");
        sut.store("B", 52);
        sut.delete("B");

        assertEquals(want, sut.recall("B"));
    }

    @Test void emptyNames() {
        Registry sut = new Registry();

        assertTrue(sut.names().isEmpty());
    }

    @Test void someNames() {
        Registry sut = new Registry();
        Set<String> want = Set.of("A", "B", "C");

        sut.store("B", 51);
        sut.store("C", 3);
        sut.store("A", 379);
        sut.store("D", 2);
        sut.store("B", 52);
        sut.store("C", 4);
        sut.store("A", 380);
        sut.delete("D");
        List<String> names = sut.names();

        assertEquals(3, names.size());
        assertEquals(want, new HashSet<>(names));
    }

    @Test void namesIsSave() {
        Registry sut = new Registry();
        Set<String> want = Set.of("A", "B", "C");

        sut.store("B", 51);
        sut.store("C", 3);
        sut.store("A", 379);
        List<String> names = sut.names();
        try {
            names.remove("A");
        } catch(Exception exception) {}

        names = sut.names();
        assertEquals(3, names.size());
        assertEquals(want, new HashSet<>(names));
    }

    @Test void floodStore() {
        Registry sut = new Registry();
        for(int code = 0; code < 1000; code++)
            sut.store("x".repeat(code), code);

        List<String> names = sut.names();
        assertEquals(1000, names.size());
        assertEquals(0, sut.recall(""));
        assertEquals(999, sut.recall("x".repeat(999)));
        assertEquals(-1, sut.recall("x".repeat(1000)));
    }

    @Test void floodStoreAndDelete() {
        Registry sut = new Registry();
        for(int code = 0; code < 1000; code++)
            sut.store("x".repeat(code), code);
        for(int code = 999; code >= 0; code = code - 1)
            sut.delete("x".repeat(code));

        List<String> names = sut.names();
        assertTrue(names.isEmpty());
    }

    @Test void demo() {
        Registry registry = new Registry();

        // store
        registry.store("Mm. Zsazsa", 42);
        registry.store("Colonel Bubble", 0);
        registry.store("Lord Fiddlebottom", 238);

        // recall
        assertEquals(42, registry.recall("Mm. Zsazsa")); // 42
        assertEquals(0, registry.recall("Colonel Bubble")); // 0
        assertEquals(238, registry.recall("Lord Fiddlebottom")); // 238
        assertEquals(-1, registry.recall("Mr X")); // -1

        // update
        registry.store("Colonel Bubble", 252);
        registry.store("Colonel Bubble", 123456789);
        assertEquals(123456789, registry.recall("Colonel Bubble")); // 213456789
        assertEquals(238, registry.recall("Lord Fiddlebottom")); // 238

        // delete
        registry.delete("Colonel Bubble");
        assertEquals(-1, registry.recall("Colonel Bubble")); // -1
        assertEquals(238, registry.recall("Lord Fiddlebottom")); // 238
        registry.delete("Colonel Bubble"); // already gone
        assertEquals(-1, registry.recall("Colonel Bubble")); // -1

        // names
        List<String> names = registry.names();
        assertEquals(2, names.size()); // 2
        assertTrue(names.contains("Lord Fiddlebottom")); // true
        assertTrue(names.contains("Mm. Zsazsa")); // true

    }
}