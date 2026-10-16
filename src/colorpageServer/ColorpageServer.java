package colorpageServer;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class ColorpageServer {
    void main() throws IOException {
        final InetSocketAddress address = new InetSocketAddress(12345);
        final HttpServer server = HttpServer.create(address, 0);
        server.createContext("/color", new ColorpageHandler());
        server.start();
    }
}