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
			<div class="form-group col-12">
			  <div class="input-group">
				<c:set var="categories" scope="request" value="${categories}"/>
				<c:set var="minP" scope="request" value="${min}"/>
				<c:set var="maxP" scope="request" value="${max}"/>
				<c:set var="maxPages" scope="request" value="${maxPages}"/>
				<c:set var="currentPage" scope="request" value="${currentPage}"/>
				<c:set var="s" scope="request" value="${s}"/>
		        <c:set var="catId" scope="request" value="${catId}"/>
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
			</div>
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
	                	<form id="pro-form-${product.proId}">
		                    <div class="form-group mb-2">
		                        <!--<label for="det_amount">Cantidad</label>-->
		                        <input class="form-control form-control-sm" type="hidden" name="det_amount" 
		                        	id="det_amount-${product.proId}" placeholder="1" value="1" min="0" 
		                        	step="1" onkeypress="return isNumberKey(this, event)"/>
		                        <input type="hidden" name="pro_price" value="${product.proPrice}"/>
		                        <input type="hidden" name="pro_id" value="${product.proId}"/>
		                    </div>
		                    <input type="button" class="btn btn-outline-secondary btn-sm btn-block mb-2" 
		                    	onclick="createDetail('pro-form-${product.proId}');" value="Agregar al Carrito">
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
</body>
</html>