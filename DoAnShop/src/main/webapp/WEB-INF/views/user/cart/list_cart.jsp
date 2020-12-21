<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>
<head>
<title>List order</title>
</head>
<body>
	<br>
	<div class="container">
		 
		<h2 class="text-center">Your Order</h2>
		<table id="cart" class="table table-hover table-condensed">
			<thead>
				<tr>
					<th style="width: 50%">Name of food</th>     
					<th style="width: 10%">Price</th>     
					<th style="width: 8%">Amount</th>     
					<th style="width: 22%" class="text-center">Subtotal</th>     
					<th style="width: 10%"> </th>    
				</tr>
			</thead>
			  
			<tbody>

				<c:forEach var="item" items="${ Cart }">
					<tr>
						<td data-th="Product">    
							<div class="row">
								<div class="col-sm-2 hidden-xs">
									<img
										src="<c:url value="data:image/jpg;base64,${item.value.product.image}" />"
										alt="Sản phẩm 1" class="img-responsive" width="100">
								</div>
								     <br>
								<div class="col-sm-10">
									<br>
									<h4 class="nomargin">${item.value.product.name_Product }</h4>
									<p>${item.value.product.description }</p>
								</div>
							</div>    
						</td>    
						<td data-th="Price">${item.value.product.price }</td>    
						<td data-th="Quantity"><input
							class="form-control text-center" id="quanty-cart-${item.key}" value="${item.value.quanty }"
							min="0" type="number">    </td>    
						<td data-th="Subtotal" class="text-center">${item.value.totalPrice }</td>
						   
						<td class="actions" data-th=""><button class="btn btn-info btn-sm edit-cart"
							 data-id="${item.key}"> <i class="fa fa-edit"></i></button><a
							class="btn btn-danger btn-sm" type="button"
							href="<c:url value="/DeleteCart/${item.key}" />"> <i
								class="fa fa-trash-o"></i></a>    </td>   
					</tr>
			</tbody>
			</c:forEach>
			<tfoot>
				<tr class="visible-xs">
					<td class="text-center"><strong>Quanty:
							${TotalQuantyCart }</strong></td>
				</tr>
				<tr>
					<td><a href="<c:url value="/menu" />" class="btn btn-warning"><i
							class="fa fa-angle-left"></i> Order more dishes</a></td>     
					<td colspan="2" class="hidden-xs"> </td>     
					<td class="hidden-xs text-center"><strong>Total
							Price: ${TotalPriceCart }</strong>     </td>     
					<td><a href="<c:url value="/checkout" />" class="btn btn-success btn-block">Payment
							order <i class="fa fa-angle-right"></i>
					</a></td>    
				</tr>
			</tfoot>
		</table>
	</div>
	
	<content tag="script">
	<script>
		$(".edit-cart").on("click", function(){
			var id = $(this).data("id");
			var quanty = $("#quanty-cart-"+id).val();
			window.location = "EditCart/"+id+"/"+quanty;
		});
	</script>
	</content>
	
</body>