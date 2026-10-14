package pets;

public record Doppelganger(Pet original) implements Pet {
    public String name() {
        return original.name();
    }

    public String sound() {
        return original.sound() + original.sound();
    }
}
