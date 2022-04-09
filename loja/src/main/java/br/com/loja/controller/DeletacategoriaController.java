package br.com.loja.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.loja.dao.CategoriaDao;
import br.com.loja.interceptors.SomenteLogado;
import br.com.loja.model.Categoria;

@Controller
@Path("deletaCategoria")

public class DeletacategoriaController {
    
	//Metodo que apaga as categorias adicionadas
	
	@Inject CategoriaDao categoriaDao;
	@Inject Result resultado;
	
	@Get("/{categoria.id}") @SomenteLogado
    public void deletaCategoria(Categoria categoria) {
		
		System.out.println("teste");
         	categoriaDao.delete(categoria);
         	System.out.println("teste");
         	resultado.redirectTo(CategoriaController.class).categoria();
         	System.out.println("#################################################################");
         	
    	
    	
	}
	
}
