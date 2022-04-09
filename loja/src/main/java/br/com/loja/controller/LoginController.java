package br.com.loja.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.hibernate.validator.constraints.NotEmpty;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.com.loja.dao.UsuarioDao;
import br.com.loja.model.Usuario;


//Definindo o controlador do nosso App
@Controller	

  
  @Path("login")
public class LoginController {
	
	@Inject Validator validador;
    @Inject Result resultado; 
	@Inject UsuarioDao usuarioDao;
	@Inject HttpSession session;
	
	@Get("")     
     public void login() {
    	 System.out.println("Entrou em login");
     }
	
		
	@Post("autenticarUsuario") //
	
	public void autenticarUsuario( @NotEmpty(message="O campo do email não pode estar vazio") String email,		
	@NotEmpty(message="O campo senha não pode estar vazio!!")  String senha) {
		
		
		validador.onErrorRedirectTo(this).login();		
	    //Autentica Usuario
		
	
		 Usuario usuario = usuarioDao.existeUsuarioCom(email,senha);
		 
		 session.setAttribute("usuarioLogado", usuario);
		 
		validador.addIf(usuario == null, new SimpleMessage( "erro" , "Email ou senha incorretos"));
		 validador.onErrorRedirectTo(this).login();
		
		resultado.redirectTo(ProdutosController.class).produtos();  
		System.out.println("Email" + email);
		System.out.println("Senha" + senha);	
		
	
		
	}
	
}
