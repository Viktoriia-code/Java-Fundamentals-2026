public record Pair(int fst, int snd) {
    public boolean pure() { return fst == snd; }

    public int max() {
        if(fst > snd) {
            return fst;
        } else { return snd; }
    }

    Pair flipped() {
        return new Pair(snd, fst);
    }

    boolean similar(Pair other) {
        return fst == other.fst || snd == other.snd || fst == other.snd || snd == other.fst;
    }

    Pair add(Pair other) {
        return new Pair(fst+other.fst, snd+other.snd);
    }
}
