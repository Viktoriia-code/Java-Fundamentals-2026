import java.util.ArrayList;

public class SquareNumbers {
    public static void main(String[] args) {
        ArrayList<Integer> squareNumbers = new ArrayList<>();

        for (int number = 1; number <= 20; number++) {
            squareNumbers.add(number * number);
        }

        for (int i = 0; i < squareNumbers.size(); i++) {
            if (squareNumbers.get(i) % 2 != 0)
                squareNumbers.remove(i);
        }

        for (int squareNumber : squareNumbers) {
            System.out.println(squareNumber);
        }
    }
}
