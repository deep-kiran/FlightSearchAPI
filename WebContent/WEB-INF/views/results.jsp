<%@ page import="java.io.*,java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Flights</title>

<style>
table, th, td {
	border: 3px solid black;
	border-collapse: collapse;
}

th, td, tr {
	text-align: center;
}

body {
	font-family: Arial, Helvetica, sans-serif;
	background-image: url("/WEB-INF/images/clouds.jpg");
	background-color:#09CEF3;
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

.btn {
	width: 100%;
	background-color: #555555;
	border: 1px solid #3897f0;
	padding: 5px 12px;
	color: #fff;
	font-weight: bold;
	cursor: pointer;
	border-radius: 3px;
}

.btn:hover {
	opacity: 0.9;
}

.btn2 {
	width: 12.5%;
	background-color: #555555;
	border: 1px solid #3897f0;
	padding: 5px 12px;
	color: #fff;
	font-weight: bold;
	cursor: pointer;
	border-radius: 3px;
}

.btn2:hover {
	opacity: 0.9;
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

	<center>
		<h3 style="color: #fff">Welcome ${username}</h3>
	</center>
	<form action="LogOut" method="get">
		<button type="submit" class="btn2" style="float: right">Log
			Out</button>
	</form>

	<form action="search" method="post">
		<div id="wrapper">
			<div class="l-part">
				<input type="text" placeholder="From" name="from" id="from"
					class="input-1" required /> <br> <input type="text"
					placeholder="To" name="to" id="to" class="input-1" required /> <br>

				<input type="text" placeholder="DD-MM-YYYY" class="input-1"
					name="date" id="date" required> </br> <select name="flightclass"
					class="input-1" required>
					<option value="" disabled selected>Select your flight class</option>
					<option value="E">Economic</option>
					<option value="B">Business</option>
				</select> <select name="flightpref" class="input-1" required>
					<option value="" disabled selected>Select your output preference</option>

					<option value="fare">Sort by fare</option>
					<option value="both">Sort by fare and duration</option>
				</select>


			</div>

			<input type="submit" class="btn" value="Search">
		</div>
	</form>

	<table style="width: 100%">
		<tr>
			<th scope="col">#</th>
			<th scope="col">From</th>
			<th scope="col">To</th>
			<th scope="col">Flight No</th>
			<th scope="col">Valid Till</th>
			<th scope="col">Flight Time</th>
			<th scope="col">Flight Duration</th>
			<th scope="col">Fare</th>
			<th scope="col">Seat Availability</th>
			<th scope="col">Flight Class</th>
		</tr>
		<%
			int counter = 1;
		%>
		<c:forEach var="listElement" items="${searchresults}">

			<tr>
				<th scope="row"><%=counter%></th>
				<td>${listElement.depLoc}</td>
				<td>${listElement.arrLoc}</td>
				<td>${listElement.flightNo}</td>
				<td>${listElement.validTill}</td>
				<td>${listElement.flightTime}</td>
				<td>${listElement.flightDur}</td>
				<td>${listElement.fare}</td>
				<td>${listElement.seatavl}</td>
				<td>${listElement.flightClass}</td>
			</tr>
			<%
				counter++;
			%>
		</c:forEach>
		</tbody>
	</table>

</body>

</html>