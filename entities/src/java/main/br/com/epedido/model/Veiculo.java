package br.com.epedido.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name="TB_VEICULO")
@Entity
public class Veiculo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7038350424390258567L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_VEICULO")
	private Long id;
	
	@Column(name="DE_PLACA")
	private String placa;
	
	@Column(name="LG_ATIVO")
	private int ativo;
	
	@ManyToOne
	@JoinColumn(name="ID_TIPO_VEICULO")
	private TipoVeiculo tipo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public int getAtivo() {
		return ativo;
	}

	public void setAtivo(int ativo) {
		this.ativo = ativo;
	}

	public TipoVeiculo getTipo() {
		return tipo;
	}

	public void setTipo(TipoVeiculo tipo) {
		this.tipo = tipo;
	}
	
	
	
	
}
