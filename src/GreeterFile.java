import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class GreeterFile {
    public static void main(String[] args) throws IOException {
        FileOutputStream output = new FileOutputStream("greeting.txt");
        output.write(2026);
        output.write("""
                In the beginning,
                in the very old days it was useful to learn programming""".getBytes());
    }
}
