public class AllVowels {
    public static void main(String[] args) {
        String input = IO.readln("Enter a string: ");

        String withoutVowels = "";
        for (int i = 0; i < input.length(); i++) {
            char character = input.charAt(i);
            if ("aeiouAEIOU".indexOf(character) == -1) {
                withoutVowels += character;
            }
        }

        System.out.println(withoutVowels);
    }
}
