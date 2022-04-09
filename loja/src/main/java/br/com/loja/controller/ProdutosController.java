package br.com.loja.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.loja.dao.ProdutoDao;
import br.com.loja.interceptors.SomenteLogado;
import br.com.loja.model.Produto;

@Controller
@Path("produtos")
public class ProdutosController {
	
	
	
	//Injects 
	
	
	@Inject HttpSession session;
	
	@Inject Result resultado;
	
	@Inject ProdutoDao produtoDao;
	
	
	
	
	
      @Get("")
      public void produtos() {
    	  
    	 List<Produto> produtos = produtoDao.selectAll();
    	 
    	 resultado.include("produtos", produtos);
    	
    	  
      }
}
