package br.com.epedido.converter;

import br.com.epedido.DTO.TipoPagamentoDTO;
import br.com.epedido.model.TipoPagamento;

public class TipoPagamentoConverter extends GenericConverter<TipoPagamentoDTO, TipoPagamento > {

	@Override
	public TipoPagamentoDTO toSingleDto(TipoPagamento model) {
		
		if (model == null) return null;
		
		TipoPagamentoDTO dto = new TipoPagamentoDTO();
		dto.setId(model.getId());
		dto.setDescricao(model.getDescricao());
		dto.setAtivo(model.getAtivo() == 0);
		
		return dto;
	}

	@Override
	public TipoPagamento toSingleModel(TipoPagamentoDTO dto) {
		if (dto == null) return null;
		
		TipoPagamento model = new TipoPagamento();
		model.setId(dto.getId());
		model.setDescricao(dto.getDescricao());
		model.setAtivo((dto.isAtivo() ? 0 : 1));
		
		return model;
	}

}
