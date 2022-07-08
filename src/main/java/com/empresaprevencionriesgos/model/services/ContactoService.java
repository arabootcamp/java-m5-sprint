package com.empresaprevencionriesgos.model.services;

import java.util.ArrayList;

import com.empresaprevencionriesgos.model.ContactoDTO;
import com.empresaprevencionriesgos.model.DAO.IContactoDAO;
import com.empresaprevencionriesgos.model.DAO.inMySQL.MySQLContactoDAO;

public class ContactoService {

	private IContactoDAO contactoDao = new MySQLContactoDAO();

	public boolean addContacto(ContactoDTO contacto) {

		if (contactoDao.save(contacto)) {
			return true;
		} else {
			return false;
		}
	}
	
	public void showDataContacto (ContactoDTO contacto) {
		ArrayList<String> dataContacto = (ArrayList<String>) contactoDao.getDataContacto(contacto);
		
		System.out.println("Información sobre el mensaje de contacto enviado : ");
		System.out.println("Nombre completo : " + dataContacto.get(0) + " " + dataContacto.get(1));
		System.out.println("email : " + dataContacto.get(2));
		System.out.println("Compañía/Organización : " + dataContacto.get(3));
		System.out.println("Mensaje : " + dataContacto.get(4));
	}
}
