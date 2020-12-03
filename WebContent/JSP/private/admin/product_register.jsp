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
		<header>
       	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
      		<div class="container col-10">
        		<a class="navbar-brand" href="/sgrc/home">Requerimientos de Compra</a>
        		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbar" aria-controls="navbar" aria-expanded="false" aria-label="Toggle navigation">
          			<span class="navbar-toggler-icon"></span>
        		</button>

		        <div class="collapse navbar-collapse" id="navbar">
	          		<ul class="navbar-nav mr-auto">
			            <li class="nav-item">
			              <a class="nav-link" href="/sgrc/home">Inicio</a>
			            </li>
			            <c:if test="${user.useRole eq 'U'.charAt(0)}">
			            <li class="nav-item ">
			              <a class="nav-link text-nowrap" href="/sgrc/myBills">Mis Pedidos</a>
			            </li>
			            </c:if>
			            <c:if test="${user.useRole eq 'A'.charAt(0)}">
			            <li class="nav-item ">
			              <a class="nav-link text-nowrap" href="/sgrc/bills">Pedidos</a>
			            </li>
			            </c:if>
			            <c:if test="${user.useRole eq 'A'.charAt(0)}">
			            	<li class="nav-item active">
				              <a class="nav-link text-nowrap" href="/sgrc/ListProduct">Productos</a>
				            </li>
			            </c:if>
	          		</ul>
		            <form class="mx-2 my-auto d-inline w-50" style="min-width: 100px" action="/sgrc/store" method="get">
		            	<div class="input-group">
		                	<input id="search-product" name="s" class="form-control my-search-input" type="search" placeholder="Buscar Productos" aria-label="Search"/>
		                	<input type="submit" class="search-icon-light" value="">
	                	</div>
		            </form>
	          		<ul class="navbar-nav ml-auto nav-flex-icons">
				      	<li class="nav-item">
				        	<a href="/sgrc/ShoppingList" class="nav-link">
					        	<img src="/sgrc/img/icons/cart_icon.svg" style="width:30px"/>
			          		</a>
				      	</li>
				      	<li class="nav-item dropdown pinter-a">
			              <a class="nav-link dropdown-toggle" id="drop_session" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
			              	<img src="/sgrc/img/icons/user_icon.svg" style="width:30px"> <span>&ensp;${user.useName}</span>
			              </a>
			              <div class="dropdown-menu dropdown-menu-right dropdown-default" aria-labelledby="drop_session">
			                
			                <c:choose>
			                <c:when test="${empty user.useName}">
			                <a class="dropdown-item" href="/sgrc/HTML/login.html">Iniciar Sesión</a>
			                </c:when>
			                <c:otherwise>
			                <a class="dropdown-item" href="/sgrc/EndSession">Cerrar Sesión </a>
			                </c:otherwise>
			                </c:choose>
			              </div>
			            </li>
			      	</ul>
	        	</div>
      		</div>
    	</nav>
	</header>
	<section class="container text-center col-10" style="margin-top: 100px">
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
						<input type="text" id="pro_name" name="pro_name" class="form-control" placeholder="Nombre" value="${productRead.proName}">
					</div>
					<div class="form-group ">
						<label for="pro_stock">Stock:</label>
						<input type="number" id="pro_stock" name="pro_stock" class="form-control" placeholder="0" min="0" step="1" onkeypress="return isNumberKey(this, event);" value="${productRead.proStock}">	
					</div>
					<div class="form-group ">
						<label for="pro_price">Precio:</label>
						<input type="number" id="pro_price" name="pro_price" class="form-control" placeholder="0.00" min="0.00" step=".01" onkeypress="return isDecimalKey(this, event);" value="${productRead.proPrice}">	
					</div>
					<input type="hidden" value="${productRead.proId}" name="pro_id"/>
					<div class="form-group ">
						<label for="cat_id">Categoría:</label>	
						 <select name="cat_id" class="form-control">
						 	<option value="NaN" selected>Seleccione</option>
					    	<c:forEach var="category" items="${categories}">
					    		<c:choose>
						    		<c:when test="${productRead.proCategory.catId == category.catId}">
						    			<option value="${category.catId}" selected>${category.catName}</option>
						    		</c:when>
						    		<c:otherwise>
						    			<option value="${category.catId}">${category.catName}</option>
						    		</c:otherwise>
					    		</c:choose>
							</c:forEach>
						</select>
					</div>
					<c:choose>
						<c:when test="${empty productRead.proId}">
							<input type="button" id="register" class="btn btn-primary" value="Registrar" onclick="createProduct('product-form')">
						</c:when>
						<c:otherwise>
							<input type="button" id="accept"  class="btn btn-primary" value="Aceptar" onclick="updateProduct('product-form')">
						</c:otherwise>
	   				</c:choose>
	   			</form>
   			</div>
    	</div>
    	<div class="col-xl-7 col-md-12">
    		<!-- 
    		<form class="text-left main-form my-search-form" onsubmit="return false">
                <div class="row justify-content-center form-group">
                    <label for="search-heroe-input" class="col-form-label col-md-3 col-12">Buscar producto:</label>
                    <input id="search-heroe-input" name="search-heroe-input" class="form-control col-md-8 col-11" type="search" placeholder="Ingresar nombre"
                        aria-label="Search">
                    <input type="button" class="search-icon btn col-1" onclick="">
                </div>
            </form>
            -->
            <div id="table_product" >
	    		<div class="table-responsive" id="table_content" style="max-height: 600px">
				  <table class="table table-striped ">
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
					    <c:set var="tableProduct" scope="request" value="${products}" />
				    	<c:forEach var="product" items="${tableProduct}">
					      <tr>
					        <td>${product.proName}</td>
					        <td>${product.proStock}</td>
					        <td>${product.proPrice}</td>
					        <td>${product.proCategory.catName}</td>
					        <c:choose>
								<c:when test="${product.proDeleted}">	
					        		<td><a href="#" class="btn btn-outline-info disabled">Editar</a></td>
					        		<td><a href="#" id="deleteButton" onclick="deleteProduct(${product.proId}, 0)" class="btn btn-success">Restaurar</a></td>
					        	</c:when>
					        	<c:otherwise>
					        		<td><a href="#" class="btn btn-info" onclick="readProduct(${product.proId})">Editar</a></td>
					        		<td><a href="#" id="deleteButton" onclick="deleteProduct(${product.proId}, 1)" class="btn btn-danger">Eliminar</a></td>
					      		</c:otherwise>
				      		</c:choose>
					      </tr>
					    </c:forEach>  
				    </tbody>
				  </table>
				</div>
			</div>
    	</div>
   	</div>
	</section>
	<!-- Footer -->
	<footer class="page-footer font-small">

      <div style="background-color: #6351ce;">
        <div class="container">

          <!-- Grid row-->
          <div class="row py-4 d-flex align-items-center">

            <!-- Grid column -->
            <div class="col-md-6 col-lg-5 text-center text-md-left mb-4 mb-md-0">
              <h6 class="mb-0">Síguenos en nuestras Redes Sociales</h6>
            </div>
            <!-- Grid column -->

            <!-- Grid column -->
            <div class="col-md-6 col-lg-7 text-center text-md-right">

              <!-- Facebook -->
              <a class="fb-ic">
                <i class="fab fa-facebook-f white-text mr-4"> </i>
              </a>
              <!-- Twitter -->
              <a class="tw-ic">
                <i class="fab fa-twitter white-text mr-4"> </i>
              </a>
              <!-- Google +-->
              <a class="gplus-ic">
                <i class="fab fa-google-plus-g white-text mr-4"> </i>
              </a>
              <!--Linkedin -->
              <a class="li-ic">
                <i class="fab fa-linkedin-in white-text mr-4"> </i>
              </a>
              <!--Instagram-->
              <a class="ins-ic">
                <i class="fab fa-instagram white-text"> </i>
              </a>

            </div>
            <!-- Grid column -->

          </div>
          <!-- Grid row-->

        </div>
      </div>

      <!-- Footer Links -->
      <div class="container text-center text-md-left mt-5">

        <!-- Grid row -->
        <div class="row mt-3">

          <!-- Grid column -->
          <div class="col-md-3 col-lg-4 col-xl-3 mx-auto mb-4">

            <!-- Content -->
            <h6 class="text-uppercase font-weight-bold">BIENVENIDO</h6>
            <hr class="deep-purple accent-2 mb-4 mt-0 d-inline-block mx-auto" style="width: 60px;">
            <p>
            	Sistema Gestor de Requerimientos de Compra
            </p>

          </div>
          <!-- Grid column -->

          <!-- Grid column -->
          <div class="col-md-2 col-lg-2 col-xl-2 mx-auto mb-4">

            <!-- Links -->
            <h6 class="text-uppercase font-weight-bold">Productos</h6>
            <hr class="deep-purple accent-2 mb-4 mt-0 d-inline-block mx-auto" style="width: 60px;">
            <p>
              <a href="/sgrc/store">Solicitar</a>
            </p>
            <p>
              <a href="/sgrc/myBills">Mis Pedidos</a>
            </p>
          </div>
          <!-- Grid column -->

          <!-- Grid column -->
          <div class="col-md-4 col-lg-3 col-xl-3 mx-auto mb-md-0 mb-4">

            <!-- Links -->
            <h6 class="text-uppercase font-weight-bold">Contacto</h6>
            <hr class="deep-purple accent-2 mb-4 mt-0 d-inline-block mx-auto" style="width: 60px;">
            <p>
              	<i class="fas fa-home mr-3"></i> Cuenca, 10012, Ecuador</p>
            <p>
              	<i class="fas fa-envelope mr-3"></i> <a href="mailto:info@example.com">info@example.com</a></p>
            <p>
              	<i class="fas fa-phone mr-3"></i> <a href="tel:+0123456788">+ 01 234 567 88</a>
             </p>

          </div>
          <!-- Grid column -->

        </div>
        <!-- Grid row -->

      </div>
      <!-- Footer Links -->

      <!-- Copyright -->
      <div class="footer-copyright text-center py-3 copy-right">
      	© 2020 Copyright
      	<h6>Nuvarmy S.A. &lt;3</h6>
      </div>
      <!-- Copyright -->

    </footer>
<!-- Footer -->
	
</body>
</html>