package br.com.epedido.converter;

import br.com.epedido.DTO.TipoVeiculoDTO;
import br.com.epedido.model.TipoVeiculo;

public class TipoVeiculoConverter extends GenericConverter<TipoVeiculoDTO, TipoVeiculo> {

	@Override
	public TipoVeiculoDTO toSingleDto(TipoVeiculo model) {
		if (model == null) return null;
		
		TipoVeiculoDTO dto = new TipoVeiculoDTO();
		dto.setId(model.getId());
		dto.setDescricao(model.getDescricao());
		dto.setAtivo(model.getAtivo() == 0);
		
		return dto;
	}

	@Override
	public TipoVeiculo toSingleModel(TipoVeiculoDTO dto) {	
		if (dto == null) return null;
		
		TipoVeiculo model = new TipoVeiculo();
		model.setId(dto.getId());
		model.setDescricao(dto.getDescricao());
		model.setAtivo((dto.isAtivo() ? 0 : 1));
		return model;
	}

	
	
}
