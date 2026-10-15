import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class LineCount {
    public static String readLine(InputStream inputStream) throws IOException {
        StringBuilder line = new StringBuilder();
        int code = inputStream.read();
        while(code != '\n' && code >= 0) {
            line.appendCodePoint(code);
            code = inputStream.read();
        }
        return code < 0 && line.isEmpty()? null: line.toString();
    }

    public static void main(String[] args) throws IOException {
        InputStream inputStream = new FileInputStream("greeting.txt");
        String line = readLine(inputStream);
        int lineNumber = 1;
        while(line != null) {
            System.out.println(lineNumber + ": " + line);
            line = readLine(inputStream);
            lineNumber = lineNumber + 1;
        }
    }
}
