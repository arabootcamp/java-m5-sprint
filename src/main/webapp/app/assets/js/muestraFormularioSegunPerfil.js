/**
 *
 */
 
// Incluye en formulario de crear usuario cliente el atributo de requerido.

const incluirRequiredFormularioCliente = (incluir) => {
	let form = document.getElementById('form__crear-usuario');
	/* email, afp_id, sistema_salud_id, organizacion son campos obligatorios*/
	if (incluir) {
		form.elements.email.setAttribute('required', incluir);
		form.elements.afp_id.setAttribute('required', incluir);
		form.elements.sistema_salud_id.setAttribute('required', incluir);
		form.elements.organizacion.setAttribute('required', incluir);
	} else {
		form.elements.email.removeAttribute('required');
		form.elements.email.removeAttribute('required');
		form.elements.afp_id.removeAttribute('required');
		form.elements.sistema_salud_id.removeAttribute('required');
		form.elements.organizacion.removeAttribute('required');
	}
}
	
// Muestra el formulario correspondiente del tipo de usuario de acuerdo a la 
// opción escogida rescatada del login.

const activarFormularioPerfil = (perfil_id) => {
	let formAdministrativo = document.getElementById('form__administrativo');
	let formCliente = document.getElementById('form__cliente');
	let formProfesional = document.getElementById('form__profesional');

	if (perfil_id == 1) {
		formAdministrativo.className = 'd-block';
		formCliente.className = 'd-none';
		formProfesional.className = 'd-none';
		incluirRequiredFormularioCliente(false);
		return;
	}

	if (perfil_id == 2) {
		formCliente.className = 'd-block';
		formAdministrativo.className = 'd-none';
		formProfesional.className = 'd-none';
		incluirRequiredFormularioCliente(true);
		return;
	}

	if (perfil_id == 3) {
		formProfesional.className = 'd-block';
		formCliente.className = 'd-none';
		formAdministrativo.className = 'd-none';
		$('input[name="fecha_de_ingreso"]').daterangepicker({
			language: 'es',
			locale: {
				format: 'DD-MM-YYYY',
				"daysOfWeek": [
					"Dom",
					"Lun",
					"Mar",
					"Mie",
					"Jue",
					"Vie",
					"Sab"
				],
			},
			singleDatePicker: true,
			showDropdowns: true,
			minYear: 1901,
			maxYear: parseInt(moment().format('YYYY'), 10)
		});
		incluirRequiredFormularioCliente(false);
		return;
	}

	formProfesional.className = 'd-none';
	formCliente.className = 'd-none';
	formAdministrativo.className = 'd-none';
}

// cambio el formulario según el tipo perfil

let inputRadioPerfiles = document.getElementsByClassName("form-check-input");


for (let i = 0; i < inputRadioPerfiles.length; i++) {
	//en la carga valido quien es checked
	if (inputRadioPerfiles[i].checked) activarFormularioPerfil(inputRadioPerfiles[i].value);

	//añado evento
	inputRadioPerfiles[i].addEventListener('change', e => { e.target.checked && activarFormularioPerfil(e.target.value); });
}


