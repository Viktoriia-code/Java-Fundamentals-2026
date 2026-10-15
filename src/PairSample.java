public class PairSample {
    void main() {
        Pair p11 = new Pair(1, 1);
        Pair p12 = new Pair(1, 2);
        Pair p43 = new Pair(4, 3);

        // pure
        System.out.println(p11.pure()); // true
        System.out.println(p12.pure()); // false

        // max
        System.out.println(p11.max());  // 1
        System.out.println(p12.max());  // 2

        // flipped
        System.out.println(p43.flipped());  // Pair[fst=3, snd=4]
        if(p43.flipped().flipped().equals(p43))
            System.out.println("flipping twice has no effect");

        // similar
        System.out.println(p11.similar(p12));   // true
        System.out.println(p11.similar(p43));   // false
        System.out.println(p43.similar(p43));   // true

        // add
        System.out.println(p11.add(p43));   // Pair[fst=5, snd=4]
        System.out.println(p11.add(p11).add(p11).add(p11)); // Pair[fst=4, snd=4]
        for(int loops = 0; loops < 10; loops++)
            p11 = p11.add(p11);
        System.out.println(p11); // Pair[fst=1024, snd=1024]
    }
}
