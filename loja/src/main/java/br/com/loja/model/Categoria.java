package br.com.loja.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import br.com.olimposistema.aipa.model.Model;

  @Entity
public class Categoria extends Model {
     
	  
	
	@NotEmpty @Size(min = 3 , max = 50 , message = "{categoria.nome.size}" )
	private  String nomeCategoria;
  
	
	
	@OneToMany(mappedBy = "categoriaProduto")
	private List<Produto> produtos;
	
	public String getNomeCategoria() {
		return nomeCategoria;
	}
	
	

	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	} 
			
			
			
			
}
  