package com.empresaprevencionriesgos.model.DAO;

import java.util.List;

import com.empresaprevencionriesgos.model.UsuarioDTO;

public interface IUsuarioDAO {

	public UsuarioDTO get(String nick, String password1, int perfil);
    
    public List<UsuarioDTO> getAll();
    
    //void save(T t);
    
    //void update(T t, String[] params);
    
    boolean delete(String rut);
}
