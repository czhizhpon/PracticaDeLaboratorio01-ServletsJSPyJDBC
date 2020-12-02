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
    <script src="/sgrc/js/crud_bill.js"></script>

    <title>Pedidos</title>
</head>
<body class="">
   <section class="container text-center col-11">
   	<div class="row justify-content-center">
    	<div class="col-xl-6 col-lg-12">
    		<form class="text-left main-form my-search-form" onsubmit="searchBill(); return false;">
                <div class="row justify-content-center form-group">
                    <label for="email-input" class="col-form-label col-md-3 col-12">Buscar Pedido:</label>    
                    <input id="email-input" name="email-input" class="form-control col-md-8 col-11" 
                    	type="text" placeholder="Ingresar un correo" value="${s}">
                    <input type="button" class="search-icon btn col-1" onclick="searchBill()">
                </div>
            </form>
            <div id="main_notice" class="notice_container e_hidden">
   				<input type="button" onclick="hideNotice()">
                <div id="notice" class="div_notice"></div>
      		</div>
    		<div class="table-responsive" id="bill-list">
			  <table class="table table-striped" id="bill-content">
			    <thead class="thead-dark">
			      <tr>
			      	<th scope="col">Correo</th>
			      	<th scope="col">Fecha</th>
			        <th scope="col">Subtotal</th>
			        <th scope="col">IVA</th>
			        <th scope="col">Total</th>
			        <th scope="col">Detalle</th>
			        <th scope="col" colspan="2">Acciones</th>
			      </tr>
			    </thead>
			    <tbody>
			    <c:set var="billHeads" scope="request" value="${billHeads}"/>
			    <c:forEach var="billHead" items="${billHeads}">
			      <tr>
			        <td>${billHead.heaUser.useEmail}</td>
			        <td>${billHead.heaDate.time}</td>
			        <td>${billHead.heaSubtotal}</td>
			        <td>${billHead.heaVat}</td>
			        <td>${billHead.heaTotal}</td>
			        <td><button class="btn btn-outline-secondary" onclick="showDetail(${billHead.heaId})">Ver Detalle</button></td>
			        <c:choose>
			        <c:when test="${billHead.heaStatus eq 'R'.charAt(0)}">
			        <td><button class="btn btn-success" role="button" onclick="updateBill('A', ${billHead.heaId})">Aprobar</button></td>
			        <td><button class="btn btn-danger" role="button" onclick="updateBill('D', ${billHead.heaId})">Rechazar</button></td>
			      	</c:when>
			      	<c:when test="${billHead.heaStatus eq 'A'.charAt(0)}">
			      	<td><button class="btn btn-outline-success disabled" role="button">Aprobado</button></td>
			        <td><button class="btn btn-danger" role="button" onclick="updateBill('D', ${billHead.heaId})">Rechazar</button></td>
			      	</c:when>
			      	<c:when test="${billHead.heaStatus eq 'D'.charAt(0)}">
			      	<td><button class="btn btn-success" role="button" onclick="updateBill('A', ${billHead.heaId})">Aprobar</button></td>
			        <td><button class="btn btn-outline-danger disabled " role="button">Rechazado</button></td>
			      	</c:when>
			      	</c:choose>
			      </tr>
		      	</c:forEach>
			    </tbody>
			  </table>
			</div>
    	</div>
    	<div class="col-xl-5 col-lg-10 col-10 invisible" style="position: relative; top: 25px;" id="bill-details">
    		<div class="row justify-content-end">
    			<button type="button" class="my-close-btn-circle my-table-close" onclick="hideDetail()"></button>
   			</div>
   			<div class="row" id="detail-list">
	    		<div class="table-responsive" id="detail-content">
				  <table class="table table-striped">
				    <thead class="thead-dark">
				      <tr>
				      	<th scope="col">Producto</th>
				      	<th scope="col">Cantidad</th>
				        <th scope="col">Precio Unitario</th>
				        <th scope="col">Subtotal</th>
				      </tr>
				    </thead>
				    <tbody>
				    <c:set var="bhr" scope="request" value="${billHeadRead}"/>
				    <c:forEach var="detail" items="${bhr.heaBillDetails}">
				      <tr>
				        <td>${detail.detProduct.proName}</td>
				        <td>${detail.detAmount}</td>
				        <td>${detail.detUnitPrice}</td>
				        <td>${detail.detTotal}</td>
				      </tr>
				      </c:forEach>
				    </tbody>
				  </table>
				</div>
			</div>
    	</div>
   	</div>
    </section>
</body>
</html>