package br.com.concretesolutions.workshops.camel.processors;

import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import br.com.concretesolutions.workshops.camel.model.Pedido;
import br.com.concretesolutions.workshops.camel.model.Produto;

public class CompoePedido implements Processor{

	@Override
	public void process(Exchange exchange) throws Exception {
		List<Produto> produtos = exchange.getIn().getBody(List.class);
		Pedido pedido = new Pedido();
		pedido.setProdutos(produtos);
		
		exchange.getIn().setBody(pedido);
	}

}
