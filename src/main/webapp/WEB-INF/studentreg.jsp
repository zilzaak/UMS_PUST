<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color:brown;" >

<div align="center">
<h1>student registration form</h1> <br/>
<h1> enter your information</h1> <br/>
   ${sms}
<form action="regstudent" method="get" modelAttribute="Student">
Name:<input type="text" name="name"/> <br/>
Dept:<input type="text" name="dept"/> <br/>
Roll:<input type="text" name="roll"/> <br/>
email:<input type="text" name="email"/> <br/>
Password:<input type="text" name="password"/>  <br/>
   
   <input type="submit" name="save"/>
      
   <input type="reset" name="clear"/>
</form>

</div>
</body>
</html>