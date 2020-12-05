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
    <link rel="stylesheet" href="/sgrc/css/fontawesome/all.min.css">
    
    <link rel="stylesheet" href="/sgrc/css/products.css">
    <link rel="stylesheet" href="/sgrc/css/main.css">
    <link rel="stylesheet" href="/sgrc/css/my_forms.css">

    <script src="/sgrc/js/bootstrap/jquery-3.5.1.min.js"></script>
    <script src="/sgrc/js/bootstrap/popper.min.js"></script>
    <script src="/sgrc/js/bootstrap/bootstrap.min.js"></script>
    
    <script src="/sgrc/js/functions.js"></script>
    <script src="/sgrc/js/jquery.validate.min.js"></script>
    <script src="/sgrc/js/crud_user.js"></script>

    <title>Usuarios</title>
</head>
<body class="">
   <section class="container text-center col-11">
   	<div class="row justify-content-center">
    	<div class="col-xl-4 col-lg-12">
    		<div class="row align-items-center">
    			<div class="col-6 p-4">
    				<h1 class="">Gestión de usuarios</h1>
    			</div>
	   			<div class="col-6 p-4">
	   				<img src="/sgrc/img/icons/avatar_icon.svg" style="width: 125px">
	   			</div>
   			</div>
			<div id="main_notice" class="notice_container e_hidden">
   				<input type="button" onclick="hideNotice()">
                <div id="notice" class="div_notice"></div>
        	</div>
			<form action="" method="POST" class="text-left form col-12" id="user-form" name="user-form">
				<div class="form-group ">
					<label for="use_name">Nombre:</label>
					<input type="text" id="use_name" name="use_name" class="form-control" placeholder="Nombre">
				</div>
				<div class="form-group ">
					<label for="use_lastname">Apellidos:</label>
					<input type="text" id="use_lastname" name="use_lastname" class="form-control" placeholder="Apellidos">	
				</div>
				<div class="form-group ">
					<label for="use_email">Correo Electrónico:</label>
					<input type="email" id="use_email" name="use_email" class="form-control" placeholder="Correo Electrónico">	
				</div>
				<div class="form-group">
					<label for="use_username">Nombre de usuario:</label>
					<input type="text" id="use_username" name="use_username" class="form-control" placeholder="Nombre de Usuario">
				</div>
				<div class="row">
					<div class="form-group col-xl-12 col-md-6 col-12">
						<label for="use_password">Contraseña:</label>
						<input type="password" id="use_password" name="use_password" class="form-control" placeholder="Contraseña">
					</div>
					<div class="col-xl-12 col-md-6 col-12">
						<label for="use_password_conf">Confirmar Contraseña:</label>
						<input type="password" id="use_password_conf" name="use_password_conf" class="form-control" placeholder="Confirmar Contraseña">
					</div>
				</div>
				<div class="form-group">
					<label for="com_id">Empresa:</label>
					<select name="com_id" class="form-control">
					 	<option value="NaN" selected>Seleccione</option>
				    	<c:forEach var="company" items="${companies}">
		    				<option value="${company.comId}">${company.comName}</option>
						</c:forEach>
					</select>
				</div>
				<div class="form-group">
					<label for="use_role">Seleccione el tipo de usuario:</label><br>
					<div class="custom-control custom-radio custom-control-inline">
					  	<input type="radio" id="use_role_user" name="use_role" class="custom-control-input" checked value="U">
					  	<label class="custom-control-label" for="use_role_user" >Usuario</label>
					</div>
					<div class="custom-control custom-radio custom-control-inline">
					  	<input type="radio" id="use_role_admin" name="use_role" class="custom-control-input" value="A">
					  	<label class="custom-control-label" for="use_role_admin">Administrador</label>
					</div>
				</div>
				
				<input type="button" id="register" class="btn btn-primary" value="Registrar" onclick="createUser('user-form')">
				<input type="button" id="accept"  class="btn btn-primary invisible" value="Aceptar">
   			</form>
   			
    	</div>
    	<div class="col-xl-8 col-lg-12">
    		<form class="text-left main-form my-search-form" onsubmit="return false">
                <div class="row justify-content-center form-group">
                    <label for="search-heroe-input" class="col-form-label col-md-3 col-12">Buscar usuario:</label>
                    <input id="search-heroe-input" name="search-heroe-input" class="form-control col-md-8 col-11" type="search" placeholder="Ingresar correo"
                        aria-label="Search">
                    <input type="button" class="search-icon btn col-1" onclick="searchAHero()">
                </div>
            </form>
            <div id="table_user">
	    		<div class="table-responsive" id="table_content">
				  <table class="table table-striped">
				    <thead class="thead-dark">
				      <tr>
				        <th scope="col">Nombre</th>
				        <th scope="col">Apellidos</th>
				        <th scope="col">Correo</th>
				        <th scope="col">Nom. Usuario</th>
				        <th scope="col">Rol</th>
				        <th scope="col">Empresa</th>
				        <th scope="col"></th>
				        <th scope="col"></th>
				      </tr>
				    </thead>
				    <tbody>
				    <c:set var="tableUser" scope="request" value="${users}" />
				      <c:forEach var="user" items="${tableUser}">
				      <tr>
				        <td>${user.useName}</td>
				        <td>${user.useLastname}</td>
				        <td>${user.useEmail}</td>
				        <td>${user.useUsername}</td>
				        <td>${user.useRole}</td>
				        <td>${user.useCompany.comName}</td>
				        <td><a href="#" class="btn btn-info">Editar</a></td>
				        <td><a href="#" class="btn btn-danger">Eliminar</a></td>
				      </tr>
				      </c:forEach>
				    </tbody>
				  </table>
				</div>
			</div>
    	</div>
   	</div>
   	
    </section>
</body>
</html>