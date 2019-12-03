<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Page</title>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>

	<form action="registerUser" method="post">
		<pre>
			ID : <input type="text" name="id" id="id" /> <span id="msgBox"></span>
			Name : <input type="text" name="name" />
			Email : <input type="text" name="email" />
			<input type="submit" value="Register" name="register" />
		</pre>
	</form>
	<br/>
	${result}

</body>

<script>

$(document).ready(function(){
	
	$("#id").change(function(){
		$.ajax({
			'url': 'validateEmail',
			'data' : {id : $("#id").val()},
			'success' : function(responseText) {
				if(responseText != ""){
					$("#msgBox").text(responseText);
					$("#id").focus();
					$("#id").select();
				}else {
					$("#msgBox").text("")
				}
			}
			
		});
	});
	
});

</script>
</html>