package br.com.concretesolutions.workshops.camel.processors;

import java.util.Collection;
import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;

import br.com.concretesolutions.workshops.camel.model.Produto;

public class AgregadorProdutos implements AggregationStrategy{

	@Override
	public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
		if (oldExchange == null)
			return newExchange;
		else {
			List<Produto> produtos = oldExchange.getIn().getBody(List.class);
			produtos.addAll(newExchange.getIn().getBody(Collection.class));
			return oldExchange;
		}
	}
	
	

}
