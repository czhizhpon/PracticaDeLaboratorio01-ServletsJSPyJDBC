/**
 * 
 */
function loging(f_id){
    var form = $("#" + f_id);
	$.post("/sgrc/Login", form.serialize(), function(res){
		var msg = res.split("&", 2);
		if(msg[1] == "e_notice_sucess"){
			location.href = "/sgrc/home";
		}else {
			showNotice(msg[0], msg[1]);
		}
		
		//jQuery('#user').load('/sgrc/? #user');
	});

}