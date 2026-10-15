package clocktimeServer;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;

public class ClocktimeServer {
    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(12345), 0);
        server.createContext("/", new ClockpageHandler());
        server.start();
    }
}


