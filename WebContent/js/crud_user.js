/**
 * 
 */

// User Register Validations
$(function(){
	 $.validator.addMethod("valueNotEquals", function(value, element, arg){
	  	return arg !== value;
	 }, "Seleccione una opción");

	$("#user-form").validate({
		rules:{
			use_name: {
				required: true
			},
			use_lastname: {
				required: true
			},
			use_email:{
				required: true,
				email: true
			},
			use_username: {
				required: true
			},
			use_password: {
				required: true,
				minlength: 3,
				maxlength: 16
			},
			use_password_conf: {
				required: true,
				equalTo: "#use_password"
			}
			, com_id:{
				valueNotEquals: "NaN"
			}
		},
		messages: {
			use_name: "Ingrese su nombre",
			use_lastname: "Ingrese su apellido",
			use_password: {
				required: "Ingrese una contraseña",
				minlength: "Su contraseña debe tener mínimo 8 caracteres"
			},
			use_password_conf: {
				required: "Repita la contraseña",
				equalTo: "Las contraseñas no coinciden"
			},
			use_email: "Ingrese su correo electrónico",
			use_username: "Ingrese un nombre de usuario",
			com_id: {
				valueNotEquals: "Seleccione una Empresa"
			}
		}
	});
});

function valid(f){
	var isvalid = f.valid();
	return isvalid;
}

function createUser(f_id){
    var form = $("#" + f_id);
	if(valid(form)){
		$.post("/sgrc/CreateUser", form.serialize(), function(res, est, jqXHR){
			var msg = res.split("&", 2);
			showNotice(msg[0], msg[1])
		});
		// Ejemplo de los mensajes que tiene que regresar del Servlet
		//var res = "Se registró correctamente&e_notice_sucess"
		//var msg = res.split("&", 2);
		//showNotice(msg[0], msg[1])
	} else {
		showNotice("Complete los campos resaltados en rojo", "e_notice_warning")
	}
}