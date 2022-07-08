package com.empresaprevencionriesgos.model.DAO;

import com.empresaprevencionriesgos.model.AdministrativoDTO;

public interface IAdministrativoDAO {

	public AdministrativoDTO get(String rut);
    
    //public List<AdministrativoDTO> getAll();
    
    public boolean save(AdministrativoDTO administrativo);
    
    public boolean update(AdministrativoDTO administrativo);
    
   // public void delete(AdministrativoDTO adminsitrativo);
}
