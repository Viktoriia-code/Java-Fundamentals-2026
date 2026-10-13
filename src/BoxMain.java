public class BoxMain {
    public static void main(String[] args) {
        Box myNewBox = new Box(10, 20, 30);
        System.out.println("Width: " + myNewBox.width());
        System.out.println("Height: " + myNewBox.height());
        System.out.println("Depth: " + myNewBox.depth());
    }
}
