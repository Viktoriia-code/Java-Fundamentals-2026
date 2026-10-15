package clocktimeServer;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalTime;

record ClockpageHandler() implements HttpHandler {
    @Override public void handle(HttpExchange httpExchange) throws IOException {
        // ignore getRequestMethod, getRequestURI
        final String text = " <html><body><h1>Time Service</h1>Current server time is: "
                + LocalTime.now() // get current system time
                + "</body></html>";
        httpExchange.sendResponseHeaders(200, 0);
        final OutputStream body = httpExchange.getResponseBody();
        body.write(text.getBytes());
        body.close();
    }
}
