package br.com.concretesolutions.workshops.camel.processors;

import javax.annotation.PostConstruct;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.orm.jpa.JpaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.concretesolutions.workshops.camel.model.Produto;


@Transactional
@Component("queryProcessor")
public class ProcessadorProdutos implements Processor {

	@Autowired
	private JpaTemplate jpaTemplate;
	
	private boolean initialized = false;
	
	public JpaTemplate getJpaTemplate() {
		return jpaTemplate;
	}
	
	public void setJpaTemplate(JpaTemplate jpaTemplate) {
		this.jpaTemplate = jpaTemplate;
	}
	
	
	public void init() {
		Produto produto1 = new Produto();
		produto1.setQuantidadeDisponivel(1);
		
		Produto produto2 = new Produto();
		produto2.setQuantidadeDisponivel(5);
		
		jpaTemplate.persist(produto1);
		jpaTemplate.persist(produto2);
		
		jpaTemplate.flush();
		
		initialized = true;

	}
	
	@Override
	public void process(Exchange exchange) throws Exception {
		
		Produto produto = exchange.getIn().getBody(Produto.class);
		produto = process(produto);
		exchange.getOut().setBody(produto);
		
	}
	
	public Produto process(Produto produto) {
		if (!initialized)
			init();
		return jpaTemplate.find(Produto.class, produto.getId());
				
	}

}


