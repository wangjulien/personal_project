<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit Client</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"></script>

</head>
<body>
	<div class="container">
		<table class="table table-striped">

			<c:forEach var="client" items="${cleclients}">
				<tr scope="row">
					<td scope="col">nom</td>
					<td><c:out value="${client.nom}" /></td>
					<form action='editLoginClient' method='GET'>
						<td><a
							href="${pageContext.request.contextPath}/editLoginClient?idC=${client.id}">Edit</a></td>
					</form>
				</tr>

				<tr scope="row">
					<td>name</td>
					<td><c:out value="${client.nom}" /></td>
				</tr>
				<tr scope="row">
					<td>firstname</td>
					<td><c:out value="${client.prenom}" /></td>

				</tr>
				<tr scope="row">
					<td></td>
					<td><c:out value="   " /></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<form action="<c:url value='/editClients' />" method='GET'>
		<input type='submit' value='retour'>
	</form>
</body>
</html>