<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign Up</title>


<style>
body {
	font-family: Arial, Helvetica, sans-serif;
	background-color: #eee;
}

container {
	style ="background-color: #f1f1f1";
	text-align: center;
}

.fant {
	font-family: 'Open Sans', sans-serif;
}

#wrapper {
	width: 500px;
	height: 50%;
	overflow: hidden;
	border: 0px solid #000;
	margin: 50px auto;
	padding: 10px;
}

.main-content {
	width: 250px;
	height: 40%;
	margin: 10px auto;
	background-color: #fff;
	border: 2px solid #e6e6e6;
	padding: 40px 50px;
}

.header {
	border: 0px solid #000;
	margin-bottom: 5px;
}

.header img {
	height: 80px;
	width: 250px;
	margin: 0px;
	position: relative;
	left: 40px;
	float: left;
}

.input-1, .input-2 {
	width: 100%;
	margin-bottom: 5px;
	padding: 8px 12px;
	border: 1px solid #dbdbdb;
	box-sizing: border-box;
	border-radius: 3px;
}

.overlap-text {
	position: relative;
}

.overlap-text a {
	position: absolute;
	top: 8px;
	right: 10px;
	color: #003569;
	font-size: 14px;
	text-decoration: none;
	font-family: 'Overpass Mono', monospace;
	letter-spacing: -1px;
}

btn {
	width: 100%;
	background-color: #3897f0;
	border: 1px solid #3897f0;
	padding: 5px 12px;
	color: #fff;
	font-weight: bold;
	cursor: pointer;
	border-radius: 3px;
}

btn:hover {
	opacity: 0.8;
}

.sub-content {
	width: 250px;
	height: 40%;
	margin: 10px auto;
	border: 1px solid #e6e6e6;
	padding: 20px 50px;
	background-color: #fff;
}

.s-part {
	text-align: center;
	font-family: 'Overpass Mono', monospace;
	word-spacing: -3px;
	letter-spacing: -2px;
	font-weight: normal;
}

.s-part a {
	text-decoration: none;
	cursor: pointer;
	color: #3897f0;
	font-family: 'Overpass Mono', monospace;
	word-spacing: -3px;
	letter-spacing: -2px;
	font-weight: normal;
}
</style>
</head>

<body>
	<form action="Authenticate" method ="post">
		<div id="wrapper">
			<div class="main-content">
				<h2 class="fant">Flight Search Util</h2>
				<div class="l-part">
					<input type="text" placeholder="Enter username" name="uname"
						class="input-1" required />
					<div class="overlap-text">
						<input type="password" placeholder="Enter password" name="pass"
							class="input-2" required /> <a href="forgot.jsp">Forgot?</a>
					</div>
					<button type="submit" class="btn">Log in</button>
				</div>
			</div>
		</div>
	</form>
</body>

</html>