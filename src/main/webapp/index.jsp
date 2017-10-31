<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title>Java servlet + jsp</title>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
</head>
<body>
<div class="container">
	<nav class="navbar navbar-inverse">
		<a class="navbar-brand" href="#">CRUD Java Servlet</a>
		<ul class="nav navbar-nav">
			<li>
				<a href="/mahasiswa">Master Mahasiswa</a>
			</li>
			<li>
				<a href="/jurusan">Master Jurusan</a>
			</li>
			<li>
				<a href="/transaksikrs">Master Matakuliah</a>
			</li>
		</ul>
	</nav>
    <div class="jumbotron">
        <h1>Hello, world!</h1>
        <p>Ini adalah contoh sederhana Web CRUD yang dibuat menggunakan <b>Java servlet + JSP (Java server pages)</b>  </p>
        <p><a class="btn btn-primary btn-lg" href="#" role="button">Learn more</a></p>
    </div>
</div>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
        integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
        crossorigin="anonymous"></script>
</body>
</html>
