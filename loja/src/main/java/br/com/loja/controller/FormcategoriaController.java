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
import br.com.loja.interceptors.SomenteLogado;
import br.com.loja.model.Categoria;
import br.com.olimposistema.aipa.service.Util;

   @Controller
   
   @Path("formcategoria")
   public class FormcategoriaController {
	   
	   
	@Inject Result result;
	@Inject CategoriaDao categoriaDao;
	@Inject Validator validador;
	@Inject HttpSession session;
    @Get("")
    @SomenteLogado
    public void formcategoria(Categoria categoria) {   
    	
    	if(Util.isNotNull(categoria) && Util.isPositivo(categoria.getId())) {
    		
    		Categoria categoriaDoBanco = categoriaDao.selectPorId(categoria);
    		result.include("categoria",categoriaDoBanco);
    		
    	}
    	
    }
    
    
    //Metodo para salvarCategoria
    
    @IncludeParameters
    @Post("salvaCategoria")
    public void salvaCategoria(@Valid Categoria categoria) {
    	
    	validador.onErrorRedirectTo(this).formcategoria(categoria);
    	categoriaDao.insertOrUpdate(categoria);
    	result.redirectTo(CategoriaController.class).categoria();	
    }
    
}
