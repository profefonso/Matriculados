$(document).ready(function() {
	$("#btnConsulta").click(function () {
        if($("#sel_estudiante").val()==""){
        	alert("Seleccione un Estudiante");
        }else{
        	$("#frm_inicio").submit();
        }
    });
	
	$("#btm_new_matricula").click(function () {
        if(isNaN($("#nota_numerica").val())){
        	alert("Ingrese Una Nota Valida [0 - 5]");
        }else{
        	if($("#nota_numerica").val() >=0 && $("#nota_numerica").val()<=5){
        		$("#frm_addmatricula").submit();
        	}else{
        		alert("Ingrese Una Nota Valida [0 - 5]");
        	}
        }
    });
	
	$("#update_nota").click(function () {
        if(isNaN($("#nota_numerica_edit").val())){
        	alert("Ingrese Una Nota Valida [0 - 5]");
        }else{
        	if($("#nota_numerica_edit").val() >=0 && $("#nota_numerica_edit").val()<=5){
        		$("#frm_edit_nota").submit();
        	}else{
        		alert("Ingrese Una Nota Valida [0 - 5]");
        	}
        }
    });
});