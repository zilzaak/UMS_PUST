<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="<c:url value="/static/theme/bootstrap.min.css" /> " rel="stylesheet">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script> -->
  <script src="<c:url value="/static/theme/jquery311.js" />" > </script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>

  <script src="<c:url value="/static/theme/bootstrap.min.js" />" > </script>
<script type="text/javascript">
function validate(){
	
	if(document.myform.name.value==""){
		alert("fillup the name field");
		document.myform.name.focus();
		return false;
	}
	if(document.myform.schedule.value==""){
		alert("fillup the schedule field");
		document.myform.schedule.focus();
		return false;
	}
	if(document.myform.drphone.value.length!="11"){
		alert("phone number is invalid");
		document.myform.drphone.focus();
		return false;
	}
	
	return(true);
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head>
<body style="background-color:cornsilk;">
<div align="center">
<span class="border border-warning">
<h1>doctor registration form</h1> <br/>
      ${sms}
<h1> enter your information</h1> <br/>
</span>

<form name="myform" onsubmit="return(validate());" action="regdoctor" modelAttribute="Doctor">
<table cellspacing="2" cellpadding="2" border="2" >
<tr>
<td align="right">Name:</td>
<td style="width:400px;"><input type="text" name="name"/></td>
<td><i class="fa fa-user" aria-hidden="true"></i></td>
</tr>
<tr>
<td align="right">AGE:</td>
<td style="width:400px;"><input type="text" name="age"/> <br/></td>

</tr>
<tr>
<td align="right">Degree</td>
<td style="width:400px;"><input type="text" name="degree"/></td>
<td><i class="fa fa-graduation-cap" aria-hidden="true"></i></td>
</tr>
<td align="right">Expert in</td>
<td style="width:400px;"><input type="text" name="expertint"/></td>
<td><i class="fa fa-flask" aria-hidden="true"></i></td>
<tr>
<td align="right">Schedule</td>
<td style="width:400px;">
<select name="schedule">
<option value="8am-4pm">8am-4pm</option>
<option value="9am-5pm">9am-5pm</option>
<option value="10am-6pm">10am-6pm</option>
<option value="11am-7pm">11am-7pm</option>
<option value="12am-8pm">12am-8pm</option>
<option value="1am-9pm">1am-9pm</option>
</select>
</td>
<td><i class="fa fa-clock-o fa-lg" aria-hidden="true"></i></td>
</tr>
<tr>
<td align="right">phone number</td>
<td style="width:400px;"><input type="text" name="drphone"/></td>
<td><i class="fa fa-phone-square fa-lg" aria-hidden="true"></i>
</td>
</tr>
<tr>
<td align="right">Password</td>
<td style="width:400px;"><input type="text" name="password"/></td>
<td><i class="fa fa-unlock-alt" aria-hidden="true"></i></td>
</tr>
<tr>
<td align="right">submit</td>
<td style="width:400px;"><input type="submit" name="save"/></td>
</tr>
</table>

</form>

</div>

</div>
</body>
</html>