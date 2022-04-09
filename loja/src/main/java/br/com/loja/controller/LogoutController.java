package br.com.loja.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;

@Controller
@Path("logout")
public class LogoutController {
    
	@Inject HttpSession session;
	@Inject Result resultado;
	@Get("")
    public void logout() {
		
    	session.removeAttribute("usuarioLogado");
    	resultado.redirectTo(LoginController.class).login();;
    	
    	
    	
    	
	}
}
