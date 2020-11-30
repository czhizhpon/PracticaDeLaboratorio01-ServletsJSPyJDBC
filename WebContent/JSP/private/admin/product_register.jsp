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
    <script src="/sgrc/js/jquery.validate.min.js"></script>
    <script src="/sgrc/js/crud_product.js"></script>

    <title>Productos</title>
</head>
<body>
	<section class="container text-center col-10">
   	<div class="row justify-content-center">
    	<div class="col-xl-5 col-md-8">
    		<div class="row align-items-center">
    			<div class="col-6 p-4">
    				<h1 class="">Gestión de productos</h1>
    			</div>
	   			<div class="col-6 p-4">
	   				<img src="/sgrc/img/icons/product_icon.svg" style="width: 125px">
	   			</div>
   			</div>
   			<div id="main_notice" class="notice_container e_hidden">
   				<input type="button" onclick="hideNotice()">
                <div id="notice" class="div_notice"></div>
      		</div>
			<div class="row">
				<form action="" class="text-left form col-12" id="product-form">
					<div class="form-group ">
						<label for="pro_name">Nombre:</label>
						<input type="text" id="pro_name" name="pro_name" class="form-control" placeholder="Nombre">
					</div>
					<div class="form-group ">
						<label for="pro_stock">Stock:</label>
						<input type="number" id="pro_stock" name="pro_stock" class="form-control" placeholder="0" min="0" step="1" onkeypress="return isNumberKey(this, event);">	
					</div>
					<div class="form-group ">
						<label for="pro_price">Precio:</label>
						<input type="number" id="pro_price" name="pro_price" class="form-control" placeholder="0.00" min="0.00" step=".01" onkeypress="return isDecimalKey(this, event);">	
					</div>
					<div class="form-group ">
						<label for="cat_id">Categoría:</label>	
						<select name="cat_id" id="cat_id" class="form-control">
							<option value="NaN">Seleccionar</option>
					  		<option value="1">Categoría 1</option>
						  	<option value="2">Categoría 2</option>
						  	<option value="3">Categoría 3</option>
						  	<option value="4">Categoría 4</option>
						</select>
					</div>
					<input type="button" id="register" class="btn btn-primary" value="Registrar" onclick="createProduct('product-form')">
					<input type="button" id="accept"  class="btn btn-primary invisible" value="Aceptar">
	   			</form>
   			</div>
    	</div>
    	<div class="col-xl-7 col-md-12">
    		<form class="text-left main-form my-search-form" onsubmit="return false">
                <div class="row justify-content-center form-group">
                    <label for="search-heroe-input" class="col-form-label col-md-3 col-12">Buscar producto:</label>
                    <input id="search-heroe-input" name="search-heroe-input" class="form-control col-md-8 col-11" type="search" placeholder="Ingresar nombre"
                        aria-label="Search">
                    <input type="button" class="search-icon btn col-1" onclick="">
                </div>
            </form>
    		<div class="table-responsive">
			  <table class="table table-striped">
			    <thead class="thead-dark">
			      <tr>
			        <th scope="col">Nombre</th>
			        <th scope="col">Stock</th>
			        <th scope="col">Precio</th>
			        <th scope="col">Categoría</th>
			        <th scope="col"></th>
			        <th scope="col"></th>
			      </tr>
			    </thead>
			    <tbody>
			      <tr>
			        <td>Cell</td>
			        <td>Cell</td>
			        <td>Cell</td>
			        <td>Cell</td>
			        <td><a href="#" class="btn btn-info">Editar</a></td>
			        <td><a href="#" class="btn btn-danger">Eliminar</a></td>
			      </tr>
			    </tbody>
			  </table>
			</div>
    	</div>
   	</div>
   	<!-- No parar Bola -->
	<button onclick="jQuery('#aaa').load(' #aaa');">Reload</button>
	<div id="aaa"><%=new java.util.Date().toString()%></div>
	</section>
	
	
</body>
</html>