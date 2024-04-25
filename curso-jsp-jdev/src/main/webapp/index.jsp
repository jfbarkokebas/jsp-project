<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">

<title>Curso JSP Jdev</title>

<style type="text/css">
	*{
	margin:0;
	padding:0;
	box-sizing: border-box;
	}

	.body-login{
		width:100%;
		height: 100vh;
		display:flex;
		align-items: center;
		justify-content: center;
 	}
	.main-area{
		width: 300px;
		padding: 1rem;
		border: 1px solid grey;
		border-radius: 6px;
	}
	
	.error-message{
		color: orange;
		font-weight: bold;
	}


</style>
</head>
<body class="body-login">
	
	<div class="main-area">
		<h1 class="h2">Entrar no sistema</h1>
		
		<form action="servletlogin" method="post">
			<input type="hidden" value="<%= request.getParameter("url") %>" name="url">
			<div class="mb-3">
				<label for="exampleInputEmail1" class="form-label">Login </label> 
				<input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="login">
				<div id="emailHelp" class="form-text">
				Não compartilhe seus dados com ninguém<br>
				<span class="error-message">${msg}</span>
				</div>
			</div>
			<div class="mb-3">
				<label for="exampleInputPassword1" class="form-label">Password</label>
				<input type="password" class="form-control" id="exampleInputPassword1" name="senha">
			</div>
			<div class="mb-3 form-check">
				<input type="checkbox" class="form-check-input" id="exampleCheck1">
				<label class="form-check-label" for="exampleCheck1">Check me out</label>
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>

	</div>


	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
</body>
</html>