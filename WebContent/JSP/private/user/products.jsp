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
	          		<!-- 
		            <form class="mx-2 my-auto d-inline w-50" style="min-width: 100px" action="/sgrc/store" method="get">
		            	<div class="input-group">
		                	<input id="search-product" name="s" class="form-control my-search-input" type="search" placeholder="Buscar Productos" aria-label="Search"/>
		                	<input type="submit" class="search-icon-light" value="">
	                	</div>
		            </form>
		             -->
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
	<div class="container"  style="margin-top: 100px">
		<h2>${user.useCompany.comName}</h2>
		<br/>
		<div class="row justify-content-center">
			<form class="form-group col-12" onsubmit="searchProduct(); return false;">
			  <div class="input-group">
				<c:set var="minP" scope="request" value="${min}"/>
				<c:set var="maxP" scope="request" value="${max}"/>
			    <select id="cat_id">
			    	<option value="0">Todo</option>
			    	<c:forEach var="category" items="${categories}">
			    		<c:choose>
				    		<c:when test="${catId == category.catId}">
				    			<option value="${category.catId}" selected>${category.catName}</option>
				    		</c:when>
				    		<c:otherwise>
				    			<option value="${category.catId}">${category.catName}</option>
				    		</c:otherwise>
			    		</c:choose>
					</c:forEach>
				</select>
				<select id="width_tmp_select">
			  		<option id="width_tmp_option"></option>
				</select>
			    <input type="text" class="form-control" placeholder="Buscar Producto" id="pro_name" value="${s}">
			    <span class="input-group-btn">
			    	<button class="form-control" type="button" onclick="searchProduct()">
			        	<i class="fa fa-search"></i>
			      	</button>
			    </span>
			  </div>
			</form>
        </div>
        <div id="father-load">
		<div id="child-load">
	    <div class="row justify-content-center">
	        <div class="col-xl-9 col-md-8">
	        	<div id="main_notice" class="notice_container e_hidden">
   					<input type="button" onclick="hideNotice()">
                	<div id="notice" class="div_notice"></div>
        		</div>
	            <c:set var="productsList" scope="request" value="${productsList}"/>
	            <c:forEach var="product" items="${productsList}">
		        <!-- Item esto se pone en el for each-->
		        
	            <div class="d-sm-flex justify-content-between my-4 pb-4 border-bottom">
	                <div class="media d-block d-sm-flex text-center text-sm-left">
	                    <div class="media-body pt-3">
	                        <h2 class="">${product.proName}</h2>
	                        <div class="font-size-sm"><span class="text-muted mr-2">${product.proCategory.catName}</span><!-- Categoría--></div>
	                        <h4 class="font-size-lg text-primary pt-2">$${product.proPrice}</h4>
	                    </div>
	                </div>
	                <div class="pt-2 pt-sm-0 pl-sm-3 mx-auto mx-sm-0 text-center text-sm-left" style="max-width: 10rem;">
	                	<form id="pro-form-${product.proId}" style="position: relative; top: 15px;">
		                    <div class="form-group mb-2">
		                        <!--<label for="det_amount">Cantidad</label>-->
		                        <input class="form-control form-control-sm" type="hidden" name="det_amount" 
		                        	id="det_amount-${product.proId}" placeholder="1" value="1" min="0" 
		                        	step="1" onkeypress="return isNumberKey(this, event)"/>
		                        <input type="hidden" name="pro_price" value="${product.proPrice}"/>
		                        <input type="hidden" name="pro_id" value="${product.proId}"/>
		                    </div>
		                    <input type="button" class="btn btn-secondary" 
		                    	onclick="createDetail('pro-form-${product.proId}');" value="Agregar al Carrito" style="background-color: #60537e; color: #fff">
	                    </form>
	                </div>
	            </div>
	            <!-- Fin Item -->
		        </c:forEach>
		        <p>
					Página ${currentPage + 1} de ${maxPages + 1}
				</p>
        	</div>
		</div>
		<div class="row justify-content-center">
			<nav aria-label="Page navigation example">
			<ul class="pagination justify-content-center">
				<c:choose>
				<c:when test="${currentPage == 0}">
					<li class="page-item disabled">
						<a class="page-link" href="#" tabindex="-1">Anterior</a>
					</li>
				</c:when >
				<c:otherwise>
					<li class="page-item">
						<a class="page-link" href="#" onclick="loadNavPage('${s}', ${catId}, ${currentPage - 1}, event)">Anterior</a>
					</li>
				</c:otherwise>
				</c:choose>
				<c:forEach var="i" begin="${minP}" end="${maxP}">
					<c:choose>
					<c:when test="${currentPage == i}">
						<li class="page-item active"><a class="page-link" href="#" onclick="loadNavPage('${s}', ${catId}, ${i}, event)">${i + 1}</a></li>
					</c:when >
					<c:otherwise>
						<li class="page-item"><a class="page-link" href="#" onclick="loadNavPage('${s}', ${catId}, ${i}, event)">${i + 1}</a></li>
					</c:otherwise>
					</c:choose>
				</c:forEach>
				<c:choose>
				<c:when test="${currentPage == max}">
					<li class="page-item disabled">
						<a class="page-link" href="#" tabindex="-1">Siguiente</a>
					</li>
				</c:when >
				<c:otherwise>
					<li class="page-item">
						<a class="page-link" href="#" onclick="loadNavPage('${s}', ${catId}, ${currentPage + 1}, event)">Siguiente</a>
					</li>
				</c:otherwise>
				</c:choose>
			</ul>
		</nav>
	</div>
	</div>
	</div>
	</div>
	<script type="text/javascript">
		$(function () {
		    $("select#cat_id").change();
		});
	</script>
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