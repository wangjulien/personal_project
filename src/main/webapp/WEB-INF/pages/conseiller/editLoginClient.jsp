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
Edition Client Id : ${client.id}
		<tr scope="row">
			<td scope="col">prenom</td>
			<td></td>
			<form action='editedLogin' method='POST'>
				<td><input type=text size=60 name='logedit'
					value="${client.prenom}"></td>
				<td><input type=hidden size=60 name='idmod'
					value="${client.id}"></td> <input type='submit'
					value='soumettre'>
			</form>
		</tr>
		<tr scope="row">
			<td scope="col">nom</td>
			<td></td>
			<form action='editedLogin' method='POST'>
				<td><input type=text size=60 name='logedit'
					value="${client.nom}"></td>
				<td><input type=hidden size=60 name='idmod'
					value="${client.id}"></td> <input type='submit'
					value='soumettre'>
			</form>
		</tr>

<tr scope="row">
			<td scope="col">Adresse [Rue]</td>
			<td></td>
			<form action='editedLogin' method='POST'>
				<td><input type=text size=60 name='rueedit'
					value="${client.adresse}"></td>
				<td><input type=hidden size=60 name='idmod'
					value="${client.id}"></td> <input type='submit'
					value='soumettre'>
			</form>
		</tr>
		</table>
	</div>
	<form action="<c:url value='/editClients' />" method='GET'>
		<input type='submit' value='retour index'>
	</form>
</body>
</html>