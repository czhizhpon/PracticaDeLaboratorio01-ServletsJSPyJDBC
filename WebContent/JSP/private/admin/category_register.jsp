<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
    <script src="/sgrc/js/crud_category.js"></script>

    <title>Categorías</title>
</head>
<body>
	<section class="container text-center col-10">
   	<div class="row justify-content-center">
    	<div class="col-xl-4 col-md-12">
    		<div class="row align-items-center">
    			<div class="col-6 p-4">
    				<h1 class="">Gestión de categorías</h1>
    			</div>
   			<div class="col-6 p-4">
   				<img src="/sgrc/img/icons/avatar_icon.svg" style="width: 125px">
   			</div>
   			</div>
   			<div id="main_notice" class="notice_container e_hidden">
   				<input type="button" onclick="hideNotice()">
                <div id="notice" class="div_notice"></div>
      		</div>
			<div class="row">
				<form action="" class="text-left form col-12" id="category-form">
					<div class="form-group ">
						<label for="cat_name">Nombre:</label>
						<input type="text" id="cat_name" name="cat_name" class="form-control" placeholder="Nombre">
					</div>
					<input type="button" id="register" class="btn btn-primary" value="Registrar" onclick="createCategory('category-form')">
					<input type="button" id="accept"  class="btn btn-primary invisible" value="Aceptar">
	   			</form>
   			</div>
    	</div>
    	<div class="col-xl-6 col-md-12">
    		<form class="text-left main-form my-search-form" onsubmit="return false">
                <div class="row justify-content-center form-group">
                    <label for="search-heroe-input" class="col-form-label col-md-3 col-12">Buscar categoría:</label>
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
			        <th scope="col"></th>
			        <th scope="col"></th>
			      </tr>
			    </thead>
			    <tbody>
			      <tr>
			        <td>Cell</td>
			        <td><a href="#" class="btn btn-info">Editar</a></td>
			        <td><a href="#" class="btn btn-danger">Eliminar</a></td>
			      </tr>
			      <tr>
					<td>Cell</td>
			        <td><a href="#" class="btn btn-info">Editar</a></td>
			        <td><a href="#" class="btn btn-danger">Eliminar</a></td>
			      </tr>
			      <tr>
			        <td>Cell</td>
			        <td><a href="#" class="btn btn-info">Editar</a></td>
			        <td><a href="#" class="btn btn-danger">Eliminar</a></td>
			      </tr>
			      <tr>
			        <td>Cell</td>
			        <td><a href="#" class="btn btn-info">Editar</a></td>
			        <td><a href="#" class="btn btn-danger">Eliminar</a></td>
			      </tr>
			    </tbody>
			  </table>
			</div>
    	</div>
   	</div>
	</section>
</body>
</html>