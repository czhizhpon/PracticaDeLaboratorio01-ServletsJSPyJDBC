<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
    <script src="/sgrc/js/products.js"></script>

    <title>Productos</title>
</head>
<body>
	<div class="container">
		<div class="row justify-content-center">
			<div class="form-group">
			  <div class="input-group">
			
			    <span class="input-group-btn">
			      <select class="btn btn-select resizeselect">
			        <option>All</option>
			        <option>Longer</option>
			        <option>A very very long string...</option>
			      </select>
			    </span>
			
			    <input type="text" class="form-control" placeholder="Search by...">
			
			    <span class="input-group-btn">
			      <button class="btn btn-default" type="button">
			        <i class="fa fa-search"></i>
			      </button>
			    </span>
			
			  </div>
			</div>
        	
        </div>
	    <div class="row justify-content-center">
	        <div class="col-xl-9 col-md-8">
	        	
	            
			        <!-- Item esto se pone en el for each-->
		            <div class="d-sm-flex justify-content-between my-4 pb-4 border-bottom">
		                <div class="media d-block d-sm-flex text-center text-sm-left">
		                    <div class="media-body pt-3">
		                        <h2 class="">Nombre asdasdas ads dasdasd asd</h2>
		                        <div class="font-size-sm"><span class="text-muted mr-2">Categoría:</span>Categoría</div>
		                        <div class="font-size-lg text-primary pt-2">$Precio</div>
		                    </div>
		                </div>
		                <div class="pt-2 pt-sm-0 pl-sm-3 mx-auto mx-sm-0 text-center text-sm-left" style="max-width: 10rem;">
		                	<form id="pro-form-"> <!-- Poner el ID-->
			                    <div class="form-group mb-2">
			                        <label for="det_amount">Cantidad</label>
			                        <input class="form-control form-control-sm" type="number" name="det_amount" id="det_amount" placeholder="0" min="0" step="1" onkeypress="return isNumberKey(this, event)">
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