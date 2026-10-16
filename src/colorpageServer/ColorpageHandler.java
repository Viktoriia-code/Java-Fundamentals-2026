package colorpageServer;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

record ColorpageHandler() implements HttpHandler {
    @Override public void handle(HttpExchange httpExchange) throws IOException {
        // 1.
        final String resource = httpExchange.getRequestURI().getPath();
        final String[] words = resource.split("/");

        // 2.
        String page = """
                      <html>
                        <head>
                            <title>Color Page Service</title>
                        </head>
                        <body style="background-color: rgb(RRR,GGG,BBB);">
                        </body>
                      </html>
                      """
                .replace("RRR", words[2])
                .replace("GGG", words[3])
                .replace("BBB", words[4]);

        // 3.
        httpExchange.sendResponseHeaders(200, 0);

        // 4.
        final OutputStream body = httpExchange.getResponseBody();
        body.write(page.getBytes());
        body.close();
    }
}
