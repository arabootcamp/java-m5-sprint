package com.empresaprevencionriesgos.model.DAO;

import java.util.List;

import com.empresaprevencionriesgos.model.ContactoDTO;

public interface IContactoDAO {

    //Optional<T> get(long id);
    
    //List<T> getAll();
    
    public boolean save(ContactoDTO contacto);
    
    //void update(T t, String[] params);
    
    //void delete(T t);
    public List<String> getDataContacto(ContactoDTO contacto);
}
