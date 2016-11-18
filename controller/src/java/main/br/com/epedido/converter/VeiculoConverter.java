package br.com.epedido.converter;

import javax.inject.Inject;

import br.com.epedido.DTO.VeiculoDTO;
import br.com.epedido.model.Veiculo;

public class VeiculoConverter extends GenericConverter<VeiculoDTO, Veiculo> {

	@Inject
	private TipoVeiculoConverter tipoVeiculoConverter;
	
	@Override
	public VeiculoDTO toSingleDto(Veiculo model) {
		
		VeiculoDTO dto = new VeiculoDTO();
		
		dto.setId(model.getId());
		dto.setPlaca(model.getPlaca());
		dto.setTipo(tipoVeiculoConverter.toSingleDto(model.getTipo()));
		dto.setAtivo(model.getAtivo() == 0);
		return dto;
	}

	@Override
	public Veiculo toSingleModel(VeiculoDTO dto) {
		Veiculo model = new Veiculo();
		
		model.setId(dto.getId());
		model.setPlaca(dto.getPlaca());
		model.setTipo(tipoVeiculoConverter.toSingleModel(dto.getTipo()));
		model.setAtivo(dto.isAtivo() ? 0 : 1 );
		return model;
	}

}
