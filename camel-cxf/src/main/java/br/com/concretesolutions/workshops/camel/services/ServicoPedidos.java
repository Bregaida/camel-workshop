package br.com.concretesolutions.workshops.camel.services;

import br.com.concretesolutions.workshops.camel.model.Pedido;
import br.com.concretesolutions.workshops.camel.model.PedidoRecusadoException;

public interface ServicoPedidos {
	
	
	public Pedido criarPedido (Pedido pedido) throws PedidoRecusadoException;

}
