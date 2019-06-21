<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color:brown;">
<div align="center">
<h1>student login form</h1>
<bold>${sms}</bold>
<form action="loginstudent" method="post">
Username:<input type="text" name="name"/><br/>
Password:<input type="password" name="password"/><br/>
<input type="submit" name="submit"/><br/>
</form>
</div>
<div align="center">
<P style="color:black"><big>NOT REGISTERED YET AS PATIENT????</big></h1>
 <a href="${pageContext.request.contextPath}/choice?operation=studentreg">CLICK TO REGISTER</a>
</div>
</body>
</html>