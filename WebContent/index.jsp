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
    <!-- <link rel="stylesheet" href="/sgrc/css/bootstrap/mdb.min.css">-->
    
    
    <link rel="stylesheet" href="/sgrc/css/main.css">
    <link rel="stylesheet" href="/sgrc/css/my_forms.css">
    <link rel="stylesheet" href="/sgrc/css/index.css">

    <script src="/sgrc/js/bootstrap/jquery-3.5.1.min.js"></script>
    <script src="/sgrc/js/bootstrap/popper.min.js"></script>
    <script src="/sgrc/js/bootstrap/bootstrap.min.js"></script>
    <script src="/sgrc/js/bootstrap/all.min.js"></script>
    
    <script src="/sgrc/js/functions.js"></script>

</head>
<body>
	<header>
       	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
      		<div class="container col-10">
        		<a class="navbar-brand" href="/sgrc/">Requerimientos de Compra</a>
        		<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbar" aria-controls="navbar" aria-expanded="false" aria-label="Toggle navigation">
          			<span class="navbar-toggler-icon"></span>
        		</button>

		        <div class="collapse navbar-collapse" id="navbar">
	          		<ul class="navbar-nav mr-auto">
			            <li class="nav-item">
			              <a class="nav-link active" href="/sgrc/">Inicio</a>
			            </li>
		            
			            <li class="nav-item ">
			              <a class="nav-link text-nowrap" href="#">Mis Pedidos</a>
			            </li>
	          		</ul>
		            <form class="mx-2 my-auto d-inline w-50" style="min-width: 100px">
		            	<div class="input-group">
		                	<input class="form-control my-search-input" type="search" placeholder="Buscar Productos" aria-label="Search"/>
		                	<span class="input-group-append">
		                		<input type="button" class="search-icon-light">
                			</span>
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
			              	<img src="/sgrc/img/icons/user_icon.svg" style="width:30px"> <span>&ensp;Mi Cuenta</span>
			              </a>
			              <div class="dropdown-menu dropdown-menu-right dropdown-default" aria-labelledby="drop_session">
			                <a class="dropdown-item" href="#">Cerrar Sesión</a>
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
					<h2>Bienvenido</h2>
					<p>
						Realiza tus requerimientos de compras Aquí
					</p>
					<button type="button" class="btn btn-primary">Comprar</button>
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
		<div class="row justify-content-center my-section-dark">
			<div class="col-10">
			    <div class="scrolling-wrapper text-center ">
			    	<!-- Item -->
			        <div class="card" style="width: 18rem;">
					  <div class="card-body">
					    <h5 class="card-title">Card title</h5>
					    <h6 class="card-subtitle mb-2 text-muted">Card subtitle</h6>
					   	<h6>$34.99</h6>
					    <a href="#" class="btn btn-primary">Agregar</a>
					  </div>
					</div>
					<!--Fin item-->
					<!-- Item -->
			        <div class="card" style="width: 18rem;">
					  <div class="card-body">
					    <h5 class="card-title">Card title</h5>
					    <h6 class="card-subtitle mb-2 text-muted">Card subtitle</h6>
					   	<h6>$34.99</h6>
					    <a href="#" class="btn btn-primary">Agregar</a>
					  </div>
					</div>
					<!--Fin item-->
					<!-- Item -->
			        <div class="card" style="width: 18rem;">
					  <div class="card-body">
					    <h5 class="card-title">Card title</h5>
					    <h6 class="card-subtitle mb-2 text-muted">Card subtitle</h6>
					   	<h6>$34.99</h6>
					    <a href="#" class="btn btn-primary">Agregar</a>
					  </div>
					</div>
					<!--Fin item-->
					<!-- Item -->
			        <div class="card" style="width: 18rem;">
					  <div class="card-body">
					    <h5 class="card-title">Card title</h5>
					    <h6 class="card-subtitle mb-2 text-muted">Card subtitle</h6>
					   	<h6>$34.99</h6>
					    <a href="#" class="btn btn-primary">Agregar</a>
					  </div>
					</div>
					<!--Fin item-->
					<!-- Item -->
			        <div class="card" style="width: 18rem;">
					  <div class="card-body">
					    <h5 class="card-title">Card title</h5>
					    <h6 class="card-subtitle mb-2 text-muted">Card subtitle</h6>
					   	<h6>$34.99</h6>
					    <a href="#" class="btn btn-primary">Agregar</a>
					  </div>
					</div>
					<!--Fin item-->
					
			    </div>
			</div>
		</div>
	</section>
	<section class="container" style="margin-top: 50px">
		<div class="row justify-content-center">
			<div class="col-12">
			    <div class="scrolling-wrapper text-center">
			    	<!-- Item -->
			       	<div class="card" style="width: 18rem;">
						<img src="" class="card-img-top" alt="Bryan Sarmiento Imagen">
			  			<div class="card-body">
					    	<h5 class="card-title">Bryan Sarmiento</h5>
					    	<p class="card-text">Algún Texto.</p>
					  	</div>
					  	<ul class="list-group list-group-flush">
					    	<li class="list-group-item ">
					    		<a href="tel:+539 9999 99999" class="card-link">+539 9999 99999</a>
					    	</li>
					    	<li class="list-group-item">
					    		<a href="mailto:dsarmientob1@est.ups.edu.ec" class="card-link">dsarmientob1@est.ups.edu.ec</a>
				    		</li>
					  	</ul>
					</div>
					<!--Fin item-->
					<!-- Item -->
			       	<div class="card" style="width: 18rem;">
						<img src="" class="card-img-top" alt="Roberto Serpa Imagen">
			  			<div class="card-body">
					    	<h5 class="card-title">Roberto Serpa</h5>
					    	<p class="card-text">Algún Texto.</p>
					  	</div>
					  	<ul class="list-group list-group-flush">
					    	<li class="list-group-item ">
					    		<a href="tel:+539 9999 99999" class="card-link">+539 9999 99999</a>
					    	</li>
					    	<li class="list-group-item">
					    		<a href="mailto:dsarmientob1@est.ups.edu.ec" class="card-link">rserpa@est.ups.edu.ec</a>
				    		</li>
					  	</ul>
					</div>
					<!--Fin item-->
					<!-- Item -->
			       	<div class="card" style="width: 18rem;">
						<img src="" class="card-img-top" alt="Eduardo Zhizhpon Imagen">
			  			<div class="card-body">
					    	<h5 class="card-title">Eduardo Zhizhpon</h5>
					    	<p class="card-text">Algún Texto.</p>
					  	</div>
					  	<ul class="list-group list-group-flush">
					    	<li class="list-group-item ">
					    		<a href="tel:+539939446883" class="card-link">+539 9394 46883</a>
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
            <h6 class="text-uppercase font-weight-bold">Beinvenido o Nombre de la companía</h6>
            <hr class="deep-purple accent-2 mb-4 mt-0 d-inline-block mx-auto" style="width: 60px;">
            <p>
            	Logo
            </p>

          </div>
          <!-- Grid column -->

          <!-- Grid column -->
          <div class="col-md-2 col-lg-2 col-xl-2 mx-auto mb-4">

            <!-- Links -->
            <h6 class="text-uppercase font-weight-bold">Productos</h6>
            <hr class="deep-purple accent-2 mb-4 mt-0 d-inline-block mx-auto" style="width: 60px;">
            <p>
              <a href="#!">Solicitar</a>
            </p>
            <p>
              <a href="#!">Mis Pedidos</a>
            </p>
          </div>
          <!-- Grid column -->

          <!-- Grid column 
          <div class="col-md-3 col-lg-2 col-xl-2 mx-auto mb-4">

            <!-- Links 
            <h6 class="text-uppercase font-weight-bold">Administrador</h6>
            <hr class="deep-purple accent-2 mb-4 mt-0 d-inline-block mx-auto" style="width: 60px;">
            <p>
              <a href="#!">Usuarios</a>
            </p>
            <p>
              <a href="#!">Productos</a>
            </p>
            <p>
              <a href="#!">Pedidos</a>
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
      </div>
      <!-- Copyright -->

    </footer>
<!-- Footer -->
</body>
</html>