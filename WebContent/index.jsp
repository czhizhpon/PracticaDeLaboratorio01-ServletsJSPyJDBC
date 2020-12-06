<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inicio</title>

	<!--  Para el uso de Bootstrap -->
    <link rel="stylesheet" href="/sgrc/css/bootstrap/bootstrap.min.css">
    <link rel="stylesheet" href="/sgrc/css/fontawesome/all.min.css">
    
    <link rel="stylesheet" href="/sgrc/css/main.css">
    <link rel="stylesheet" href="/sgrc/css/my_forms.css">
    <link rel="stylesheet" href="/sgrc/css/index.css">

    <script src="/sgrc/js/bootstrap/jquery-3.5.1.min.js"></script>
    <script src="/sgrc/js/bootstrap/popper.min.js"></script>
    <script src="/sgrc/js/bootstrap/bootstrap.min.js"></script>
    <script src="/sgrc/js/bootstrap/all.min.js"></script>
    
    <script src="/sgrc/js/functions.js"></script>
	<script src="/sgrc/js/products.js"></script>
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
			              <a class="nav-link active" href="/sgrc/home">Inicio</a>
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
			              	<img src="/sgrc/img/icons/user_icon.svg" style="width:30px"> <span>&ensp;${user.useUsername}</span>
			              </a>
			              <div class="dropdown-menu dropdown-menu-right dropdown-default" aria-labelledby="drop_session">
			                
			                <c:choose>
			                <c:when test="${empty user.useName}">
			                <a class="dropdown-item" href="/sgrc/HTML/login.html">Iniciar Sesión</a>
			                </c:when>
			                <c:otherwise>
			                <a class="dropdown-item disabled" href="#">${user.useName} ${user.useLastname}</a>
			                <a class="dropdown-item disabled" href="#">${user.useEmail}</a>
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
	<section class="container ">
		<div class="row justify-content-center">
			<div class="col-10 text-center my-section" style="margin-top: 100px">
			<article class="row align-middle justify-content-center align-items-center">
				<div class="col-md-5 col-8 m-2 text-center">
					<h2>Bienvenido
						<c:if test="${not empty user.useCompany.comName}">
							a ${user.useCompany.comName}
						</c:if>
					</h2>
					<p>
						Realiza tus requerimientos de compras Aquí
					</p>
					<a href="/sgrc/store" class="btn btn-primary">Solicitar</a>
				</div>
				<div class="col-md-5 col-8 m-2 text-center">
					<img src="/sgrc/img/background/ecommerce.png" class="img-fluid rounded"/>
				</div>
			</article>
			</div>
		</div>
	</section>
	<br/>
	<br/>
	<section class="container">
		<c:choose>
		<c:when test="${empty user.useId}">
			<c:set var="i" value="${0}"/>
			<c:if test="${companies.size() > 0}">
				<div class="row justify-content-center">
					<h1>Catálogo</h1>
				</div>
			</c:if>
			<c:forEach var="company" items="${companies}">
			<c:if test="${allProducts.get(i).size() != 0}">
			<h3>${company.comName}</h3>
			<p>Productos populares</p>
			<div class="row justify-content-center my-section-dark">
				<div class="col-10">
				<div id="main_notice" class="notice_container e_hidden">
	   				<input type="button" onclick="hideNotice()">
	                <div id="notice" class="div_notice"></div>
	      		</div>
				    <div class="scrolling-wrapper text-center ">
				    <c:forEach var="product" items="${allProducts.get(i)}">
				    	<!-- Item -->
					        <div class="card" style="width: 18rem;">
							  <div class="card-body">
							    <h5 class="card-title">${product.proName}</h5>
							    <h6 class="card-subtitle mb-2 text-muted">${product.proCategory.catName}</h6>
							   	<h6>$${product.proPrice}</h6>
							   	<form id="pro-form-${product.proId}" method="get" action="" onsubmit="return false;">
						    		<input type="hidden" name="pro_price" value="${product.proPrice}"/>
			                        <input type="hidden" name="pro_id" value="${product.proId}"/>
			                        <input type="hidden" name="det_amount" value="1"/>
			                        <input type="button" class="btn btn-outline-primary" value="Agregar" onclick="location.href = '/sgrc/HTML/login.html'">
								</form>
							    
							  </div>
							</div>
						<!--Fin item-->
						</c:forEach>
				    </div>
				</div>
			</div>
			</c:if>
			<c:set var="i" value="${i + 1}"/>
			<br/>
			<br/>
			</c:forEach>
		</c:when>
		<c:otherwise>
			<c:set var="i" value="${0}"/>
			<c:forEach var="company" items="${companies}">
			<c:if test="${allProducts.get(i).size() != 0 and company.comName eq user.useCompany.comName}">
			<h3>${company.comName}</h3>
			<p>Productos populares</p>
			<div class="row justify-content-center my-section-dark">
				<div class="col-10">
				<div id="main_notice" class="notice_container e_hidden">
	   				<input type="button" onclick="hideNotice()">
	                <div id="notice" class="div_notice"></div>
	      		</div>
				    <div class="scrolling-wrapper text-center ">
				    <c:forEach var="product" items="${allProducts.get(i)}">
				    	<!-- Item -->
					        <div class="card" style="width: 18rem;">
							  <div class="card-body">
							    <h5 class="card-title">${product.proName}</h5>
							    <h6 class="card-subtitle mb-2 text-muted">${product.proCategory.catName}</h6>
							   	<h6>$${product.proPrice}</h6>
							   	<form id="pro-form-${product.proId}" method="get" onsubmit="return false;">
						    		<input type="hidden" name="pro_price" value="${product.proPrice}" class="e_hidden"/>
			                        <input type="hidden" name="pro_id" value="${product.proId}" class="e_hidden"/>
			                        <input type="hidden" name="det_amount" value="1" class="e_hidden"/>
			                        <input type="button" class="btn btn-outline-primary" value="Agregar" onclick="createIndexDetail('pro-form-${product.proId}'); ">
								</form>
							  </div>
							</div>
						<!--Fin item-->
						</c:forEach>
				    </div>
				</div>
			</div>
			</c:if>
			<c:set var="i" value="${i + 1}"/>
			<br>
			<br>
			</c:forEach>
		</c:otherwise>
		</c:choose>
	</section>
	<section class="container" style="margin-top: 50px">
		<div class="row justify-content-center">
			<div class="col-12">
				<h3> Equipo de desarrollo</h3>
			    <div class="scrolling-wrapper text-center">
			    	<!-- Item -->
			       	<div class="card" style="width: 18rem;">
						<img src="/sgrc/img/index/bearkarian.jpg" class="card-img-top rounded-circle" alt="Bryan Sarmiento Imagen" style="width: 125px; height: 125px">
			  			<div class="card-body">
					    	<h5 class="card-title">Bryan Sarmiento</h5>
					  	</div>
					  	<ul class="list-group list-group-flush">
					    	<li class="list-group-item ">
					    		<a href="tel:+59396917211" class="card-link">+593 99 691 7211</a>
					    	</li>
					    	<li class="list-group-item">
					    		<a href="mailto:dsarmientob1@est.ups.edu.ec" class="card-link">dsarmientob1@est.ups.edu.ec</a>
				    		</li>
					  	</ul>
					</div>
					<!--Fin item-->
					<!-- Item -->
			       	<div class="card" style="width: 18rem;">
						<img src="/sgrc/img/index/eldon.jpg" class="card-img-top rounded-circle"  alt="Roberto Serpa Imagen" style="width: 125px; height: 125px">
			  			<div class="card-body">
					    	<h5 class="card-title">Roberto Serpa</h5>
					  	</div>
					  	<ul class="list-group list-group-flush">
					    	<li class="list-group-item ">
					    		<a href="tel:+593998831305" class="card-link">+593 99 883 1305</a>
					    	</li>
					    	<li class="list-group-item">
					    		<a href="mailto:dsarmientob1@est.ups.edu.ec" class="card-link">rserpa@est.ups.edu.ec</a>
				    		</li>
					  	</ul>
					</div>
					<!--Fin item-->
					<!-- Item -->
			       	<div class="card" style="width: 18rem;">
						<img src="/sgrc/img/index/eddz.jpg" class="card-img-top rounded-circle" alt="Eduardo Zhizhpon Imagen" style="width: 125px; height: 125px">
			  			<div class="card-body">
					    	<h5 class="card-title">Eduardo Zhizhpon</h5>
					  	</div>
					  	<ul class="list-group list-group-flush">
					    	<li class="list-group-item ">
					    		<a href="tel:+593939446883" class="card-link">+593 93 944 6883</a>
					    	</li>
					    	<li class="list-group-item">
					    		<a href="mailto:czhizhpon@est.ups.edu.ec" class="card-link">czhizhpon@est.ups.edu.ec</a>
				    		</li>
					  	</ul>
					</div>
					<!--Fin item-->
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