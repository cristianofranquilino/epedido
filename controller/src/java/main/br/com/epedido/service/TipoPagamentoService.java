package br.com.epedido.service;

import java.util.List;

import javax.inject.Inject;

import br.com.epedido.DTO.TipoPagamentoDTO;
import br.com.epedido.converter.TipoPagamentoConverter;
import br.com.epedido.dao.TipoPagamentoDAO;
import br.com.epedido.utils.Utils;

public class TipoPagamentoService {

	@Inject
	private TipoPagamentoDAO dao;
	
	@Inject
	private TipoPagamentoConverter converter;
	
	public List<TipoPagamentoDTO> getAll(){
		List<TipoPagamentoDTO> listDto = converter.toListDto(dao.getAtivos());
		return listDto;
	}

	public void persistir(TipoPagamentoDTO dto) {
		if (Utils.isValido(dto)){
			if (Utils.isValido(dto.getId())){
				dao.update(converter.toSingleModel(dto));
			}else{
				dao.create(converter.toSingleModel(dto));
			}
		}
	}

	public void inativar(TipoPagamentoDTO dto) {
		if (Utils.isValido(dto)){
			dto.setAtivo(false);
			dao.update(converter.toSingleModel(dto));
		}
	}	
}
