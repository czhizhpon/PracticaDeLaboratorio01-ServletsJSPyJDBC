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

    <title>Productos</title>
</head>
<body>
	<div class="container">
	    <div class="row justify-content-center">
	        <div class="col-xl-9 col-md-8">
	            <form class="text-left main-form my-search-form" onsubmit="return false">
	                <div class="row justify-content-center form-group">
	                    <label for="search-heroe-input" class="col-form-label col-md-4 col-12">Buscar producto:</label>
	                    <input id="search-heroe-input" name="search-heroe-input" class="form-control col-md-7 col-11" type="search" placeholder="Ingresar nombre"
	                        aria-label="Search">
	                    <input type="button" class="search-icon btn col-1" onclick="">
	                </div>
	            </form>
		            <!-- Item esto se pone en el for each-->
	            <div class="d-sm-flex justify-content-between my-4 pb-4 border-bottom">
	                <div class="media d-block d-sm-flex text-center text-sm-left">
	                    <div class="media-body pt-3">
	                        <h2 class="">Nombre</h2>
	                        <div class="font-size-sm"><span class="text-muted mr-2">Categoría:</span>Categoría</div>
	                        <div class="font-size-lg text-primary pt-2">$Precio</div>
	                    </div>
	                </div>
	                <div class="pt-2 pt-sm-0 pl-sm-3 mx-auto mx-sm-0 text-center text-sm-left" style="max-width: 10rem;">
	                	<form id="pro-form-">
		                    <div class="form-group mb-2">
		                        <label for="det_amount">Cantidad</label>
		                        <input class="form-control form-control-sm" type="number" name="det_amount" id="det_amount" placeholder="0" min="0" step="1">
		                    </div>
		                    <input class="btn btn-outline-secondary btn-sm btn-block mb-2" type="button" onclick="" value="Agregar al Carrito">
	                    </form>
	                </div>
	            </div>
		            <!-- Fin Item -->
        	</div>
		</div>
	</div>
	
	<!-- Paginación 
	            <nav aria-label="Page navigation example">
				  <ul class="pagination justify-content-center">
				    <li class="page-item disabled">
				      <a class="page-link" href="#" tabindex="-1">Anterior</a>
				    </li>
				    <li class="page-item active"><a class="page-link" href="#">1</a></li>
				    <li class="page-item"><a class="page-link" href="#">2</a></li>
				    <li class="page-item"><a class="page-link" href="#">3</a></li>
				    <li class="page-item">
				      <a class="page-link" href="#">Siguiente</a>
				    </li>
				  </ul>
				</nav>
				-->
</body>
</html>