package br.com.alura.loja.resource;

import java.net.URI;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.thoughtworks.xstream.XStream;

import br.com.alura.loja.dao.CarrinhoDAO;
import br.com.alura.loja.modelo.Carrinho;

@Path("carrinhos")
public class CarrinhoResource {
	@Path("{id}")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public String busca(@PathParam("id") long id){
		CarrinhoDAO dao = new CarrinhoDAO();
		Carrinho carrinho = dao.busca(id);
		return carrinho.toXml();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	public Response adiciona(String conteudo){
		Carrinho carrinho = (Carrinho) new XStream().fromXML(conteudo);
		new CarrinhoDAO().adiciona(carrinho);
		URI location = URI.create("/carrinhos/"+carrinho.getId());
		return Response.created(location).build();
	}
	@DELETE
	@Path("{id}/produtos/{produtoId}")
	public Response remove(@PathParam("id") long id, @PathParam("produtoId") long produtoId){
		CarrinhoDAO dao = new CarrinhoDAO();
		Carrinho carrinho = dao.busca(id);
		carrinho.remove(produtoId);
		return Response.ok().build();
	}
}
