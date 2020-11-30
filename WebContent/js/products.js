/**
 * 
 */

function isNumberKey(txt, evt) {
	var charCode = (evt.which) ? evt.which : evt.keyCode;
      
	if (charCode > 31 && (charCode < 48 || charCode > 57)){
          return false;
  	}
  	return true;
}


$(document).ready(function() {
  $('#cat_id').change(function(){
    $("#width_tmp_option").html($('#cat_id option:selected').text()); 
    $(this).width($("#width_tmp_select").width());  
  });
});