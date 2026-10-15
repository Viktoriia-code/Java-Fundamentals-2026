package server;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

record Handler() implements HttpHandler {
    public void handle(HttpExchange httpExchange) throws IOException {
        String method = httpExchange.getRequestMethod();            // GET, POST
        String resource = httpExchange.getRequestURI().getPath();   // e.g. "/info/executive/summary"

        String text = "The information you requested";

        httpExchange.sendResponseHeaders(200, 0);       // set response code 200

        OutputStream body = httpExchange.getResponseBody();
        body.write(text.getBytes());                    // optional
        body.close();                                   // mandatory!
    }
}
