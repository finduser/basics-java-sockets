package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class ClientTest {

    @Test
    void shouldServerAnswer() throws IOException {
        Client client = new Client();
        client.connect(Server.HOSTNAME, Server.PORT);
        String serverResponse = client.sendMessage(Server.HELLO);
        client.close();

        Assertions.assertEquals(Server.ANSWER, serverResponse);
    }
}
