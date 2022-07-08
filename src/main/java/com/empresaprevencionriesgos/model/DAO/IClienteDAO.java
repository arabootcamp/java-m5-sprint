package com.empresaprevencionriesgos.model.DAO;

import com.empresaprevencionriesgos.model.ClienteDTO;

public interface IClienteDAO {

    public ClienteDTO get(String rut);
    
    //public List<ClienteDTO> getAll();
    
    public boolean save(ClienteDTO cliente);//crear
    
    public boolean update(ClienteDTO cliente);
    
    //public void delete(String rut);
}
