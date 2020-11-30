<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Mi Carrito</title>

	<!--  Para el uso de Bootstrap -->
    <link rel="stylesheet" href="/sgrc/css/bootstrap/bootstrap.min.css">
    <link rel="stylesheet" href="/sgrc/css/fontawesome/all.min.css">
    
    <link rel="stylesheet" href="/sgrc/css/products.css">
    <link rel="stylesheet" href="/sgrc/css/main.css">

	<script src="/sgrc/js/bootstrap/jquery-3.5.1.min.js"></script>
    <script src="/sgrc/js/bootstrap/popper.min.js"></script>
    <script src="/sgrc/js/bootstrap/bootstrap.min.js"></script>

    
    <script src="/sgrc/js/functions.js"></script>

</head>
<body>

	<header>
       	<nav class="navbar navbar-expand-lg navbar-dark bg-dark sticky-top">
      		<div class="container">
        		<a class="navbar-brand" href="#">Requerimientos de Compra</a>
        		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbar" aria-controls="navbar" aria-expanded="false" aria-label="Toggle navigation">
          			<span class="navbar-toggler-icon"></span>
        		</button>

		        <div class="collapse navbar-collapse" id="navbar">
	          		<ul class="navbar-nav mr-auto">
			            <li class="nav-item">
			              <a class="nav-link" href="#">Inicio</a>
			            </li>
		            
			            <li class="nav-item ">
			              <a class="nav-link" href="#">Mis Pedidos</a>
			            </li>
		            <!-- 
		            <li class="nav-item">
		              <a class="nav-link disabled" href="#">Disabled</a>
		            </li>
		            -->
		            
	          		</ul>
	          		<!--  
	          		<div class="flex-grow-1 d-flex">
			            <form class="form-inline flex-nowrap bg-dark mx-0 mx-lg-auto rounded p-1">
			                <input class="form-control mr-sm-1" type="search" placeholder="Buscar" aria-label="Search">
			                <input type="button" class="search-icon btn">
			            </form>
			        </div>
			        -->
	          		<ul class="navbar-nav">
				      	<li class="nav-item">
				        	<a href="/sgrc/ShoppingList" class="nav-link">
					        	<img src="/sgrc/img/icons/cart_icon.svg" style="width:30px">
			          		</a>
				      	</li>
				      	<li class="nav-item dropdown">
			              <a class="nav-link dropdown-toggle" href="http://example.com" id="navbar" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
			              	<img src="/sgrc/img/icons/user_icon.svg" style="width:30px"> <span>Mi Cuenta</span>
			              </a>
			              <div class="dropdown-menu" aria-labelledby="dropdown07">
			                <a class="dropdown-item" href="#">Cerrar Sesión</a>
			                <a class="dropdown-item" href="#">Another action</a>
			                <a class="dropdown-item" href="#">Something else here</a>
			              </div>
			            </li>
			      	</ul>
		          <!-- 
		          <form class="form-inline my-2 my-md-0">
		            <input class="form-control" type="text" placeholder="Search" aria-label="Search">
		          </form>
		           -->
	        	</div>
      		</div>
    	</nav>
	</header>
	<section class="container">
	<br/>
	<h2>Mi Carrito</h2>
	<hr/>
	<br/>
	<div class="container pb-5 mt-n2 mt-md-n3">
	    <div class="row">
	        <div class="col-xl-9 col-md-8">
	            <h2 class="h6 d-flex flex-wrap justify-content-between align-items-center px-4 py-3 bg-secondary">
	            	<span>Productos</span>
	            	<a class="font-size-sm" href="#">
	            		&laquo; Continuar comprando
            		</a>
           		</h2>
           		<c:set var="bill" scope="request" value="${billHead}"/>
           		<c:forEach var="billDetail" items="${bill.heaBillDetails}">
		            <!-- Item-->
		            <div class="d-sm-flex justify-content-between my-4 pb-4 border-bottom">
		                <div class="text-center text-sm-left">
		                	<!--  Para imagenes
		                    <a class="cart-item-thumb mx-auto mr-sm-4" href="#"><img src="https://via.placeholder.com/240x240/FF0000/000000" alt="Product"></a>
		                    -->
		                    <div class="media-body p-3">
		                        <h3 class="font-weight-semibold border-0">${billDetail.detId} asdasdasdasdas das d</h3>
		                        <div class="font-size-sm"><span class="text-muted mr-2">Precio Unitario:</span>$${billDetail.detUnitPrice}</div>
		                        <div class="font-size-sm"><span class="text-muted mr-2">Id:</span>8.5</div>
		                        <div class="font-size-lg text-primary pt-2">$${billDetail.detTotal}</div>
		                    </div>
		                </div>
		                <div class="pt-2 pt-sm-0 pl-sm-3 mx-auto mx-sm-0 text-center text-sm-left" style="max-width: 15rem;">
		                    <div class="form-group mb-2">
		                        <label for="quantity${billDetail.detId}">Cantidad</label>
		                        <input class="form-control form-control-sm" type="number" id="quantity${billDetail.detId}" value="${billDetail.detAmount}">
		                    </div>
		                    <button class="btn btn-outline-secondary btn-md btn-block  mb-2" type="button" onclick="updateBillDetails(${billDetail.detId})">
		                        <i class="fas fa-sync"></i>&ensp;Actualizar</button>
		                    <button class="btn btn-outline-danger btn-md btn-block mb-2" type="button">
		                        <i class="fas fa-trash"></i>&ensp;Eliminar</button>
		                </div>
		            </div>
		            <!-- Fin Item -->
	            </c:forEach>
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
	        </div>
	        <!-- Sidebar-->
	        <div class="col-xl-3 col-md-4 pt-3 pt-md-0">
	            <h2 class="h6 px-4 py-3 bg-secondary text-center">Subtotal</h2>
	            <div class="h3 font-weight-semibold text-center py-3">$${bill.heaSubtotal}</div>
	            <h2 class="h6 px-4 py-3 bg-secondary text-center">IVA</h2>
	            <div class="h3 font-weight-semibold text-center py-3">$${bill.heaVat}</div>
	            <h2 class="h6 px-4 py-3 bg-secondary text-center">Total</h2>
	            <div class="h3 font-weight-semibold text-center py-3">$${bill.heaTotal}</div>
	            <hr/>
	            <!--  
	            <h3 class="h6 pt-4 font-weight-semibold"><span class="badge badge-success mr-2">Note</span>Additional comments</h3>
	            <textarea class="form-control mb-3" id="order-comments" rows="5"></textarea>
	            -->
	            <a class="btn btn-primary btn-block" href="#">
	                <i class="fas fa-wallet"></i>&ensp;Procesar Pedido
                </a>
	        </div>
	    </div>
	</div>
	</section>
</body>
</html>