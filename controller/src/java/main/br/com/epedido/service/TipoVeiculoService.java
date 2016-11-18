package br.com.epedido.service;

import java.util.List;

import javax.inject.Inject;

import br.com.epedido.DTO.TipoVeiculoDTO;
import br.com.epedido.converter.TipoVeiculoConverter;
import br.com.epedido.dao.TipoVeiculoDAO;
import br.com.epedido.utils.Utils;

public class TipoVeiculoService {

	@Inject
	private TipoVeiculoDAO dao;
	
	@Inject
	private TipoVeiculoConverter converter;
	
	public List<TipoVeiculoDTO> getAll(){
		return converter.toListDto(dao.getAtivos());
	}

	public void persistir(TipoVeiculoDTO dto) {
		if (Utils.isValido(dto)){
			if (Utils.isValido(dto.getId())){
				dao.update(converter.toSingleModel(dto));
			}else{
				dao.create(converter.toSingleModel(dto));
			}
		}
	}

	public void deletar(TipoVeiculoDTO dto) {
		if (Utils.isValido(dto)){
			dto.setAtivo(false);
			dao.update(converter.toSingleModel(dto));
		}
	}	
	
}
