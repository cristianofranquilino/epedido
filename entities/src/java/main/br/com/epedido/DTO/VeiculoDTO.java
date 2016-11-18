package br.com.epedido.DTO;


public class VeiculoDTO {

	private Long id;
	private String placa;
	private boolean ativo;
	private TipoVeiculoDTO tipo;

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
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	public TipoVeiculoDTO getTipo() {
		return tipo;
	}
	public void setTipo(TipoVeiculoDTO tipo) {
		this.tipo = tipo;
	}	
}
