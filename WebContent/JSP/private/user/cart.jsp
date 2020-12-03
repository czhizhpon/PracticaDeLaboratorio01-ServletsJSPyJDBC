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
    <link rel="stylesheet" href="/sgrc/css/my_forms.css">

	<script src="/sgrc/js/bootstrap/jquery-3.5.1.min.js"></script>
    <script src="/sgrc/js/bootstrap/popper.min.js"></script>
    <script src="/sgrc/js/bootstrap/bootstrap.min.js"></script>

    
    <script src="/sgrc/js/functions.js"></script>
    <script src="/sgrc/js/cart.js"></script>

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
			            	<li class="nav-item ">
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
	<section class="container" style="margin-top: 100px">
	<br/>
	<h2>Mi Carrito</h2>
	<hr/>
	<br/>
	<div class="container pb-5 mt-n2 mt-md-n3">
	    <div class="row">
	        <div class="col-xl-9 col-md-8">
	            <h2 class="h6 d-flex flex-wrap justify-content-between align-items-center px-4 py-3 bg-secondary">
	            	<span>Productos</span>
	            	<a class="font-size-sm" href="/sgrc/store">
	            		&laquo; Continuar comprando
            		</a>
           		</h2>
           		<div id="main_notice" class="notice_container e_hidden">
   					<input type="button" onclick="hideNotice()">
                	<div id="notice" class="div_notice"></div>
        		</div>
           		<c:set var="bill" scope="request" value="${billHead}"/>
           		<c:forEach var="billDetail" items="${bill.heaBillDetails}">
		            <!-- Item-->
		            <div class="d-sm-flex justify-content-between my-4 pb-4 border-bottom">
		                <div class="text-center text-sm-left">
		                	<!--  Para imagenes
		                    <a class="cart-item-thumb mx-auto mr-sm-4" href="#"><img src="https://via.placeholder.com/240x240/FF0000/000000" alt="Product"></a>
		                    -->
		                    <div class="media-body p-3">
		                        <h3 class="font-weight-semibold border-0">${billDetail.detProduct.proName}</h3>
		                        <div class="font-size-sm"><span class="text-muted mr-2">Precio Unitario:</span>$${billDetail.detProduct.proPrice}</div>
		                        <div class="font-size-lg text-primary pt-2">$${billDetail.detTotal}</div>
		                    </div>
		                </div>
		                <div class="pt-2 pt-sm-0 pl-sm-3 mx-auto mx-sm-0 text-center text-sm-left" style="max-width: 15rem;">
		                    <div class="form-group mb-2">
		                        <label for="det_amount${billDetail.detId}">Cantidad</label>
		                        <input class="form-control form-control-sm" type="number" 
		                        	id="det_amount${billDetail.detId}" value="${billDetail.detAmount}"
		                        	min="1" onkeypress="return isNumberKey(this, event)">
		                    </div>
		                    <button class="btn btn-outline-secondary btn-md btn-block  mb-2" type="button" onclick="updateBillDetails(${billDetail.detId})">
		                        <i class="fas fa-sync"></i>&ensp;Actualizar</button>
		                    <button class="btn btn-outline-danger btn-md btn-block mb-2" type="button" onclick="deleteBillDetails(${billDetail.detId})">
		                        <i class="fas fa-trash"></i>&ensp;Eliminar</button>
		                </div>
		            </div>
		            <!-- Fin Item -->
	            </c:forEach>
	        </div>
	        <div class="col-xl-3 col-md-4 pt-3 pt-md-0">
	            <h2 class="h6 px-4 py-3 bg-secondary text-center">Subtotal</h2>
	            <div class="h3 font-weight-semibold text-center py-3">$${bill.heaSubtotal}</div>
	            <h2 class="h6 px-4 py-3 bg-secondary text-center">IVA</h2>
	            <div class="h3 font-weight-semibold text-center py-3">$${bill.heaVat}</div>
	            <h2 class="h6 px-4 py-3 bg-secondary text-center">Total</h2>
	            <div class="h3 font-weight-semibold text-center py-3">$${bill.heaTotal}</div>
	            <hr/>
	            <button class="btn btn-primary btn-block" onclick="updateBillHead()">
	                <i class="fas fa-wallet"></i>&ensp;Procesar Pedido
                </button>
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