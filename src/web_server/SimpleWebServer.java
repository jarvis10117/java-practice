package web_server;



import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;

public class SimpleWebServer {

    public static void main(String[] args) throws IOException {
        // 1. Create a server that listens on port 8080
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        // 2. Map URL routes to specific handlers
        server.createContext("/", new RootHandler());
        server.createContext("/advice", new AdviceHandler());

        // 3. Use default executor and start the server
        server.setExecutor(null);
        System.out.println("Web server running on http://localhost:8080/");
        server.start();
    }

    // Handles requests to http://localhost:8080/
    static class RootHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String response = "<h1>Welcome to my Plain Java Web Server!</h1><p>Try visiting <a href='/advice'>/advice</a></p>";
            sendResponse(exchange, response, 200);
        }
    }

    // Handles requests to http://localhost:8080/advice
    static class AdviceHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String response = "<h1>Daily Advice</h1><p>Take smaller bites and keep coding!</p>";
            sendResponse(exchange, response, 200);
        }
    }

    // Helper method to write HTTP response headers and body
    private static void sendResponse(HttpExchange exchange, String responseText, int statusCode) throws IOException {
        byte[] bytes = responseText.getBytes(StandardCharsets.UTF_8);
        exchange.getResponseHeaders().set("Content-Type", "text/html; charset=UTF-8");
        exchange.sendResponseHeaders(statusCode, bytes.length);

        try (OutputStream os = exchange.getResponseBody()) {
            os.write(bytes);
        }
    }
}
