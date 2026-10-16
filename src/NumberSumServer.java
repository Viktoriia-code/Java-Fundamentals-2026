import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

class NumberSumServer {
    void main() throws IOException {
        final InetSocketAddress address = new InetSocketAddress(23456);
        final HttpServer server = HttpServer.create(address, 0);
        server.createContext("/add", new NumberSumHandler());
        server.start();
    }
}

record NumberSumHandler() implements HttpHandler {
    @Override public void handle(HttpExchange httpExchange) throws IOException {
        // 1.
        final String resource = httpExchange.getRequestURI().getPath();
        final String[] words = resource.split("/");

        int sum = Integer.parseInt(words[2])+Integer.parseInt(words[3]);

        // 2.
        String page = """
                      <html>
                        <head>
                            <title>Number Adding Service</title>
                        </head>
                        <body>
                            <h1>Number Adding Service</h1>
                            <h2>The sum of <span style="color: rgb(255,0,0)">NUM1</span> 
                                and <span style="color: rgb(255,0,0)">NUM2</span> is: 
                                <span style="color: rgb(0,0,255)">SUM</span></h2>
                            <p>Are you happy with the service? Please give me a +1 :-)</p>
                        </body>
                      </html>
                      """
                .replace("NUM1", words[2])
                .replace("NUM2", words[3])
                .replace("SUM", Integer.toString(sum));

        // 3.
        httpExchange.sendResponseHeaders(200, 0);

        // 4.
        final OutputStream body = httpExchange.getResponseBody();
        body.write(page.getBytes());
        body.close();
    }
}
