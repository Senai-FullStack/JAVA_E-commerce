package br.com.loja.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.loja.dao.CategoriaDao;
import br.com.loja.interceptors.SomenteLogado;
import br.com.loja.model.Categoria;

@Controller
@Path("categoria")
public class CategoriaController {
	
	@Inject HttpSession session;
	@Inject Result resultado;
	@Inject CategoriaDao categoriaDao;
	
	
	@Get("") @SomenteLogado
      public void categoria() {
    	  
		
		List<Categoria> categorias = categoriaDao.selectAll();
		
		//Disponibilizar no jsp
		
		
		resultado.include("categorias", categorias);
	
      
}
}
