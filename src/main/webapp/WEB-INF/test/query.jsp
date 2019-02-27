<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%  String context =request.getContextPath();  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询</title>
</head>
<body>
<form action="<%=context%>/test/result" method="POST">
	<input name="id" type="text" value="153016" /><br />
	<input type="submit" value="submit" />
</form>

</body>
</html>