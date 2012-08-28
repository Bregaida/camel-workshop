package br.com.concretesolutions.workshops.camel.services;

import br.com.concretesolutions.workshops.camel.model.Produto;

public interface ServicoEstoque {
	
	
	public Produto checarDisponibilidade(Produto produto);

}
