package pets;

public record Dog(String name) implements Pet {
    public String sound() {
        return "woof-woof";
    }
}
