package br.com.loja.dao;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.loja.model.Categoria;
import br.com.olimposistema.aipa.dao.DAO;

@RequestScoped
public class CategoriaDao extends DAO<Categoria> {
      
	@Deprecated public CategoriaDao() {
		super(null , null);
	}
	
	@Inject
	public CategoriaDao(EntityManager em) {
		super(em, Categoria.class);
	}
	
	
}
