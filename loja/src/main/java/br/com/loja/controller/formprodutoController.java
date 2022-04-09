 package br.com.loja.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.interceptor.IncludeParameters;
import br.com.caelum.vraptor.validator.Validator;
import br.com.loja.dao.CategoriaDao;
import br.com.loja.dao.ProdutoDao;
import br.com.loja.model.Produto;

@Controller
@Path("formproduto")
public class formprodutoController {
	
	
	@Inject Result resultado;
	@Inject ProdutoDao produtoDao;
	@Inject Validator validador;
	@Inject HttpSession session;
	@Inject CategoriaDao categoriaDao;
	
	
      @Get("")
      public void formproduto(Produto produto) {
    	  
    	 resultado.include("categorias", categoriaDao.selectAll());
    	  
      }
      
      
      @IncludeParameters
      @Post("salvaProduto")
      
    public void salvaProduto(@Valid Produto produto) {
    	  
    	  
    
    	  validador.onErrorRedirectTo(this).formproduto(produto); 
    	  produtoDao.insert(produto);
    	  resultado.redirectTo(ProdutosController.class).produtos();
    	  
    	  
    	  
      }
    
}
