package pets;

public record Bird(String name) implements Pet {
    public String sound() {
        return "twirk";
    }
}
