package pets;

public record Cat(String name) implements Pet {
    public String sound() {
        return "meow";
    }
}
