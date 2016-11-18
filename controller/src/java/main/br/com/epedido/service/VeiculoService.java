package br.com.epedido.service;

import java.util.List;

import javax.inject.Inject;

import br.com.epedido.DTO.TipoVeiculoDTO;
import br.com.epedido.DTO.VeiculoDTO;
import br.com.epedido.converter.TipoVeiculoConverter;
import br.com.epedido.converter.VeiculoConverter;
import br.com.epedido.dao.VeiculoDAO;
import br.com.epedido.utils.Utils;

public class VeiculoService {
	@Inject
	private VeiculoDAO dao;
	
	@Inject
	private VeiculoConverter converter;
	
	@Inject
	private TipoVeiculoConverter TipoVeiculoConverter;
	
	
	public List<VeiculoDTO> getAll(){
		return converter.toListDto(dao.getAtivos());
	}
	
	public List<VeiculoDTO> getByTipo(TipoVeiculoDTO tipoVeiculoDto){
		return converter.toListDto(dao.getByTipo(TipoVeiculoConverter.toSingleModel(tipoVeiculoDto)));
	}

	public void persistir(VeiculoDTO dto) {
		if (Utils.isValido(dto)){
			if (Utils.isValido(dto.getId())){
				dao.update(converter.toSingleModel(dto));
			}else{
				dao.create(converter.toSingleModel(dto));
			}
		}
	}

	public void deletar(VeiculoDTO dto) {
		if (Utils.isValido(dto)){
			dto.setAtivo(false);
			dao.update(converter.toSingleModel(dto));
		}
	}	
}
