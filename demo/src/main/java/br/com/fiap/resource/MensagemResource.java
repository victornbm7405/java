package br.com.fiap.resource;

import br.com.fiap.model.Mensagem;
import br.com.fiap.model.MensagemTO;
import br.com.fiap.dao.MensagemDAO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/mensagens")
public class MensagemResource {

    private MensagemDAO mensagemDAO = new MensagemDAO();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response criarMensagem(MensagemTO mensagemTO) {
        // Converte MensagemTO para Mensagem
        Mensagem mensagem = new Mensagem(
                mensagemTO.getNomeCompleto(),
                mensagemTO.getEmail(),
                mensagemTO.getTelefone(),
                mensagemTO.getMotivoContato()
        );

        mensagemDAO.salvar(mensagem); // Salva a mensagem no banco de dados
        return Response.status(Response.Status.CREATED).entity(mensagem).build();
    }
}
