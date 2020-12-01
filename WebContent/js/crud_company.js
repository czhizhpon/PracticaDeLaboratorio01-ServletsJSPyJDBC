/**
 * 
 */

$(function(){
	 $.validator.addMethod("valueNotEquals", function(value, element, arg){
	  	return arg !== value;
	 }, "Seleccione una opción");

	$("#company-form").validate({
		rules:{
			com_name: {
				required: true
			}
		},
		messages: {
			com_name: "Ingrese el nombre"
		}
	});
});

function valid(f){
	var isvalid = f.valid();
	return isvalid;
}

function createCompany(f_id){
	var form = $("#" + f_id);
	if(valid(form)){
		$.post("/sgrc/CreateCompany", form.serialize(), function(res, est, jqXHR){
			var msg = res.split("&", 2);
			showNotice(msg[0], msg[1]);
			jQuery('#table_company').load('/sgrc/ListCompany #table_content');
		});
		// Ejemplo de los mensajes que tiene que regresar del Servlet
		// var res = "Se registró correctamente&e_notice_sucess"
		// var msg = res.split("&", 2);
		// showNotice(msg[0], msg[1])
	} else {
		showNotice("Complete los campos resaltados en rojo", "e_notice_warning")
	}
}