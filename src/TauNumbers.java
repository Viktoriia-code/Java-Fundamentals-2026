public class TauNumbers {
    public static void main(String[] args) {
        for (int i = 1; i <= 1000; i++) {
            int sumOfDivisors = 0;
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    sumOfDivisors++;
                }
            }
            if (i % sumOfDivisors == 0) {
                System.out.println(i);
            }
        }
    }
    // My email address is: Viktoriia.Beloborodova@metropolia.fi
}
