public class ArrayPlayground {
    static void main() {
        int[] ia;
        ia = new int[10];

        // this loop can write values to the array
        for(int index=0; index<ia.length; index++)
            ia[index] = index;

        for(int index=0; index<ia.length; index++)
            System.out.println(ia[index]);

        int sum = 0;

        // this loop can read values from the array and can't modify them
        for(int element : ia)
            sum += element;

        System.out.println("Sum of all elements: " + sum);
    }
}
