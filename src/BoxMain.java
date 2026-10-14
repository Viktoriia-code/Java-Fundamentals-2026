public class BoxMain {
    public static void main(String[] args) {
        Box myNewBox = new Box(3, 4, 5);
        System.out.println("Width: " + myNewBox.width());
        System.out.println("Height: " + myNewBox.height());
        System.out.println("Depth: " + myNewBox.depth());

        if(myNewBox.atLeastVolume(50)) {
            System.out.println("big bix");
        } else {
            System.out.println("small box");
        }
    }
}
