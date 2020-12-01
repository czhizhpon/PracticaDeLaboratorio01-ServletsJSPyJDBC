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
    <script src="/sgrc/js/crud_company.js"></script>

    <title>Empresas</title>
</head>
<body>
	<section class="container text-center col-10">
   	<div class="row justify-content-center">
    	<div class="col-xl-5 col-md-12">
    		<div class="row align-items-center">
    			<div class="col-6 p-4">
    				<h1 class="">Gestión de empresas</h1>
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
				<form action="" class="text-left form col-12" id="company-form">
					<div class="form-group ">
						<label for="com_name">Nombre:</label>
						<input type="text" id="com_name" name="com_name" class="form-control" placeholder="Nombre">
					</div>
					<input type="button" id="register" class="btn btn-primary" value="Registrar" onclick="createCompany('company-form')">
					<input type="button" id="accept"  class="btn btn-primary invisible" value="Aceptar">
	   			</form>
   			</div>
    	</div>
    	<div class="col-xl-7 col-md-12">
    		<form class="text-left main-form my-search-form" onsubmit="return false">
                <div class="row justify-content-center form-group">
                    <label for="search-heroe-input" class="col-form-label col-md-3 col-12">Buscar Empresa:</label>
                    <input id="search-heroe-input" name="search-heroe-input" class="form-control col-md-8 col-11" type="search" placeholder="Ingresar nombre"
                        aria-label="Search">
                    <input type="button" class="search-icon btn col-1" onclick="">
                </div>
            </form>
            <div id="table_company">
	    		<div class="table-responsive" id="table_content">
				  <table class="table table-striped">
				    <thead class="thead-dark">
				      <tr>
				        <th scope="col">Nombre</th>
				        <th scope="col"></th>
				        <th scope="col"></th>
				      </tr>
				    </thead>
				    <tbody>
					    <c:set var="tableCompany" scope="request" value="${companies}" />
					    <c:forEach var="company" items="${tableCompany}">
					      <tr>
					        <td>${company.comName}</td>
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