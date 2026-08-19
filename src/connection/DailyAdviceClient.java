package connection;

import java.io.*;
import java.net.InetSocketAddress;
import java.nio.channels.Channels;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

public class DailyAdviceClient {

    public void go() {
        // Match the server port (5001)
        InetSocketAddress serverAddress = new InetSocketAddress("localhost", 5001);

        try (SocketChannel socketChannel = SocketChannel.open(serverAddress);
             Reader channelReader = Channels.newReader(socketChannel, StandardCharsets.UTF_8);
             BufferedReader reader = new BufferedReader(channelReader)) {

            String advice = reader.readLine();
            System.out.println("Today you should: " + advice);

        } catch (IOException e) {
            System.err.println("Could not connect to server. Make sure DailyAdviceServer is running first!");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new DailyAdviceClient().go();
    }
}