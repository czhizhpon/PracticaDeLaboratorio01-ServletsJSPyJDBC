<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Productos</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="stylesheet" href="/sgrc/css/bootstrap/bootstrap.min.css">
    <link rel="stylesheet" href="/sgrc/css/products.css">

    <script src="/sgrc/js/bootstrap/jquery-3.5.1.min.js"></script>
    <script src="/sgrc/js/bootstrap/popper.min.js"></script>
    <script src="/sgrc/js/bootstrap/bootstrap.min.js"></script>
    
    <script src="/sgrc/js/functions.js"></script>
</head>
<body>
<!--  	
<c:set var="category" scope="request" value="${Category}" />
	
	<h2>Productos</h2>
	
	<header>
       <nav class="navbar navbar-expand-lg navbar-dark bg-dark sticky-top">
      <div class="container">
        <a class="navbar-brand" href="#">Ver Productos</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbar" aria-controls="navbar" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbar">
          <ul class="navbar-nav mr-auto">
            <li class="nav-item ">
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
            <!--
            <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" href="http://example.com" id="dropdown07" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Dropdown</a>
              <div class="dropdown-menu" aria-labelledby="dropdown07">
                <a class="dropdown-item" href="#">Action</a>
                <a class="dropdown-item" href="#">Another action</a>
                <a class="dropdown-item" href="#">Something else here</a>
              </div>
            </li>
          </ul>
          
          <ul class="navbar-nav ml-auto">
		      <li class="nav-item pl-2 mb-2 mb-md-0 d-md-none d-xl-inline-block">
		        <a href="#!" type="button"
		          class="btn btn-outline-light btn-md btn-rounded btn-navbar waves-effect waves-light">
		          Productos</a>
	      	</li>
	      </ul>
          <!-- 
          <form class="form-inline my-2 my-md-0">
            <input class="form-control" type="text" placeholder="Search" aria-label="Search">
          </form>
           -->
           <!--
        </div>
      </div>
    </nav>
	</header>
	<section class="container">
	<br/>
	<h2>Lista de Productos</h2>
	<hr/>
	<br/>
	<div class="container pb-5 mt-n2 mt-md-n3">
	    <div class="row">
	        <div class="col-xl-9 col-md-8">
	            <h2 class="h6 d-flex flex-wrap justify-content-between align-items-center px-4 py-3 bg-secondary">
	            	<span>Productos</span>
	            	
           		</h2>
	
	
	
				<c:forEach var="products" items="${category.Products}">
				    <!-- Item-->
				    <!--
				    <div class="d-sm-flex justify-content-between my-4 pb-4 border-bottom">
				        <div class="media d-block d-sm-flex text-center text-sm-left">
				        	<!--  Para imagenes
				            <a class="cart-item-thumb mx-auto mr-sm-4" href="#"><img src="https://via.placeholder.com/240x240/FF0000/000000" alt="Product"></a>
				            -->
				            <!--
				            <div class="media-body pt-3">
				                <h3 class="product-card-title font-weight-semibold border-0 pb-0">${product.proId}</h3>
				                <div class="font-size-sm"><span class="text-muted mr-2">Stock:</span>$${product.proStock}</div>
				                <div class="font-size-sm"><span class="text-muted mr-2">Id:</span>8.5</div>
				                <div class="font-size-lg text-primary pt-2">$${product.proPrice}</div>
				            </div>
				        </div>
				        <div class="pt-2 pt-sm-0 pl-sm-3 mx-auto mx-sm-0 text-center text-sm-left" style="max-width: 10rem;">
				            <div class="form-group mb-2">
				                <label for="name${product.proId}">Cantidad</label>
				                <input class="form-control form-control-sm" type="number" id="name${product.proId}" value="${product.proStock}">
				            </div>
				            <button class="btn btn-outline-secondary btn-sm btn-block mb-2" type="button" onclick="updateProducts(${product.proId})">
				                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-refresh-cw mr-1">
				                    <polyline points="23 4 23 10 17 10"></polyline>
				                    <polyline points="1 20 1 14 7 14"></polyline>
				                    <path d="M3.51 9a9 9 0 0 1 14.85-3.36L23 10M1 14l4.64 4.36A9 9 0 0 0 20.49 15"></path>
				                </svg>Actualizar</button>
				            <button class="btn btn-outline-danger btn-sm btn-block mb-2" type="button">
				                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-trash-2 mr-1">
				                    <polyline points="3 6 5 6 21 6"></polyline>
				                    <path d="M19 6v14a2 2 0 0 1-2 2H7a2 2 0 0 1-2-2V6m3 0V4a2 2 0 0 1 2-2h4a2 2 0 0 1 2 2v2"></path>
				                    <line x1="10" y1="11" x2="10" y2="17"></line>
				                    <line x1="14" y1="11" x2="14" y2="17"></line>
				                </svg>Eliminar</button>
				        </div>
				    </div>
				    <!-- Fin Item -->
				    <!--
			   	</c:forEach>
			   	
			</div>
			
	        <!-- Sidebar-->
	        <!--
	        <div class="col-xl-3 col-md-4 pt-3 pt-md-0">
	            <h2 class="h6 px-4 py-3 bg-secondary text-center">Categoria Nombre</h2>
	            <div class="h3 font-weight-semibold text-center py-3">$${category.catName}</div>
	            <hr/>
	            <!--  
	            <h3 class="h6 pt-4 font-weight-semibold"><span class="badge badge-success mr-2">Note</span>Additional comments</h3>
	            <textarea class="form-control mb-3" id="order-comments" rows="5"></textarea>
	            -->
	            <!--
	            <a class="btn btn-primary btn-block" href="#">
	                <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-credit-card mr-2">
	                    <rect x="1" y="4" width="22" height="16" rx="2" ry="2"></rect>
	                    <line x1="1" y1="10" x2="23" y2="10"></line>
	                </svg>Proceed to Checkout
                </a>
	        </div>
	    </div>
	    
	</form>
	</div>
	</section>
--> 
<H2>Productos</H2>
	<c:set var="ct" scope="request" value="${category}" />
	<h1>Listar Productos</h1>	

	<table>
		<p>Categoria:  ${ct.catName} </p>
		<tr>
			<td><strong>Id</strong></td>
			<td><strong>Nombre</strong></td>
			<td><strong>Stock</strong></td>
			<td><strong>Precio</strong></td>
		</tr>
		<c:forEach var="p" items="${ct.products}">
			<tr>
				<td>${p.proId}</td>
				<td>${p.proName}</td>
				<td>${p.proStock}</td>
				<td>${p.proPrice}</td>
			</tr>
		</c:forEach>
	</table>
	<a href="/sgrc/">Regresar al index</a>	
</body>
</html>