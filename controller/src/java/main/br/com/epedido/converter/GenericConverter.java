package br.com.epedido.converter;

import java.util.ArrayList;
import java.util.List;

public abstract class GenericConverter<D, M> {
	
	public List<D> toListDto(List<M> models){
		
		List<D> dtos = new ArrayList<>(); 
		
		for (M m : models) {
			dtos.add(toSingleDto(m));
		}
		return dtos;
	}

	public List<M> toListModel(List<D> dtos){
		
		List<M> models = new ArrayList<>(); 
		
		for (D d : dtos) {
			models.add(toSingleModel(d));
		}
		return models;
	}
	
	public abstract D toSingleDto(M model);
	public abstract M toSingleModel(D dto);
}
