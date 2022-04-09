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
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.com.loja.dao.UsuarioDao;
import br.com.loja.model.Usuario;

@Controller
@Path("cadastrar")
public class CadastrarController {
	
	
	@Inject Result result;
	@Inject UsuarioDao usuarioDao;
	@Inject Validator validador;
	@Inject HttpSession session;
    // Definindo nosso Controller
	@Get("")
	public void cadastrar() {
		
	}
	
	// Metodo para 
	@IncludeParameters
	@Post("salvaUsuario")
	public void salvaUsuario( @Valid Usuario usuario , String confirmaSenha) {
		//Em casos de erro, irá redirecionar para a página de form	
		//result.include("usuarioSenha", usuario.getSenha());
	    //result.include("usuarioEmail", usuario.getEmail());
		//result.include("usuarioNome", usuario.getNome());
		boolean senhaIguais = usuario.getSenha().equals(confirmaSenha);
	    validador.ensure(senhaIguais, new SimpleMessage("erro","Os campos de senha não correspondem")); // Ensure Senao
		validador.onErrorRedirectTo(this).cadastrar();
		usuarioDao.insert(usuario);
		session.setAttribute("usuarioLogado", usuario);
		result.redirectTo(ProdutosController.class).produtos();
		System.out.println("===============Informações do usuário=====================");
		 System.out.println("Nome do usuario:" + usuario.getNome());
		 System.out.println("Email do usuario:" + usuario.getEmail());
		 System.out.println("Senha do usuario:" + usuario.getSenha());
		 System.out.println("=========================================================");
		 
		 
		  
	  
	  
	}
	
	
}
