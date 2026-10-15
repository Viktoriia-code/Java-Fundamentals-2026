package clocktimeServer;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.time.LocalTime;

record ClockpageHandler() implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        byte[] response = LocalTime.now().toString().getBytes(StandardCharsets.UTF_8);
        exchange.sendResponseHeaders(200, response.length);

        try (OutputStream body = exchange.getResponseBody()) {
            body.write(response);
        }
    }
}
