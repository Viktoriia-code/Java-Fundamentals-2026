import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/** Test class for Day 2 Programming Problem: Pair
 * @author R. Schiedermeier
 * @version 2026-07-15
 */
class PairTest {
    @Test void pure() {
        Pair sut = new Pair(1, 1);
        assertTrue(sut.pure());
    }

    @Test void notPure() {
        Pair sut = new Pair(1, 2);
        assertFalse(sut.pure());
    }

    @Test void maxFst() {
        Pair sut = new Pair(2, 1);
        final int want = 2;
        assertEquals(want, sut.max());
    }

    @Test void maxSnd() {
        Pair sut = new Pair(1, 2);
        final int want = 2;
        assertEquals(want, sut.max());
    }

    @Test void flipped() {
        Pair sut = new Pair(1, 2);
        Pair want = new Pair(2, 1);
        Pair have = sut.flipped();
        assertEquals(want, have);
    }

    @Test void similar11() {
        Pair sut = new Pair(1, 2);
        Pair other = new Pair(1, 3);
        assertTrue(sut.similar(other));
    }

    @Test void similar12() {
        Pair sut = new Pair(1, 2);
        Pair other = new Pair(3, 1);
        assertTrue(sut.similar(other));
    }

    @Test void similar21() {
        Pair sut = new Pair(1, 2);
        Pair other = new Pair(2, 3);
        assertTrue(sut.similar(other));
    }

    @Test void similar22() {
        Pair sut = new Pair(1, 2);
        Pair other = new Pair(3, 2);
        assertTrue(sut.similar(other));
    }

    @Test void notSimilar11() {
        Pair sut = new Pair(1, 2);
        Pair other = new Pair(3, 4);
        assertFalse(sut.similar(other));
    }

    @Test void add() {
        Pair sut = new Pair(1, 2);
        Pair other = new Pair(3, 4);
        Pair want = new Pair(4, 6);
        Pair have = sut.add(other);
        assertEquals(want, have);
    }
}