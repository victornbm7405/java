package br.com.fiap;

import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;
import java.net.URI;

public class App {
    public static final String BASE_URI = "http://localhost:8080/api/";

    public static void startServer() {
        // Configura o ResourceConfig para escanear as classes de recurso (endpoints REST)
        final ResourceConfig rc = new ResourceConfig().packages("br.com.fiap.resource");
        // Inicia o servidor Grizzly com o URI base e a configuração de recursos
        GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
    }

    public static void main(String[] args) throws IOException {
        startServer();
        System.out.println("Servidor Grizzly iniciado em " + BASE_URI);
        System.out.println("Pressione Enter para encerrar o servidor...");
        System.in.read(); // Mantém o servidor ativo até que ENTER seja pressionado
    }
}
