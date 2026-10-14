package pets;

public class PetMain {
    public static void main(String[] args) {
        Pet dog = new Dog("Buddy");
        Pet cat = new Cat("Whiskers");
        Pet bird = new Bird("Tweety");
        System.out.println(dog.sound());
        System.out.println(cat.sound());
        System.out.println(bird.sound());
        dog = new Doppelganger(new Dog("Snoopy"));
        System.out.println(dog.sound());

        Pet doppelDoppelganger = new Doppelganger(dog);
        System.out.println(doppelDoppelganger.sound());
    }
}
