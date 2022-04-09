package br.com.loja.model;

import java.text.Format;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.NotEmpty;

import br.com.olimposistema.aipa.imagem.Imagem;
import br.com.olimposistema.aipa.model.Model;



@Entity
public class Produto extends Model {
    
	
	@NotEmpty @Size( min =3, max =50 , message ="O nome do produto deve ter entre 3 e 50 carcateres")
    private String nomeProduto;
    
    @NotNull @Min(value = 1 , message ="O valor deve ser maior que 0 reias")
    private double 	precoProduto;
    
    @NotEmpty @Type(type ="text")
    private String descProduto;
    
    @ManyToOne 
    @NotNull(message ="O produto deve ter uma categoria")
    private  Categoria categoriaProduto;

	@Temporal(TemporalType.DATE)
	@NotNull(message="A data de validade não foi preenchida")
	private  Calendar dataValidade;
    
	
	@NotNull
	@OneToOne(cascade = {CascadeType.PERSIST , CascadeType.MERGE, CascadeType.REMOVE}, fetch =FetchType.EAGER , orphanRemoval = true)
	private Imagem imagem;


	 
    
    
    
    
    
    
    //Getters and setters
	public String getNomeProduto() {
		return nomeProduto;
	}


	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	
	public String getValorDinheiro() {
		
	String valorFormatado =	NumberFormat.getCurrencyInstance(new Locale("pt" , "br")).format(precoProduto);
		
		return valorFormatado;
	}

	public double getPrecoProduto() {
		return precoProduto;
	}


	public void setPrecoProduto(double precoProduto) {
		this.precoProduto = precoProduto;
	}


	public String getDescProduto() {
		return descProduto;
	}


	public void setDescProduto(String descProduto) {
		this.descProduto = descProduto;
	}


	public Categoria getCategoriaProduto() {
		return categoriaProduto;
	}


	public void setCategoriaProduto(Categoria categoriaProduto) {
		this.categoriaProduto = categoriaProduto;
	} 
	

	
	
	public Calendar getDataValidade() {
		return dataValidade;
	}
public String getDataFormatada() {
		
		String dataFormatada = new SimpleDateFormat("dd/MM/yyyy").format(dataValidade.getTime());
		return dataFormatada;
	}


	public void setDataValidade(Calendar dataValidade) {
		this.dataValidade = dataValidade;
	}
	
	public void setDataValidadeEm(String data) {
		
		if(data == null) 
			return;
		
		//Indicando o divisor 
		String[] dataDiv  = data.split("-");
		
		Integer ano = Integer.parseInt(dataDiv[0]);
		Integer mes = Integer.parseInt(dataDiv[1]);
		Integer dia = Integer.parseInt(dataDiv[2]);
		
		
		Calendar calendar = new GregorianCalendar(ano, (mes-1), dia);
		this.dataValidade = calendar; 	
	}


	public Imagem getImagem() {
		return imagem;
	}


	public void setImagem(Imagem imagem) {
		this.imagem = imagem;
	}
		
	


    
    
    
}
