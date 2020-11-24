<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gestión de Facturas</title>
</head>
<body>

	<form action="/sgrc/CreateBillHead" Method="post">
		<input type="text" name="hea_subtotal" value="100.0">
		<input type="text" name="hea_vat" value="10.0">
		<input type="text" name="hea_total" value="110.0">
		<input type="submit" value="Enviar">
	</form>

</body>
</html>