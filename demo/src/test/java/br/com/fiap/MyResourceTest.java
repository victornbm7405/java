/*
package br.com.fiap;

import br.com.fiap.Main;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyResourceTest {

    private Client client;

    @BeforeEach
    public void setUp() {
        Main.startServer(); // Inicia o servidor antes de cada teste
        client = ClientBuilder.newClient();
    }

    @AfterEach
    public void tearDown() {
        client.close();
    }

    @Test
    public void testCriarMensagem() {
        String json = "{ \"nomeCompleto\": \"João Silva\", \"email\": \"joao@teste.com\", \"telefone\": \"123456789\", \"motivoContato\": \"Teste\" }";

        Response response = client.target(Main.BASE_URI)
                .path("mensagens")
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(json, MediaType.APPLICATION_JSON));

        assertEquals(Response.Status.CREATED.getStatusCode(), response.getStatus());
    }
}
*/
