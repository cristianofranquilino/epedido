package br.com.epedido.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TA_TIPO_PAGAMENTO")
public class TipoPagamento implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	@Column(name="ID_TIPO_PAGAMENTO")
	private Long id;
	
	@Column(name="DE_TIPO_PAGAMENTO")
	private String descricao;
	
	@Column(name="LG_ATIVO")
	private int ativo;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getAtivo() {
		return ativo;
	}

	public void setAtivo(int ativo) {
		this.ativo = ativo;
	}

	private static final long serialVersionUID = 4903588729842791600L;
	
}
