package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

class Client {
    private BufferedReader in;
    private PrintWriter out;

    private Socket socket;

    public void connect(String hostname, int port) throws IOException {
        socket = new Socket(hostname, port);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);
    }

    public String sendMessage(String message) throws IOException {
        out.println(message);
        return in.readLine();

    }

    public void close() throws IOException {
        out.close();
        in.close();
        socket.close();
    }
}
