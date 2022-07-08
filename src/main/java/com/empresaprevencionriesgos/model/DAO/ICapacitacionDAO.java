package com.empresaprevencionriesgos.model.DAO;

import java.util.List;

import com.empresaprevencionriesgos.model.CapacitacionDTO;

public interface ICapacitacionDAO {

    //Optional<T> get(long id);
    
	public List<CapacitacionDTO> getAll();
	
	public List<CapacitacionDTO> getFilterCliente(String rut);
    
	public boolean save(CapacitacionDTO capacitacion);
    
    //void update(T t, String[] params);
    
    //void delete(T t);
}
