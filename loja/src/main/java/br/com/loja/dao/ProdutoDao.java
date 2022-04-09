package br.com.loja.dao;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.loja.model.Produto;
import br.com.olimposistema.aipa.dao.DAO;


@RequestScoped
public class ProdutoDao extends DAO<Produto> {
     
	
	@Deprecated public ProdutoDao() {
		super (null, null);
	}
	
	
	@Inject ProdutoDao(EntityManager em){
		
		super(em , Produto.class);
		
	}
	
	
}
