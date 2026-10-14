public record Box(int width, int height, int depth) {
    int volume() {
        return width * height * depth;
    }

    public boolean atLeastVolume(int minVolume) {
        return volume() >= minVolume;
    }
}
