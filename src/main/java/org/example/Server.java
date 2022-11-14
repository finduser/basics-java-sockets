package org.example;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

class Server {
    public static final int PORT = 5525;
    public static final String HOSTNAME = "127.0.0.1";
    public static final String ANSWER = "Hello from server";
    public static final String HELLO = "hello";
    private final Logger logger = Logger.getLogger(Server.class.getName());
    private BufferedReader in;
    private PrintWriter out;

    public void start() {
        try(ServerSocket serverSocket = new ServerSocket(PORT)) {
            Socket acceptedConnection = serverSocket.accept();
            in = new BufferedReader(new InputStreamReader(acceptedConnection.getInputStream()));
            out = new PrintWriter(acceptedConnection.getOutputStream(), true);

            String messageFromClient = in.readLine();
            logger.log(Level.INFO, "Message from client: {0}", messageFromClient);


            if(HELLO.equalsIgnoreCase(messageFromClient)) {
                logger.info("Answering...");
                out.println(ANSWER);
            }
        } catch (IOException e) {
            logger.warning("An error has occurred on the server side after connection attempt.");
            logger.warning(e.getMessage());
        }
    }

    public static void main(String[] args) {
       Server server = new Server();
       server.start();
    }
}
