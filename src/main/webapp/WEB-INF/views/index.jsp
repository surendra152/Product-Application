<html>
<head>
<%@include file="./base.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

</head>
<body>
	<div class="container mt-3">

		<div class="row">

			<div class="col-md-12">
				<h1 class="text-center mb-3">Welcome to product App</h1>

				<table class="table">
					<thead class="thead-dark">
						<tr>
							<th scope="col">ID</th>
							<th scope="col">Product Name</th>
							<th scope="col">Product Description</th>
							<th scope="col">Price</th>
							<th scope="col">Action</th>
						</tr>
					</thead>
					<tbody>
					
					<c:forEach items="${product }" var="p">
						<tr>
							<th scope="row">${p.id }</th>
							<td>${p.name }</td>
							<td>${p.description }</td>
							<td class="font-weight-bold">&#x20B9;${p.price }</td>
							<td>
							<a href="delete/${p.id }"><i class="fa-solid fa-trash-can text-danger" style="font-size: 30px"></i></a>
							<a href="update/${p.id }"><i class="fa-solid fa-pen-nib text-primary" style="font-size: 30px"></i></a>
							</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>

				<table class="table">
					<thead class="thead-light">
						<tr>
							<th scope="col">#</th>
							<th scope="col">First</th>
							<th scope="col">Last</th>
							<th scope="col">Handle</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<th scope="row">1</th>
							<td>Mark</td>
							<td>Otto</td>
							<td>@mdo</td>
						</tr>
						<tr>
							<th scope="row">2</th>
							<td>Jacob</td>
							<td>Thornton</td>
							<td>@fat</td>
						</tr>
						<tr>
							<th scope="row">3</th>
							<td>Larry</td>
							<td>the Bird</td>
							<td>@twitter</td>
						</tr>
					</tbody>
				</table>

				<div class="container text-center">

					<a href="add-product" class="btn btn-outline-success">Add
						Product</a>

				</div>
			</div>

		</div>


	</div>
</body>
</html>
