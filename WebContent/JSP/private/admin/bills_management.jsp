<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="stylesheet" href="/sgrc/css/bootstrap/bootstrap.min.css">
    <link rel="stylesheet" href="/sgrc/css/products.css">
    <link rel="stylesheet" href="/sgrc/css/main.css">
    <link rel="stylesheet" href="/sgrc/css/my_forms.css">

    <script src="/sgrc/js/bootstrap/jquery-3.5.1.min.js"></script>
    <script src="/sgrc/js/bootstrap/popper.min.js"></script>
    <script src="/sgrc/js/bootstrap/bootstrap.min.js"></script>
    
    <script src="/sgrc/js/functions.js"></script>
    <script src="/sgrc/js/bill.js"></script>

    <title>Usuarios</title>
</head>
<body class="">
   <section class="container text-center col-11">
   	<div class="row justify-content-center">
    	<div class="col-xl-6 col-lg-12">
    		<form class="text-left main-form my-search-form" onsubmit="return false">
                <div class="row justify-content-center form-group">
                    <label for="search-heroe-input" class="col-form-label col-md-3 col-12">Buscar Factura:</label>
                    <input id="search-heroe-input" name="search-heroe-input" class="form-control col-md-8 col-11" type="date">
                    <input type="button" class="search-icon btn col-1" onclick="">
                </div>
            </form>
    		<div class="table-responsive">
			  <table class="table table-striped">
			    <thead class="thead-dark">
			      <tr>
			      	<th scope="col">Correo</th>
			      	<th scope="col">Fecha</th>
			        <th scope="col">Subtotal</th>
			        <th scope="col">IVA</th>
			        <th scope="col">Total</th>
			        <th scope="col">Detalle</th>
			        <th scope="col" colspan="2">Acciones</th>
			      </tr>
			    </thead>
			    <tbody>
			      <tr>
			        <td>Cell</td>
			        <td>Cell</td>
			        <td>Cell</td>
			        <td>Cell</td>
			        <td>Cell</td>
			        <td><a href="#" class="btn btn-outline-secondary" onclick="showDetail()">Ver Detalle</a></td>
			        <td><a href="#" class="btn btn-success" role="button">Aprobar</a></td>
			        <td><a href="#" class="btn btn-danger" role="button">Rechazar</a></td>
			      </tr>
			      <tr>
			        <td>Cell</td>
			        <td>Cell</td>
			        <td>Cell</td>
			        <td>Cell</td>
			        <td>Cell</td>
			        <td><a href="#" class="btn btn-outline-secondary" onclick="showDetail()">Ver Detalle</a></td>
			        <td><a href="#" class="btn btn-success" role="button">Aprobar</a></td>
			        <td><a href="#" class="btn btn-danger" role="button">Rechazar</a></td>
			      </tr>
			      <tr>
			        <td>Cell</td>
			        <td>Cell</td>
			        <td>Cell</td>
			        <td>Cell</td>
			        <td>Cell</td>
			        <td><a href="#" class="btn btn-outline-secondary" onclick="showDetail()">Ver Detalle</a></td>
			        <td><a href="#" class="btn btn-success" role="button">Aprobar</a></td>
			        <td><a href="#" class="btn btn-danger" role="button">Rechazar</a></td>
			      </tr>
			    </tbody>
			  </table>
			</div>
    	</div>
    	<div class="col-xl-5 col-lg-10 col-10 invisible" style="position: relative; top: 25px;" id="bill-details">
    		<div class="row justify-content-end">
    			<button type="button" class="my-close-btn-circle my-table-close" onclick="hideDetail()"></button>
   			</div>
   			<div class="row">
	    		<div class="table-responsive">
				  <table class="table table-striped">
				    <thead class="thead-dark">
				      <tr>
				      	<th scope="col">Producto</th>
				      	<th scope="col">Cantidad</th>
				        <th scope="col">Precio Unitario</th>
				        <th scope="col">Total</th>
				      </tr>
				    </thead>
				    <tbody>
				      <tr>
				        <td>Cell</td>
				        <td>Cell</td>
				        <td>Cell</td>
				        <td>Cell</td>
				      </tr>
				      <tr>
				        <td>Cell</td>
				        <td>Cell</td>
				        <td>Cell</td>
				        <td>Cell</td>
				      </tr>
				      <tr>
				        <td>Cell</td>
				        <td>Cell</td>
				        <td>Cell</td>
				        <td>Cell</td>
				      </tr>
				    </tbody>
				  </table>
				</div>
			</div>
    	</div>
   	</div>
    </section>
</body>
</html>