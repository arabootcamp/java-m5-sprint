package com.empresaprevencionriesgos.model.DAO;

import com.empresaprevencionriesgos.model.ProfesionalDTO;

public interface IProfesionalDAO {

	public ProfesionalDTO get(String rut);

	//public List<ProfesionalDTO> getAll();

	public boolean save(ProfesionalDTO profesional);

	public boolean update(ProfesionalDTO profesional);

	//public void delete(ProfesionalDTO profesional);
}
