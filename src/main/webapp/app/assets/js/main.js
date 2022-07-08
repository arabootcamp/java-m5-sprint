/**
 * 
 */
 
// Permite la visualización de calendario de input de formulario de crear usuario.

$(function() {
  $('input[name="birthday"]').daterangepicker({
	 language : 'es',
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
    maxYear: parseInt(moment().format('YYYY'),10)
  });
});

// Remueve y agrega la clase para activar con diferencia de color el navegador de la página web.

 $(function () {
  // this will get the full URL at the address bar
  var url = window.location.href;
  // passes on every "a" tag
  $(".navbar-nav .nav-link").each(function () {
    // checks if its the same on the address bar
    if (url == (this.href)) {
      $(this).closest("a").addClass("active");
      //for making parent of submenu active
      $(this).closest("a").parent().parent().addClass("active");
    }
  });
});

const agregarCalendarioElementoDOM = (element) =>{
	if (element != null) {
	$(function() {
	$( "#fecha_de_ingreso" ).daterangepicker({
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
	 });
	}
}


// Permite agregar al input de formulario editar profesional un calendario para escoger la fecha
// Dentro del elemento padre que es estático comprobamos si existe el elemento con id = "fecha_de_ingreso"
// (sólo aparece si se desea editar un usuario de tipo profesional)

const formPerfiles = document.querySelector("#form-perfiles");

const fechaIngresoProfesional = formPerfiles.querySelector("#fecha_de_ingreso");

// Llamamos a la función agregarCalendarioElementoDOM  para añadir el calendario en el input del elemento
// emergente en el DOM.
agregarCalendarioElementoDOM(fechaIngresoProfesional);