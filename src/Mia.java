public class Mia {
    void main(String[] args) {
        // Read input
        int roll1 = Integer.parseInt(IO.readln("1st roll: "));
        int roll2 = Integer.parseInt(IO.readln("2nd roll: "));

        // Variable for the result
        int value = 0;

        // -- do not change anything above this line --
        // my solution here
        if (roll1 == 1 && roll2 == 2 || roll1 == 2 && roll2 == 1) {
            value = 1000;
        } else if (roll1 == roll2) {
            value = roll1 * 100;
        } else {
            if (roll1 > roll2) {
                value = roll1 * 10 + roll2;
            } else {
                value = roll2 * 10 + roll1;
            }
        }
        // -- do not change anything below this line --

        // print result
        System.out.println(value);
    }
}